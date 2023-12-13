package com.dimon10.jobservice.payload

data class CompanyRequest (
    val id: Long?,
    val name: String,
    val description: String?,
    val logoUrl: String?,
    val socialLinks: Set<SocialLinkRequest>?
)
