package moe.chika.app.server.plugin

import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.resources.Resources
import io.ktor.server.routing.routing
import moe.chika.app.server.api.anime.animeRoute
import moe.chika.app.server.api.auth.authRoute
import moe.chika.app.server.api.user.userRoute

fun Application.configureRouting() {
  install(Resources)
  routing {
    animeRoute()
    authRoute()
    userRoute()
  }
}
