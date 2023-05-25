package com.example.beehelp

import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.beehelp.ui.theme.azoft
import com.example.beehelp.ui.theme.golos
import com.example.beehelp.ui.theme.kard
import com.example.beehelp.ui.theme.monst
import com.example.beehelp.ui.theme.rostov
import com.example.beehelp.ui.theme.sansparty
import com.example.beehelp.ui.theme.webis


@Composable
fun CalendarScreen(navController: NavHostController) {
    val months = listOf("Январь", "Февраль", "Март", "Апрель", "Май", "Июнь", "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь")
    val links = listOf("https://moremeda.com/kalendar-pasechnika/yanvar-na-paseke-chto-nuzhno-sdelat-kakie-meropriyatiya-provesti-i-na-chto-obratit-vnimanie", "https://moremeda.com/kalendar-pasechnika/rabota-na-paseke-v-fevrale", "https://moremeda.com/kalendar-pasechnika/raboty-na-paseke-v-marte", "https://moremeda.com/kalendar-pasechnika/raboty-na-paseke-v-aprele", "https://moremeda.com/kalendar-pasechnika/kalendar-pasechnika-na-maj", "https://moremeda.com/kalendar-pasechnika/kakie-raboty-neobxodimo-vypolnit-na-paseke-v-iyune", "https://moremeda.com/kalendar-pasechnika/iyul-na-paseke", "https://moremeda.com/kalendar-pasechnika/kalendar-pasechnika-na-avgust", "https://moremeda.com/kalendar-pasechnika/raboty-na-paseke-v-sentyabre", "https://moremeda.com/kalendar-pasechnika/oktyabr-na-paseke", "https://moremeda.com/kalendar-pasechnika/raboty-na-paseke-v-noyabre", "https://moremeda.com/kalendar-pasechnika/dekabr-na-paseke-osnovnye-raboty-sovety-i-rekomendacii")
    val images = listOf(R.drawable.jan, R.drawable.feb, R.drawable.mart, R.drawable.apr, R.drawable.mai, R.drawable.june, R.drawable.jule, R.drawable.aug, R.drawable.sep, R.drawable.oct, R.drawable.nov, R.drawable.dec)

    Column(modifier = Modifier.verticalScroll(rememberScrollState()), horizontalAlignment = Alignment.CenterHorizontally) {
        months.forEachIndexed { index, month ->
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = colorResource(id = R.color.black1))
                    .padding(top = 30.dp)
            ) {
                Box(
                    modifier = Modifier
                        .padding(bottom = if (index == months.lastIndex) 70.dp else 10.dp)
                        .height(120.dp)
                        .width(360.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(
                            brush = Brush.linearGradient(
                                colors = listOf(Color.Transparent, Color.Transparent),
                                start = Offset.Zero,
                                end = Offset.Infinite
                            ),
                            shape = RoundedCornerShape(15.dp)
                        )
                        .clickable {
                            val encodedLink = Uri.encode(links[index])
                            navController.navigate("webview/${encodedLink}")
                        }
                        .border(
                            width = 2.dp,
                            color = colorResource(id = R.color.white2),
                            shape = RoundedCornerShape(15.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = images[index]),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                    Text(text = month, fontSize = 46.sp, color = colorResource(id = R.color.white2), fontFamily = sansparty, )

                }
            }
        }
    }
}