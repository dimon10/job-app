package com.dimon10.jobservice.core.model

data class Skill (
    val id: Long,
    val fullName: String,
    val shortName: String?,
    val description: String?
)