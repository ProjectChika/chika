import moe.chika.app.convention.config.RootConfig.JAVA_VERSION
import moe.chika.app.convention.config.RootConfig.JVM_TARGET
import moe.chika.app.convention.configureKotlinJvm
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.compile.JavaCompile
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
  }
}
