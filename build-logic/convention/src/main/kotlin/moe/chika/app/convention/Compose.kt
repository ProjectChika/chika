package moe.chika.app.convention

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project
import org.gradle.api.provider.Provider
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.compose.compiler.gradle.ComposeCompilerGradlePluginExtension
import org.jetbrains.kotlin.compose.compiler.gradle.ComposeFeatureFlag

internal fun Project.configureAndroidCompose(
  commonExtension: CommonExtension<*, *, *, *, *>
) {
  commonExtension.apply {
    buildFeatures {
      compose = true
    }

    testOptions {
      // Enable for Robolectric
      unitTests {
        isIncludeAndroidResources = true
      }
    }

    configureCompose()
  }
}

internal fun Project.configureCompose() {
  extensions.configure<ComposeCompilerGradlePluginExtension> {
    featureFlags.add(ComposeFeatureFlag.StrongSkipping)

    fun Provider<String>.onlyIfTrue() = flatMap { provider { it.takeIf(String::toBoolean) } }
    fun Provider<*>.relativeToRootProject(dir: String) = flatMap {
      rootProject.layout.buildDirectory.dir(projectDir.toRelativeString(rootDir))
    }.map { it.dir(dir) }

    project.providers.gradleProperty("enableComposeCompilerMetrics").onlyIfTrue()
      .relativeToRootProject("compose-metrics")
      .let(metricsDestination::set)

    project.providers.gradleProperty("enableComposeCompilerReports").onlyIfTrue()
      .relativeToRootProject("compose-reports")
      .let(reportsDestination::set)

    stabilityConfigurationFile.set(rootProject.layout.projectDirectory.file("compose_compiler_config.conf"))

  }
}
