package com.dimon10.jobservice.payload

import com.dimon10.jobservice.core.model.SocialResource

data class SocialLinkRequest (
    val id: Long?,
    val resource: SocialResource,
    val url: String
)
