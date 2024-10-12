package moe.chika.app.convention.config

import org.gradle.api.JavaVersion
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

object RootConfig {
  val JAVA_VERSION = JavaVersion.VERSION_17
  val JVM_TARGET = JvmTarget.JVM_17
  const val JDK_VERSION = 17
}
