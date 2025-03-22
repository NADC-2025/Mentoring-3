package com.fabian.simpleappnadc3.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

// Custom colors for our app
private val LightColors = lightColorScheme(
    primary = Color(0xFF1976D2), // Blue
    onPrimary = Color.White,
    primaryContainer = Color(0xFFBBDEFB), // Light Blue
    onPrimaryContainer = Color(0xFF0D47A1), // Dark Blue
    secondary = Color(0xFF689F38), // Green
    onSecondary = Color.White,
    secondaryContainer = Color(0xFFDCEDC8), // Light Green
    onSecondaryContainer = Color(0xFF33691E), // Dark Green
    tertiary = Color(0xFFF57C00), // Orange
    onTertiary = Color.White,
    tertiaryContainer = Color(0xFFFFE0B2), // Light Orange
    onTertiaryContainer = Color(0xFFE65100), // Dark Orange
    background = Color(0xFFF5F5F5), // Light Gray
    onBackground = Color(0xFF212121), // Dark Gray
    surface = Color.White,
    onSurface = Color(0xFF212121) // Dark Gray
)

private val DarkColors = darkColorScheme(
    primary = Color(0xFF90CAF9), // Light Blue
    onPrimary = Color(0xFF0D47A1), // Dark Blue
    primaryContainer = Color(0xFF1565C0), // Blue
    onPrimaryContainer = Color(0xFFBBDEFB), // Light Blue
    secondary = Color(0xFFAED581), // Light Green
    onSecondary = Color(0xFF33691E), // Dark Green
    secondaryContainer = Color(0xFF558B2F), // Green
    onSecondaryContainer = Color(0xFFDCEDC8), // Light Green
    tertiary = Color(0xFFFFB74D), // Light Orange
    onTertiary = Color(0xFFE65100), // Dark Orange
    tertiaryContainer = Color(0xFFF57C00), // Orange
    onTertiaryContainer = Color(0xFFFFE0B2), // Light Orange
    background = Color(0xFF121212), // Dark Gray
    onBackground = Color(0xFFEEEEEE), // Light Gray
    surface = Color(0xFF212121), // Dark Gray
    onSurface = Color(0xFFEEEEEE) // Light Gray
)

@Composable
fun SimpleAppNADC3Theme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColors
        else -> LightColors
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primaryContainer.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}