package com.example.beehelp

import android.content.Intent
import android.net.Uri
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavHostController
import com.example.beehelp.ui.theme.azoft
import com.example.beehelp.ui.theme.monst

data class DataPchel(
    @DrawableRes val imageResource: Int,
    val title: String,
    val description: String,
    val link:String
)

@Composable
fun WebViewScreen(url: String) {
    val context = LocalContext.current
    AndroidView(
        factory = { context ->
            WebView(context).apply {
                webViewClient = WebViewClient()
                loadUrl(url)
            }
        },
        update = { webView ->
            webView.loadUrl(url)
        }
    )
}

@Composable
fun PchelScreen(recipe: Recipe, modifier: Modifier, navController:NavHostController) {
    val context = LocalContext.current
    Box(
        modifier = Modifier
            .background(colorResource(R.color.BlackGray))
            .fillMaxSize()
            .padding(bottom = if (recipe == defaultPchel[7]) 70.dp else 10.dp),
        contentAlignment = Alignment.Center
    ) {
        Surface(
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .padding(16.dp)
                .clickable {
                    val encodedLink = Uri.encode(recipe.link)
                    navController.navigate("webview/${encodedLink}")
                           },
            shadowElevation = 8.dp,
        ) {
            val image = painterResource(recipe.imageResource)
            Column(modifier = Modifier.fillMaxWidth()) {
                Image(
                    painter = image,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(154.dp),
                    contentDescription = "image"
                )
                Column(modifier = Modifier.padding(12.dp)) {
                    Text(
                        text = recipe.title,
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.padding(bottom = 4.dp),
                        fontFamily = monst
                    )
                    Text(recipe.description, style = MaterialTheme.typography.labelSmall)
                }
            }
        }
    }
}


@Composable
fun PchelList(DataPchel: List<Recipe>, navController: NavHostController) {
    LazyColumn {
        items(DataPchel) { item ->
            PchelScreen(item, Modifier.padding(16.dp), navController)
        }
    }
}


val defaultPchel = listOf(
    Recipe(R.drawable.srednrus, "Среднерусские пчёлы", "Второе название среднерусских пчёл – темные европейские. Это аборигены центральной и северной Европы. Крупные насекомые темно-серой окраски. Устойчивы к заболеваниям и хорошо переносят морозы.", "https://ferma.expert/pchely/vidy/srednerusskaya-poroda-pchel/"),
    Recipe(R.drawable.orl, "Орловские пчёлы", "Это подвид среднерусской пчелы. Порода выведена в НИИ пчеловодства (Орловская опытная станция). Насекомые крупные, цвет шерстки – темно-серый. Достоинство породы – способность выдерживать самые суровые условия.", "https://beejournal.ru/razvedenie-i-soderzhanie/1208-tip-srednerusskikh-pchel-orlovskij"),
    Recipe(R.drawable.italy, "Итальянские пчёлы", "Насекомые весят 113-117 г. Окраска – желтая. Миролюбивы, производят много воска, роение – среднее. Склонны к воровству, свой улей активно защищают от воровок, борются с восковой молью. ", "https://ferma.expert/pchely/vidy/italyanskaya-poroda-pchyol/"),
    Recipe(R.drawable.karp, "Карпатские пчёлы", "Карпатки отличаются пепельной окраской и особо длинным хоботком – до 7 мм. У этой породы самые длинные крылья. Размер тела – средний.", "https://ferma.expert/pchely/vidy/karpatskaya-poroda-pchel/"),
    Recipe(R.drawable.vuxh, "Вучковские пчёлы", "Разновидность карпатской породы. Отличается более смирным темпераментом. Хоботок длиной 6,7 мм. Цвет тела – серый, впереди имеется серебристое опушение.", "https://ylejbees.com/911-karpatskie-pchely-tipa-vuchkovskij"),
    Recipe(R.drawable.kavkaz, "Кавказские пчёлы", "Районированы в Закавказье. Желтоватая окраска. Очень вороваты. Низкая морозостойкость. Матка приносит до 1700 яиц в день. Роение – сильное.", "https://ferma.expert/pchely/vidy/seraya-gornaya-kavkazskaya-pchela/"),
    Recipe(R.drawable.kuban, "Кубанские пчёлы", "Второе название – северокавказские. Это популяция желтой кавказской пчелы. На брюхе – желтые кольца. Очень теплолюбивы. Совершают зимние облеты. Миролюбивы, но не терпят маток других видов. Собирают много меда.", "https://www.kupi-uley.ru/articles/kubanskie-pchely.html"),
    Recipe(R.drawable.megrel, "Мегрельские пчёлы", "Второе название – грузинские пчелы. Это популяция кавказской породы, которая сегодня активно продвигается на север – мегрельские пчелы отличаются хорошей морозостойкостью.", "https://ylejbees.com/2031-megrelsgk"),
)