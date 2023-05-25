package com.example.beehelp

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.delay

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ExampleScreen(onDataLoaded: () -> Unit) {



    var fakeloading by remember { mutableStateOf(true) }

    LaunchedEffect(key1 = Unit) {
        delay(2000)
        fakeloading = false
        onDataLoaded()
    }


    if (!fakeloading) {
        val navController = rememberNavController()
        Scaffold(
            bottomBar = {
                BottomNavBar(
                    items = listOf(
                        BottomNavItem(
                            name = "Справочник",
                            route = "sprav",
                            icon = ImageVector.vectorResource(id = R.drawable.diary)
                        ),
                        BottomNavItem(
                            name = "Календарь",
                            route = "calendar",
                            icon = ImageVector.vectorResource(id = R.drawable.calendar)
                        ),
                        BottomNavItem(
                            name = "Калькуляторы",
                            route = "calc",
                            icon = ImageVector.vectorResource(id = R.drawable.calculator)
                        ),
                    ),
                    navController = navController,
                    onItemClick = {
                        navController.navigate(it.route)
                    }
                )
            }
        ) {
            Navigation(navController = navController)
        }
    }

}

