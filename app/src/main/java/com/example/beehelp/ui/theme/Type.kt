package com.example.beehelp.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.beehelp.R

val monst = FontFamily(Font(R.font.monsterrat))
val kard = FontFamily(Font(R.font.kardinal))
val azoft = FontFamily(Font(R.font.azoft))
val sansparty = FontFamily(Font(R.font.partysans))
val rostov = FontFamily(Font(R.font.rostov))
val webis = FontFamily(Font(R.font.webis))
val golos = FontFamily(Font(R.font.golos))


val navTextStyle = TextStyle(
    fontFamily = monst,
    fontSize = 16.sp
)


// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),

    */
)

val labsm = {
    TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
}