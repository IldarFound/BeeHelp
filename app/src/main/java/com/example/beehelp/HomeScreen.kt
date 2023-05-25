package com.example.beehelp

import androidx.compose.material3.Button
import android.view.InputDevice.MotionRange
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.DividerDefaults.color
import androidx.compose.material3.SnackbarDefaults.color
import androidx.compose.ui.Alignment
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.zIndex
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.beehelp.ui.theme.kard
import com.example.beehelp.ui.theme.monst

@Composable
fun HomeScreen(navController: NavHostController){
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(top = 0.dp),
        verticalArrangement = Arrangement.spacedBy(0.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(0.dp)
        ) {
            Button(
                onClick = { navController.navigate("honey") },
                modifier = Modifier
                    .height(340.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(0.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black
                ),
                contentPadding = PaddingValues(1.dp)
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Image(
                        modifier = Modifier
                            .fillMaxSize()
                            .alpha(0.55f),
                        painter = painterResource(id = R.drawable.medimg),
                        contentDescription = "Виды мёда",
                        contentScale = ContentScale.Crop
                    )
                    Text(
                        text = "Виды мёда",
                        fontFamily = kard,
                        textAlign = TextAlign.Center,
                        fontSize = 54.sp,
                        style = TextStyle(
                            shadow = Shadow(
                                color = Color.Black,
                                offset = Offset(5f, 5f),
                                blurRadius = 7f
                            )
                        ),
                        color = Color.White
                    )
                }
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(0.dp)
        ) {
            Button(
                onClick = { navController.navigate("bees") },
                modifier = Modifier
                    .height(360.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(0.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black
                ),
                contentPadding = PaddingValues(1.dp)
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Image(
                        modifier = Modifier
                            .fillMaxSize()
                            .alpha(0.55f),
                        painter = painterResource(id = R.drawable.pchel),
                        contentDescription = "Породы пчёл",
                        contentScale = ContentScale.Crop
                    )
                    Text(
                        text = "Породы пчёл",
                        fontFamily = kard,
                        textAlign = TextAlign.Center,
                        fontSize = 54.sp,
                        style = TextStyle(
                            shadow = Shadow(
                                color = Color.Black,
                                offset = Offset(5f, 5f),
                                blurRadius = 7f
                            )
                        ),
                        color = Color.White
                    )
                }
            }
        }

    }
}
