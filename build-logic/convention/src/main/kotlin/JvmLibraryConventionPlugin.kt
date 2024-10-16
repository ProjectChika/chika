
import moe.chika.app.convention.config.RootConfig.JAVA_VERSION
import moe.chika.app.convention.config.RootConfig.JVM_TARGET
import moe.chika.app.convention.configureKotlinJvm
import moe.chika.app.convention.extension.implementation
import moe.chika.app.convention.extension.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.compile.JavaCompile
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinJvmCompile

class JvmLibraryConventionPlugin : Plugin<Project> {
  override fun apply(target: Project) = with(target) {
    pluginManager.apply("org.jetbrains.kotlin.jvm")

    tasks.withType<JavaCompile>().configureEach {
      sourceCompatibility = JAVA_VERSION.toString()
      targetCompatibility = JAVA_VERSION.toString()
    }

    tasks.withType<KotlinJvmCompile>().configureEach {
      compilerOptions.jvmTarget.set(JVM_TARGET)
    }
    configureKotlinJvm()

    dependencies {
      val bom = libs.findLibrary("arrow.stack").get()
      implementation(platform(bom))
      implementation(libs.findLibrary("arrow.core").get())
      implementation(libs.findLibrary("arrow.fx.coroutines").get())
    }
  }
}
