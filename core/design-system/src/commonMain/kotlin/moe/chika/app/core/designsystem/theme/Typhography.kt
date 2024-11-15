package moe.chika.app.core.designsystem.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import moe.chika.app.core.designsystem.resources.Res
import moe.chika.app.core.designsystem.resources.nunito_black
import moe.chika.app.core.designsystem.resources.nunito_bold
import moe.chika.app.core.designsystem.resources.nunito_medium
import moe.chika.app.core.designsystem.resources.nunito_regular
import moe.chika.app.core.designsystem.resources.nunito_semibold
import org.jetbrains.compose.resources.Font

internal val NunitoFontFamily = FontFamily(
  Font(resource = Res.font.nunito_regular, weight = FontWeight.Normal),
  Font(resource = Res.font.nunito_medium, weight = FontWeight.Medium),
  Font(resource = Res.font.nunito_semibold, weight = FontWeight.SemiBold),
  Font(resource = Res.font.nunito_bold, weight = FontWeight.Bold),
  Font(resource = Res.font.nunito_black, weight = FontWeight.Black),
)

private val baseline = Typography()

internal val ChikaTypography = Typography(
  displayLarge = baseline.displayLarge.copy(fontFamily = NunitoFontFamily),
  displayMedium = baseline.displayMedium.copy(fontFamily = NunitoFontFamily),
  displaySmall = baseline.displaySmall.copy(fontFamily = NunitoFontFamily),
  headlineLarge = baseline.headlineLarge.copy(fontFamily = NunitoFontFamily),
  headlineMedium = baseline.headlineMedium.copy(fontFamily = NunitoFontFamily),
  headlineSmall = baseline.headlineSmall.copy(fontFamily = NunitoFontFamily),
  titleLarge = baseline.titleLarge.copy(fontFamily = NunitoFontFamily),
  titleMedium = baseline.titleMedium.copy(fontFamily = NunitoFontFamily),
  titleSmall = baseline.titleSmall.copy(fontFamily = NunitoFontFamily),
  bodyLarge = baseline.bodyLarge.copy(fontFamily = NunitoFontFamily),
  bodyMedium = baseline.bodyMedium.copy(fontFamily = NunitoFontFamily),
  bodySmall = baseline.bodySmall.copy(fontFamily = NunitoFontFamily),
  labelLarge = baseline.labelLarge.copy(fontFamily = NunitoFontFamily),
  labelMedium = baseline.labelMedium.copy(fontFamily = NunitoFontFamily),
  labelSmall = baseline.labelSmall.copy(fontFamily = NunitoFontFamily),
)
