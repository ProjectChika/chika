package moe.chika.app.convention

import com.android.build.api.dsl.CommonExtension
import moe.chika.app.convention.config.AndroidConfig.COMPILE_SDK
import moe.chika.app.convention.config.AndroidConfig.MIN_SDK
import moe.chika.app.convention.config.RootConfig.JAVA_VERSION
import moe.chika.app.convention.config.RootConfig.JDK_VERSION
import moe.chika.app.convention.extension.androidx
import org.gradle.api.Project
import org.gradle.api.plugins.JavaPluginExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.KotlinAndroidProjectExtension
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmProjectExtension
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.dsl.KotlinTopLevelExtension

internal fun Project.configureKotlinAndroid(
  commonExtension: CommonExtension<*, *, *, *, *>
) {
  commonExtension.apply {
    compileSdk = COMPILE_SDK

    defaultConfig {
      minSdk = MIN_SDK
    }

    compileOptions {
      sourceCompatibility = JAVA_VERSION
      targetCompatibility = JAVA_VERSION
      isCoreLibraryDesugaringEnabled = true
    }

    configureKotlin<KotlinMultiplatformExtension>()

    dependencies {
      add("coreLibraryDesugaring", androidx.findLibrary("desugarJdkLibs").get())
    }
  }
}

internal fun Project.configureKotlinMultiplatform() {
  extensions.configure<JavaPluginExtension> {
    sourceCompatibility = JAVA_VERSION
    targetCompatibility = JAVA_VERSION
  }

  configureKotlin<KotlinMultiplatformExtension>()
}

internal fun Project.configureKotlinJvm() {
  extensions.configure<JavaPluginExtension> {
    sourceCompatibility = JAVA_VERSION
    targetCompatibility = JAVA_VERSION
  }

  configureKotlin<KotlinJvmProjectExtension>()
}

@OptIn(ExperimentalKotlinGradlePluginApi::class)
private inline fun <reified T : KotlinTopLevelExtension> Project.configureKotlin() = configure<T> {
  when (this) {
    is KotlinAndroidProjectExtension -> compilerOptions
    is KotlinJvmProjectExtension -> compilerOptions
    is KotlinMultiplatformExtension -> compilerOptions
    else -> TODO("Unsupported project extension $this ${T::class}")
  }.apply {
    jvmToolchain(JDK_VERSION)
    freeCompilerArgs.add(
      "-opt-in=kotlinx.coroutines.ExperimentalCoroutinesApi",
    )
  }
}
