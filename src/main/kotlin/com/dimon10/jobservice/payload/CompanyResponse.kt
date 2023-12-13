package com.dimon10.jobservice.payload

data class CompanyResponse (
    val id: Long,
    val name: String,
    val description: String?,
    val logoUrl: String?,
    val socialLinks: Set<SocialLinkResponse>?
)
