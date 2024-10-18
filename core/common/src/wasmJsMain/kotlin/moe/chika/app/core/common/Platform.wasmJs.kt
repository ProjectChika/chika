package moe.chika.app.core.common

class WasmJsPlatform : Platform {
  override val build: String
    get() = "Web with Kotlin/Wasm"
  override val type: PlatformType
    get() = PlatformType.WEB
}

actual fun platform(): Platform = WasmJsPlatform()
