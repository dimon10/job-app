package com.dimon10.jobservice.payload

import com.dimon10.jobservice.core.model.Country
import com.dimon10.jobservice.core.model.JobType
import com.dimon10.jobservice.core.model.Language
import com.dimon10.jobservice.core.model.Level
import com.dimon10.jobservice.core.model.Role
import java.time.Instant

data class JobResponse (
    val id: Long,
    val title: String,
    val role: Role?,
    val level: Level?,
    val company: CompanyResponse?,
    val skills: Set<SkillResponse>,
    val mainWorkLanguage: Language,
    val secondWorkLanguage: Language?,
    val country: Country,
    val place: String?,
    val jobType: JobType,
    val remote: Boolean = false,
    val sourceUrl: String?,
    val description: String,
    val datePosted: Instant = Instant.now(),
    val dateExpired: Instant?
)