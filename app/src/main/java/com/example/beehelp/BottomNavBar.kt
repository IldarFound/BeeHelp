package com.example.beehelp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.beehelp.calculators.AntCalcScreen
import com.example.beehelp.calculators.HoneyCalcScreen
import com.example.beehelp.calculators.MilkCalcScreen
import com.example.beehelp.calculators.RastvorCalcScreen
import com.example.beehelp.calculators.ShavelCalcScreen
import com.example.beehelp.calculators.SugarCalcScreen
import com.example.beehelp.ui.theme.monst

@Composable
fun BottomNavBar(
    items: List<BottomNavItem>,
    navController: NavHostController,
    modifier: Modifier = Modifier,
    onItemClick: (BottomNavItem) -> Unit
) {

    val backStackEntry = navController.currentBackStackEntryAsState()
    BottomNavigation(
        modifier = modifier,
        backgroundColor = Color(ContextCompat.getColor(LocalContext.current, R.color.gray1)),
        elevation = 12.dp
    ) {
        items.forEach { item ->
            val selected = item.route == backStackEntry.value?.destination?.route
            BottomNavigationItem(
                selected = selected,
                onClick = {
                    onItemClick(item)
                },
                selectedContentColor = Color(ContextCompat.getColor(LocalContext.current, R.color.pink1)),
                unselectedContentColor = Color(ContextCompat.getColor(LocalContext.current, R.color.gray2)),
                icon = {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(imageVector = item.icon, contentDescription = item.name)
                        if (selected) {
                            Text(text = item.name, fontFamily = monst, textAlign = TextAlign.Center, fontSize = 12.sp, color = Color(
                                ContextCompat.getColor(LocalContext.current, R.color.pink1))
                            )
                        }
                    }
                }
            )
        }
    }
}


@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "calendar") {
        composable("sprav") {
            HomeScreen(navController = navController)
        }
        composable("calendar") {
            CalendarScreen(navController = navController)
        }
        composable("calc") {
            CalcScreen(navController = navController)
        }
        composable("honey") {
            RecipeList(defaultRecipes, navController)
        }
        composable("bees"){
            PchelList(defaultPchel, navController)
        }
        composable("sugarcalc"){
            SugarCalcScreen()
        }
        composable("honeycalc"){
            HoneyCalcScreen()
        }
        composable("shavelcalc"){
            ShavelCalcScreen()
        }
        composable("antcalc"){
            AntCalcScreen()
        }
        composable("milkcalc"){
            MilkCalcScreen()
        }
        composable("rastvorcalc"){
            RastvorCalcScreen()
        }
        composable("webview/{url}") { backStackEntry ->
            val url = backStackEntry.arguments?.getString("url")
            if (url != null) {
                WebViewScreen(url)
            }
        }
    }

}