package com.dimon10.jobservice.core.model

import java.time.Instant

data class Experience (
    val company: String,
    val positionTitle: String,
    val role: Role?,
    val level: Level?,
    val description: String,
    val startDate: Instant,
    val endDate: Instant?
)
