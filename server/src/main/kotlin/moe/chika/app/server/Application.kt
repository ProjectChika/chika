package moe.chika.app.server

import io.ktor.server.application.Application
import io.ktor.server.netty.EngineMain
import moe.chika.app.server.plugin.configureContentNegotiation
import moe.chika.app.server.plugin.configureRouting

fun main(args: Array<String>) = EngineMain.main(args)

fun Application.module() {
  configureContentNegotiation()
  configureRouting()
}
