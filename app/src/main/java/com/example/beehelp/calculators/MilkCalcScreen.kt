package com.example.beehelp.calculators

import android.annotation.SuppressLint
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.beehelp.R
import com.example.beehelp.ui.theme.golos
import kotlin.math.roundToInt

@SuppressLint("AutoboxingStateValueProperty")
@Composable
@Preview
fun MilkCalcScreen() {
    val rastvorMilkVolume = remember { mutableStateOf(0f) }
    var showDialog by remember { mutableStateOf(false) }
    val waterVolume = (rastvorMilkVolume.value * 0.17f).roundToInt()
    val milkVolume = (rastvorMilkVolume.value * 0.83f).roundToInt()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.darkblue1)).verticalScroll(rememberScrollState())            .padding(horizontal = 15.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(top = 25.dp, bottom = 100.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { showDialog = true }
                    .border(width = 1.dp, color = Color.Gray, shape = RoundedCornerShape(8.dp)),
                shape = RoundedCornerShape(8.dp),
                colors = CardDefaults.cardColors(colorResource(id = R.color.white2))
            ) {
                Box(
                    modifier = Modifier.padding(horizontal = 15.dp, vertical = 13.dp)
                ) {
                    Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                        Image(
                            painter = painterResource(id = R.drawable.warning),
                            contentDescription = "warning",
                            modifier = Modifier
                                .width(25.dp)
                                .height(25.dp)
                        )
                        Text(
                            text = "Разбавление 80% молочной кислоты (МК) до 15% раствора МК",
                            textAlign = TextAlign.Left,
                            fontSize = 18.sp
                        )
                    }
                    Text(
                        text = "Подробнее",
                        textAlign = TextAlign.Right,
                        fontSize = 16.sp,
                        color = Color.Blue,
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .padding(top = 70.dp)
                    )
                }
            }
            if (showDialog) {
                AlertDialog(
                    onDismissRequest = { showDialog = false },
                    title = { Text("Разбавление 80% молочной кислоты (МК) до 15% раствора МК\n" + "\nЦель обработки - покрыть росой всех пчёл с обеих сторон рамки. Пчелы должны быть достаточно орошены, но не мокрые. Если удастся найти королеву, рекомендуется спрятать её на время обработки, а затем выпустить уже обработанное пространство") },
                    confirmButton = {}
                )
            }
            Text(
                text = "Выберите объем 15% раствора молочной кислоты кислоты:",
                fontFamily = golos,
                fontSize = 21.sp,
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
                                text = "15% раствор молочной кислоты: ${rastvorMilkVolume.value.roundToInt()} мл",
                                fontFamily = golos,
                                fontSize = 25.sp,
                                color = Color.White
                            )
                        }
                        Slider(
                            value = rastvorMilkVolume.value,
                            onValueChange = { rastvorMilkVolume.value = it },
                            valueRange = 100f..3000f,
                            steps = 57,
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
                                text = "Объём 80% молочной кислоты : $milkVolume мл",
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
                    }
                }
            }
        }
    }
}