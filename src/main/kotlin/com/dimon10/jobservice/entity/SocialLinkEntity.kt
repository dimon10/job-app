package com.dimon10.jobservice.entity

import com.dimon10.jobservice.core.model.SocialResource
import jakarta.persistence.Column
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.MappedSuperclass

@MappedSuperclass
abstract class SocialLinkEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    var resource: SocialResource? = null

    @Column(nullable = false)
    var url: String =""

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is SocialLinkEntity) return false

        if (id != other.id) return false
        if (resource != other.resource) return false
        if (url != other.url) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id?.hashCode() ?: 0
        result = 31 * result + (resource?.hashCode() ?: 0)
        result = 31 * result + url.hashCode()
        return result
    }

}
