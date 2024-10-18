plugins {
  id(libs.plugins.chika.jvm.get().pluginId)
  alias(libs.plugins.kotlin.plugin.serialization)
}

dependencies {
  implementation(libs.kotlinx.serialization.json)
}
