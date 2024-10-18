package moe.chika.app.core.common

import android.os.Build

class AndroidPlatform : Platform {
  override val build: String
    get() = "${Build.DEVICE}-${Build.VERSION.SDK_INT}"
  override val type: PlatformType
    get() = PlatformType.ANDROID
}

actual fun platform(): Platform = AndroidPlatform()
