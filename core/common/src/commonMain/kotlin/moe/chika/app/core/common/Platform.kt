package moe.chika.app.core.common

interface Platform {
  val build: String
  val type: PlatformType
}

enum class PlatformType {
  ANDROID,
  DESKTOP,
  WEB
}

expect fun platform(): Platform
