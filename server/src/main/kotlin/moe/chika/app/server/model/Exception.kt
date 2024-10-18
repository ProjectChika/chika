package moe.chika.app.server.model

import io.ktor.http.HttpStatusCode

sealed interface AppException {
  val message: String
  val code: Int
  val cause: Throwable?

  data class Unauthorized(override val cause: Throwable? = null) : AppException {
    override val message: String
      get() = HttpStatusCode.Unauthorized.description
    override val code: Int
      get() = HttpStatusCode.Unauthorized.value
  }

  data class NotFound(override val cause: Throwable? = null) : AppException {
    override val message: String
      get() = HttpStatusCode.NotFound.description
    override val code: Int
      get() = HttpStatusCode.NotFound.value
  }
}
