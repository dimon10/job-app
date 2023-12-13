package com.dimon10.jobservice.core.model

import java.time.Instant


data class Candidate(
    override val id: Long? = null,
    override val name: String = "",
    override val email: String? = null,
    override val phone: String? = null,
    override val socialLinks: Set<SocialLink>,
    override val dateCreated: Instant = Instant.now(),
    override val dateUpdated: Instant? = Instant.now(),
    override val dateDeleted: Instant? = null,
    override val deleted: Boolean = false,
    val skills: Set<Skill>,
    val experience: List<Experience>,
    val workLanguage: Set<Language>,
    val country: Country,
    val place: String?,
    val workPermit: Set<Country>,
    val preferredRoles: Set<Role>,
    val preferredJobTypes: Set<JobType>,
) : Person(id, name, email, phone, socialLinks, dateCreated, dateUpdated, dateDeleted, deleted)