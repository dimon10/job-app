package com.dimon10.jobservice.core.model


import java.time.Instant

data class Job(
    val id: Long?,
    val title: String,
    val role: Role?,
    val level: Level?,
    val company: Company?,
    val skills: Set<Skill>,
    val mainWorkLanguage: Language,
    val secondWorkLanguage: Language?,
    val country: Country,
    val place: String?,
    val jobType: JobType,
    val remote: Boolean = false,
    val sourceUrl: String?,
    val description: String,
    val datePosted: Instant = Instant.now(),
    val dateExpired: Instant?,
    val deleted: Boolean = false
)