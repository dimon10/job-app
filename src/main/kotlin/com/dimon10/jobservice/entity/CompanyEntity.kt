package com.dimon10.jobservice.entity

import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.Table

@Entity
@Table(name = "companies")
class CompanyEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column
    var name: String = ""

    @Column
    var description: String? = null

    @Column
    var logoUrl: String? = null

    @OneToMany(mappedBy = "company", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    var socialLinks: MutableSet<CompanySocialLinkEntity>? = mutableSetOf()

    constructor(name: String, description: String?, logoUrl: String?,
                socialLinks: MutableSet<CompanySocialLinkEntity>) : this() {
        this.name = name
        this.description = description
        this.logoUrl = logoUrl
        this.socialLinks = socialLinks
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is CompanyEntity) return false

        if (id != other.id) return false
        if (name != other.name) return false
        if (description != other.description) return false
        if (logoUrl != other.logoUrl) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id?.hashCode() ?: 0
        result = 31 * result + name.hashCode()
        result = 31 * result + (description?.hashCode() ?: 0)
        result = 31 * result + (logoUrl?.hashCode() ?: 0)
        return result
    }
}
