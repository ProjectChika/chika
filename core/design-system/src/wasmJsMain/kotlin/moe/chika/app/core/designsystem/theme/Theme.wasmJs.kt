package moe.chika.app.core.designsystem.theme

import androidx.compose.runtime.Composable

@Composable
actual fun ChikaTheme(
  darkTheme: Boolean,
  dynamicColor: Boolean,
  content: @Composable () -> Unit
) = DefaultTheme(darkTheme, content)
