package com.example.beehelp.calculators

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.beehelp.R
import com.example.beehelp.ui.theme.golos
import kotlin.math.round
import kotlin.math.roundToInt

@SuppressLint("AutoboxingStateValueProperty")
@Composable
@Preview
fun ShavelCalcScreen() {
    val rastvorShavelVolume = remember { mutableStateOf(0f) }
    val shavel = (rastvorShavelVolume.value * 0.042f * 10).roundToInt() / 10f
    val waterVolume = (rastvorShavelVolume.value * 0.49f).roundToInt()
    val sugarVolume = (rastvorShavelVolume.value * 0.73f).roundToInt()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.darkblue1))
            .padding(horizontal = 15.dp).verticalScroll(rememberScrollState())
    ) {
        Column(
            modifier = Modifier
                .padding(top = 25.dp, bottom = 100.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(35.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "Выберите объём 4.2% щавелевой кислоты:",
                fontFamily = golos,
                fontSize = 22.sp,
                color = Color.White
            )
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(
                        width = 3.dp,
                        color = Color.LightGray,
                        shape = RoundedCornerShape(20.dp)
                    ),
                colors = CardDefaults.cardColors(colorResource(id = R.color.darkblue1))
            ) {
                Box(modifier = Modifier.padding(horizontal = 15.dp, vertical = 25.dp)) {
                    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
                        Row {
                            Text(
                                text = "4.2% раствор щавелевой кислоты: ${rastvorShavelVolume.value.roundToInt()} мл",
                                fontFamily = golos,
                                fontSize = 25.sp,
                                color = Color.White
                            )
                        }
                        Slider(
                            value = rastvorShavelVolume.value,
                            onValueChange = { rastvorShavelVolume.value = it },
                            valueRange = 10f..1000f,
                            steps = 98,
                            colors = SliderDefaults.colors(Color.White)
                        )
                    }
                }
            }
            Divider(color = Color.Gray, thickness = 2.dp)
            Row(
                horizontalArrangement = Arrangement.Absolute.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Результат", fontFamily = golos, fontSize = 25.sp, color = Color.White)
            }
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(
                        width = 3.dp,
                        color = Color.LightGray,
                        shape = RoundedCornerShape(20.dp)
                    ),
                colors = CardDefaults.cardColors(colorResource(id = R.color.darkblue1))
            ) {
                Box(modifier = Modifier.padding(horizontal = 15.dp, vertical = 25.dp)) {
                    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
                        Row {
                            Text(
                                text = "Вес щавелевой кислоты: $shavel г",
                                fontFamily = golos,
                                fontSize = 25.sp,
                                color = Color.White
                            )
                        }
                        Divider(color = Color.Gray, thickness = 2.dp)
                        Row {
                            Text(
                                text = "Объём воды: $waterVolume мл",
                                fontFamily = golos,
                                fontSize = 25.sp,
                                color = Color.White
                            )
                        }
                        Divider(color = Color.Gray, thickness = 2.dp)
                        Row {
                            Text(
                                text = "Вес сахара: $sugarVolume г",
                                fontFamily = golos,
                                fontSize = 25.sp,
                                color = Color.White
                            )
                        }
                    }
                }
            }
        }
    }
}