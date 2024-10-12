package moe.rendrap.app.chika

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
