package com.example.beehelp

import android.content.Intent
import android.net.Uri
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
import androidx.navigation.NavHostController
import com.example.beehelp.ui.theme.azoft
import com.example.beehelp.ui.theme.monst

data class Recipe(
    @DrawableRes val imageResource: Int,
    val title: String,
    val description: String,
    val link:String
)

@Composable
fun HoneyScreen(recipe: Recipe, modifier: Modifier, navController: NavHostController) {
    val context = LocalContext.current


    Box(
        modifier = Modifier
            .background(colorResource(R.color.BlackGray))
            .fillMaxSize()
            .padding(bottom = if (recipe == defaultRecipes[19]) 70.dp else 10.dp),
        contentAlignment = Alignment.Center
    ) {
        Surface(
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.padding(16.dp).clickable{
                    val encodedLink = Uri.encode(recipe.link)
                    navController.navigate("webview/${encodedLink}")
                },
                shadowElevation = 8.dp,
            ) {
                val image = painterResource(recipe.imageResource)
                Column(modifier = Modifier.fillMaxWidth()) {
                    Image(
                        painter = image, contentScale = ContentScale.Crop, modifier = Modifier
                            .fillMaxWidth()
                            .height(154.dp), contentDescription = "image"
                    )
                    Column(modifier = Modifier.padding(12.dp)) {
                        Text(
                            recipe.title,
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
fun RecipeList(recipes: List<Recipe>, navController: NavHostController) {
    LazyColumn {
        items(recipes) { item ->
            HoneyScreen(item, Modifier.padding(16.dp), navController)
        }
    }
}


val defaultRecipes = listOf(
    Recipe(R.drawable.lipovyi, "Липовый мёд", "Вкус. Очень сладкий, с карамельными нотками. Польза. Нормализует пищеварение. укрепляет сетчатку глаз. нормализует липидный обмен. активизирует кровообращение. улучшает состояние кожи.", "https://mirpchely.ru/produkty-pchelovodstva/med/lipovyj"),
    Recipe(R.drawable.grech, "Гречишный мёд", "Вкус. Отличается крайне сладким вкусом. Его сладость переходит в терпкость." + "\nПольза. Рекомендуют при: малокровии. язвенной болезни. мокром кашле. авитаминозе. воспалительных процессах.", "https://mirpchely.ru/produkty-pchelovodstva/med/grechishnyj"),
    Recipe(R.drawable.kasht, "Каштановый мёд", "Вкус. Имеет терпкий и горьковатый привкус" + "\nПольза. Рекомендуют при: нефрите. цистите. сердечных заболеваниях. бронхитах", "https://mirpchely.ru/produkty-pchelovodstva/med/kashtanovyj"),
    Recipe(R.drawable.pods, "Подсолнечный мёд", "Вкус. Обладает фруктовым вкусом. Остается послевкусие – приторный вкус подсолнечниковых семечек." + "\nПольза. при заболеваниях дыхательной и сердечно-сосудистой системы. Удаляет из организма шлаки, оказывает мочегонный эффект.", "https://mirpchely.ru/produkty-pchelovodstva/med/podsolnechnika"),
    Recipe(R.drawable.padev, "Падевый мёд", "Вкус. Чаще всего мёд не сладкий, и даже горчит" + "\nПольза. Падевый мед – идеальная альтернатива биологическим добавкам. Используется в качестве профилактического средства нервных расстройств.", "https://mirpchely.ru/produkty-pchelovodstva/med/padevyj"),
    Recipe(R.drawable.kiprev, "Кипрейный мёд", "Вкус. Во вкусе чувствуются карамельные нотки" + "\nПольза. Богат витамином С. Отличное противопростудное средство. Но перед употреблением обязательна консультация с врачом – кипрейный мед ухудшает свертываемость крови. Оказывает успокаивающее и противовоспалительное действие.", "https://mirpchely.ru/produkty-pchelovodstva/med/kiprejnyj"),
    Recipe(R.drawable.cvetoch, "Цветочный мёд", "Вкус. Сладкий, с цветочным послевкусием" + "\nПольза. Тонизирует организм. Применяют при простудах, воспалениях дыхательных путей, бронхитах, ларингитах и т. д. Ускоряет метаболизм, полезен при нервных расстройствах, омолаживает и питает кожу, волосы.", "https://mirpchely.ru/produkty-pchelovodstva/med/tsvetochnyj"),
    Recipe(R.drawable.don, "Донниковый мёд", "Вкус. Сладкий, в послевкусии – легкая горчинка" + "\nПольза. Обладает антимикробным эффектом, способствует заживлению ран, предотвращая их нагноение.", "https://mirpchely.ru/produkty-pchelovodstva/med/donnikovyj"),
    Recipe(R.drawable.akaz, "Акациевый мёд", "Вкус. Сладкий на вкус, с цветочно-фруктовым послевкусием" + "\nПольза. Полезен при низком гемоглобине, простудах и нервных расстройствах. Снимает отеки, положительно влияет на почки и печень.", "https://mirpchely.ru/produkty-pchelovodstva/med/akacievyj"),
    Recipe(R.drawable.gorniy, "Горный мёд", "Вкус. Сладкий с горьковато-терпкими нотками." + "\nПольза. Содержит много витамина А и каротина. Очищает организм от токсинов, обладает успокоительным эффектом.", "https://mirpchely.ru/produkty-pchelovodstva/med/gornyj"),
    Recipe(R.drawable.madmed, "Дикий мёд", "Вкус. Вкус без приторности, с кислинкой." + "\nПольза. Стимулирует умственную деятельность, ускоряет обмен веществ, снимает воспаления.", "https://mirpchely.ru/produkty-pchelovodstva/med/dikij"),
    Recipe(R.drawable.sosnov, "Сосновый мёд", "Вкус. Обладает смолистым, горьковатым вкусом и специфическим хвойным ароматом" + "\nПольза.  Высокая концентрация калия – этот элемент полезен для сердца. Всегда жидкий — почти не засахаривается.", "https://tutknow.ru/meal/14895-sosnovyy-med-polza-vred-recepty-primenenie.html"),
    Recipe(R.drawable.may, "Майский мёд", "Вкус. Сладкий, без приторности. Фруктовые нотки в послевкусии." + "\nПольза. Бодрит, улучшает настроение. Лечит фурункулы, ускоряет метаболизм, полезен при нервных расстройствах, помогает при ангине, других болезнях горла.", "https://mirpchely.ru/produkty-pchelovodstva/med/majskij"),
    Recipe(R.drawable.kedr, "Кедровый мёд", "Вкус. Горчинка отсутствует. Послевкусие – хвойное." + "\nПольза. Помогает при дерматозах, болезнях дыхательных путей, при простудах, авитаминозах, ранах и ожогах, для массажа.", "https://mirpchely.ru/produkty-pchelovodstva/med/kedrovyj"),
    Recipe(R.drawable.sotov, "Сотовый мёд", "Вкус. Цвет, аромат и вкус сотового меда зависит от медоноса" + "\nПольза. Укрепляет иммунитет, лечит простуды, кишечные расстройства, гастриты, болезни печени, нервные расстройства. Воск, в котором хранится сотовый мед, хранит частицы пыльцы и прополиса. Жевание воска укрепляет десны и иммунную систему.", "https://mirpchely.ru/produkty-pchelovodstva/med/soty"),
    Recipe(R.drawable.cherniy, "Чёрный мёд", "Вкус. Во вкусе слегка выражена горчинка." + "\nПольза. Лечат заболевания дыхательной системы, обладает противовоспалительным эффектом, вызывает потогонный эффект, полезен при заболеваниях печени, желудка, желчного пузыря.", "https://mirpchely.ru/produkty-pchelovodstva/med/chernyj"),
    Recipe(R.drawable.saxar, "Сахарный мёд", "Вкус. Обычный сладкий вкус, нет послевкусия. " + "\nПольза. Такой продукт не является целебным. Ценности особой не представляет. Применяют его в основном для выпечки – вместо сахара.", "http://paseka.pp.ru/med-ispolzovanie-khimicheskij-sostav-sposoby-pererabotki/663-sakharnyj-med.html"),
    Recipe(R.drawable.orex, "Ореховый мёд", "Вкус. Вкус – с ореховыми нотками" + "\nПольза. Обладает уникальными свойствами – обезболивает, улучшает потенцию, оказывает противовоспалительный и антибактериальный эффект.", "https://moremeda.com/sorta-i-vidy-meda/orekhovyj-med"),
    Recipe(R.drawable.apple, "Яблочный мёд", "Вкус. Фруктовый яблочный мед – редкое лакомство. Горечи нет." + "\nПольза. В яблочном меде много железа, рутина, йода. Укрепляет иммунную систему, рекомендован при целлюлите и воспалениях. Омолаживает, отличный антиоксидант.", "https://behoneybee.ru/med/vidy/med-yablochnyj.html"),
    Recipe(R.drawable.tykva, "Тыквенный мёд", "Вкус. Сладкий, с ароматом тыквы" + "\nПольза. Обладает уникальными свойствами, рекомендуется при: болезнях печени и почек. ожирении. повышенном холестерине. алкогольной зависимости. ослабленном иммунитете. Противопоказан при сердечных заболеваниях, сахарном диабете и атеросклерозе.", "https://glav-dacha.ru/lechebnye-svoystva-tykvennogo-meda/"),
)
