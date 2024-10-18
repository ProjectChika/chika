package moe.chika.app.core.common

class JvmPlatform : Platform {
  override val build: String
    get() = "${System.getProperty("os.name")}-${System.getProperty("os.version")})"
  override val type: PlatformType
    get() = PlatformType.DESKTOP
}

actual fun platform(): Platform = JvmPlatform()
