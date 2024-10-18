package moe.chika.app.core.common.extension

infix fun <T> T?.or(other: T) = this ?: other
