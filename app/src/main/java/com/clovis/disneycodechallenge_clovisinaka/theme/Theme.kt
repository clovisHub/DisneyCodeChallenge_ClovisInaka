//import android.app.Activity
//import androidx.compose.foundation.isSystemInDarkTheme
//import androidx.compose.material.MaterialTheme
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.SideEffect
//import androidx.compose.ui.graphics.toArgb
//import androidx.compose.ui.platform.LocalView
//import androidx.core.view.ViewCompat
//import com.clovis.uicomponents.ui.theme.*


/**
 * No need to use this theme we applied theme from user interface module
 */
//package com.clovis.disneycodechallenge_clovisinaka.ui.views.ui.theme.theme
//
//import androidx.compose.foundation.isSystemInDarkTheme
//import androidx.compose.material.MaterialTheme
//import androidx.compose.material.darkColors
//import androidx.compose.material.lightColors
//import androidx.compose.runtime.Composable
//
//private val DarkColorPalette = darkColors(
//    primary = Purple200,
//    primaryVariant = Purple700,
//    secondary = Teal200
//)
//
//private val LightColorPalette = lightColors(
//    primary = Purple500,
//    primaryVariant = Purple700,
//    secondary = Teal200
//
//    /* Other default colors to override
//    background = Color.White,
//    surface = Color.White,
//    onPrimary = Color.White,
//    onSecondary = Color.Black,
//    onBackground = Color.Black,
//    onSurface = Color.Black,
//    */
//)
//


//@Composable
//fun DisneyCodeChallenge_ClovisInakaTheme(
//    darkTheme: Boolean = isSystemInDarkTheme(),
//    content: @Composable () -> Unit
//) {
//    val colorScheme = when {
//        darkTheme -> DarkColorScheme
//        else -> LightColorScheme
//    }
//    val view = LocalView.current
//    if (!view.isInEditMode) {
//        SideEffect {
//            (view.context as Activity).window.statusBarColor = colorScheme.primary.toArgb()
//            ViewCompat.getWindowInsetsController(view)?.isAppearanceLightStatusBars = darkTheme
//        }
//    }
//
//    androidx.compose.material3.MaterialTheme(
//        colorScheme = colorScheme,
//        typography = TypographyMaterial,
//        content = content
//    )
//}