package moe.chika.app.server.model.entity

import java.util.UUID
import moe.chika.app.core.common.util.currentTimeUtc
import org.jetbrains.exposed.dao.*
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.dao.id.UUIDTable
import org.jetbrains.exposed.sql.kotlin.datetime.datetime

abstract class BaseIntIdTable(name: String) : IntIdTable(name) {
  val createdAt = datetime("created_at").clientDefault { currentTimeUtc() }
  val updatedAt = datetime("updated_at").nullable()
}

abstract class BaseUuidIdTable(name: String): UUIDTable(name) {
  val createdAt = datetime("created_at").clientDefault { currentTimeUtc() }
  val updatedAt = datetime("updated_at").clientDefault { currentTimeUtc() }
}

abstract class BaseIntEntity(id: EntityID<Int>, table: BaseIntIdTable): IntEntity(id) {
  val createdAt by table.createdAt
  var updatedAt by table.updatedAt
}

abstract class BaseUuidEntity(id: EntityID<UUID>, table: BaseUuidIdTable): UUIDEntity(id) {
  val createdAt by table.createdAt
  var updateAt by table.updatedAt
}

abstract class BaseIntEntityClass<E: BaseIntEntity>(table: BaseIntIdTable): EntityClass<Int, E>(table) {
  init {
      EntityHook.subscribe { action ->
        if (action.changeType == EntityChangeType.Updated) {
          try {
              action.toEntity(this)?.updatedAt = currentTimeUtc()
          } catch (e: Exception) {
            e.printStackTrace()
          }
        }
      }
  }
}

abstract class BaseUuidEntityClass<E: BaseUuidEntity>(table: BaseUuidIdTable): EntityClass<UUID, E>(table) {
  init {
    EntityHook.subscribe { action ->
      if (action.changeType == EntityChangeType.Updated) {
        try {
          action.toEntity(this)?.updateAt = currentTimeUtc()
        } catch (e: Exception) {
          e.printStackTrace()
        }
      }
    }
  }
}
