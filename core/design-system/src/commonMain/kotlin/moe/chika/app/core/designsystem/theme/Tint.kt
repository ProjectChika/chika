package moe.chika.app.core.designsystem.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
data class TintColor(
  val iconTint: Color = Color.Unspecified
)

val LocalTintColor = staticCompositionLocalOf { TintColor() }
