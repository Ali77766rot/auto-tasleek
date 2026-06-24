package com.autotasleek.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    primary = NeonGreen,
    secondary = NeonGreen,
    background = DarkGrey,
    surface = LightGrey,
    onPrimary = DarkGrey,
    onSecondary = DarkGrey,
    onBackground = White,
    onSurface = White
)

@Composable
fun AutoTasleekTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = DarkColorScheme,
        content = content
    )
}
