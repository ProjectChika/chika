package moe.chika.app.server.model.entity

import java.util.UUID
import org.jetbrains.exposed.dao.id.EntityID

object UserTable: BaseUuidIdTable("users") {
  val username = varchar("username", 255)
  val avatar = varchar("avatar", 255).nullable()
  val password = varchar("password", 255)
}

class UserEntity(id: EntityID<UUID>): BaseUuidEntity(id, UserTable) {
  companion object : BaseUuidEntityClass<UserEntity>(UserTable)
  var username by UserTable.username
  var avatar by UserTable.avatar
  var password by UserTable.password
}
