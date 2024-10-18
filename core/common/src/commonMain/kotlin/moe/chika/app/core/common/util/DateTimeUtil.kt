package moe.chika.app.core.common.util

import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

fun currentTimeUtc() = Clock.System.now().toLocalDateTime(TimeZone.UTC).to
