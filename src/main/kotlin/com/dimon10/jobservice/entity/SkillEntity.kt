package com.dimon10.jobservice.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToMany
import jakarta.persistence.Table

@Entity
@Table(name = "skills")
class SkillEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(nullable = false)
    var fullName: String = ""

    @Column(nullable = false)
    var shortName: String = ""

    @Column
    var description: String? = null

    @ManyToMany(mappedBy = "skills")
    var jobs: MutableSet<JobEntity> = mutableSetOf()

    @ManyToMany(mappedBy = "skills")
    var candidates: MutableSet<CandidateEntity> = mutableSetOf()

    constructor(id: Long?, fullName: String, shortName: String, description: String?) {
        this.id = id
        this.fullName = fullName
        this.shortName = shortName
        this.description = description
    }

    constructor(fullName: String, shortName: String) {
        this.fullName = fullName
        this.shortName = shortName
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is SkillEntity) return false

        if (id != other.id) return false
        if (fullName != other.fullName) return false
        if (shortName != other.shortName) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id?.hashCode() ?: 0
        result = 31 * result + fullName.hashCode()
        result = 31 * result + shortName.hashCode()
        return result
    }


}