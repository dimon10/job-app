package com.dimon10.jobservice.core.model

data class Company (
    val id: Long,
    val name: String,
    val description: String?,
    val logoUrl: String?,
    val socialLinks: Set<SocialLink>
)
