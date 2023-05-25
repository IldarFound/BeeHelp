package com.example.beehelp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.beehelp.ui.theme.sansparty

@Composable
fun CalcScreen(navController: NavHostController) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(colorResource(id = R.color.darkblue1))) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 33.dp, bottom = 0.dp, start = 15.dp),
            verticalArrangement = Arrangement.spacedBy(30.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                Button(
                    onClick = { navController.navigate("sugarcalc")},
                    modifier = Modifier
                        .height(180.dp)
                        .width(155.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(colorResource(id = R.color.white2))
                ) {
                    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                        Image(
                            painter = painterResource(id = R.drawable.sugar),
                            modifier = Modifier.height(100.dp).width(100.dp).padding(top = 10.dp),
                            contentDescription = "Сахарная вода"
                        )
                        Text(
                            text = "Сахарная\u00A0вода" + "\n(3:2)",
                            textAlign = TextAlign.Center,
                            fontSize = 13.sp,
                            style = TextStyle(fontFamily = sansparty),
                            modifier = Modifier.padding(top = 15.dp).width(170.dp),
                            color = colorResource(id = R.color.darkblue1)
                        )
                    }
                }
                Button(
                    onClick = { navController.navigate("honeycalc")},
                    modifier = Modifier
                        .height(180.dp)
                        .width(155.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(colorResource(id = R.color.white2))
                ) {
                    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                        Image(
                            painter = painterResource(id = R.drawable.testo),
                            modifier = Modifier.height(100.dp).width(100.dp).padding(top = 10.dp),
                            contentDescription = "Медовое тесто"
                        )
                        Text(
                            text = "Медовое\u00A0тесто" + "\n(1:3)",
                            textAlign = TextAlign.Center,
                            fontSize = 13.sp,
                            style = TextStyle(fontFamily = sansparty),
                            modifier = Modifier.padding(top = 7.dp).width(170.dp),
                            color = colorResource(id = R.color.darkblue1)
                        )
                    }
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                Button(
                    onClick = { navController.navigate("shavelcalc")},
                    modifier = Modifier
                        .height(180.dp)
                        .width(155.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(colorResource(id = R.color.white2))
                ) {
                    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                        Image(
                            painter = painterResource(id = R.drawable.leaf),
                            modifier = Modifier.height(100.dp).width(100.dp).padding(top = 10.dp),
                            contentDescription = "Опрыскивание щавелевой кислотой"
                        )
                        Text(
                            text = "Опрыскивание щавелевой кислотой",
                            textAlign = TextAlign.Center,
                            fontSize = 13.sp,
                            style = TextStyle(fontFamily = sansparty),
                            modifier = Modifier.padding(top = 7.dp).width(170.dp),
                            color = colorResource(id = R.color.darkblue1)
                        )
                    }
                }
                Button(
                    onClick = { navController.navigate("antcalc")},
                    modifier = Modifier
                        .height(180.dp)
                        .width(155.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(colorResource(id = R.color.white2))
                ) {
                    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                        Image(
                            painter = painterResource(id = R.drawable.ant),
                            modifier = Modifier.height(100.dp).width(100.dp).padding(top = 10.dp),
                            contentDescription = "Разбавление муравьиной кислоты"
                        )
                        Text(
                            text = "Разбавление муравьиной кислоты",
                            textAlign = TextAlign.Center,
                            fontSize = 13.sp,
                            style = TextStyle(fontFamily = sansparty),
                            modifier = Modifier.padding(top = 7.dp).width(170.dp),
                            color = colorResource(id = R.color.darkblue1)
                        )
                    }
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                Button(
                    onClick = { navController.navigate("milkcalc")},
                    modifier = Modifier
                        .height(180.dp)
                        .width(155.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(colorResource(id = R.color.white2))
                ) {
                    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                        Image(
                            painter = painterResource(id = R.drawable.yogurt),
                            modifier = Modifier.height(100.dp).width(100.dp).padding(top = 10.dp),
                            contentDescription = "Разбавление молочной кислоты"
                        )
                        Text(
                            text = "Разбавление молочной кислоты",
                            textAlign = TextAlign.Center,
                            fontSize = 13.sp,
                            style = TextStyle(fontFamily = sansparty),
                            modifier = Modifier.padding(top = 7.dp).width(170.dp),
                            color = colorResource(id = R.color.darkblue1)
                        )
                    }
                }
                Button(
                    onClick = { navController.navigate("rastvorcalc")},
                    modifier = Modifier
                        .height(180.dp)
                        .width(155.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(colorResource(id = R.color.white2))
                ) {
                    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                        Image(
                            painter = painterResource(id = R.drawable.potion),
                            modifier = Modifier.height(95.dp).width(95.dp).padding(top = 10.dp),
                            contentDescription = "Раствор щавелевой кислоты и глицерина"
                        )
                        Text(
                            text = "Раствор щавелевой кислоты и глицерина",
                            textAlign = TextAlign.Center,
                            fontSize = 11.sp,
                            style = TextStyle(fontFamily = sansparty),
                            modifier = Modifier.padding(top = 7.dp).width(170.dp),
                            color = colorResource(id = R.color.darkblue1)
                        )
                    }
                }
            }
        }
    }
}