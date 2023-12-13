package com.dimon10.jobservice.core.model

import java.time.Instant

abstract class Person(
    open val id: Long?,
    open val name: String,
    open val email: String?,
    open val phone: String?,
    open val socialLinks: Set<SocialLink>?,
    open val dateCreated: Instant = Instant.now(),
    open val dateUpdated: Instant? = Instant.now(),
    open val dateDeleted: Instant? = null,
    open val deleted: Boolean = false
)
