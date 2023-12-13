package com.dimon10.jobservice.entity

import com.dimon10.jobservice.core.model.SocialResource
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "companies_social_links")
class CompanySocialLinkEntity() : SocialLinkEntity() {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", nullable = false)
    var company: CompanyEntity? = null

    constructor(resource: SocialResource, url: String, company: CompanyEntity) : this() {
        this.resource = resource
        this.url = url
        this.company = company
    }
}