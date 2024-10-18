plugins {
  id(libs.plugins.chika.jvm.get().pluginId)
  alias(libs.plugins.ktor)
  alias(libs.plugins.kotlin.plugin.serialization)
  application
}

group = "moe.chika.app.server"

application {
  mainClass.set("moe.chika.app.server.ApplicationKt")
  applicationDefaultJvmArgs = listOf("-Dio.ktor.development=${extra["io.ktor.development"] ?: "false"}")
}

dependencies {
  implementation(projects.core.common)
  implementation(projects.core.model)

  implementation(libs.logback)
  implementation(libs.bundles.ktor.server)
  implementation(libs.kotlinx.serialization.json)
  implementation(libs.kotlinx.datetime)

  implementation(libs.postgresql)
  implementation(libs.hikari)
  implementation(libs.bundles.exposed)

  implementation(platform(libs.koin.bom))
  implementation(libs.koin.ktor)
  implementation(libs.koin.logger.slf4j)
  testImplementation(libs.koin.test)

  testImplementation(libs.ktor.server.test.host)
  testImplementation(libs.kotlin.test.junit)
  testImplementation(libs.kotlin.test)
}
