package com.dimon10.jobservice.payload

data class SkillResponse (
    val id: Long,
    val fullName: String,
    val shortName: String?,
    val description: String?
)


