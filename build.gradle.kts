plugins {
  // this is necessary to avoid the plugins to be loaded multiple times
  // in each subproject's classloader
  alias(androidx.plugins.application) apply false
  alias(androidx.plugins.library) apply false
  alias(libs.plugins.jetbrains.compose) apply false
  alias(libs.plugins.kotlin.jvm) apply false
  alias(libs.plugins.kotlin.android) apply false
  alias(libs.plugins.kotlin.multiplatform) apply false
  alias(libs.plugins.kotlin.plugin.compose) apply false
  alias(libs.plugins.chika.versioning)
}
