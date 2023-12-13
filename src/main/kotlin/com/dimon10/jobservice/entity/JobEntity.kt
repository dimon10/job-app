package com.dimon10.jobservice.entity

import com.dimon10.jobservice.core.model.Country
import com.dimon10.jobservice.core.model.JobType
import com.dimon10.jobservice.core.model.Language
import com.dimon10.jobservice.core.model.Level
import com.dimon10.jobservice.core.model.Role
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.JoinTable
import jakarta.persistence.ManyToMany
import jakarta.persistence.OneToOne
import jakarta.persistence.Table
import java.time.Instant
import java.time.temporal.ChronoUnit

@Entity
@Table(name = "jobs")
class JobEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(nullable = false)
    var title: String = ""

    @Enumerated(EnumType.STRING)
    @Column
    var role: Role? = null

    @Enumerated(EnumType.STRING)
    @Column
    var level: Level? = null

//    @OneToOne(cascade = [CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH])
    @OneToOne
    @JoinColumn(name = "company_id", nullable = false)
    var company: CompanyEntity? = null

    @ManyToMany(fetch = FetchType.EAGER)
//    @ManyToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    @JoinTable(
        name = "jobs_skills",
        joinColumns = [JoinColumn(name = "job_id")],
        inverseJoinColumns = [JoinColumn(name = "skill_id")]
    )
    var skills: MutableSet<SkillEntity> = mutableSetOf()

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    var mainWorkLanguage: Language = Language.ENGLISH

    @Enumerated(EnumType.STRING)
    @Column
    var secondWorkLanguage: Language? = null

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    var country: Country = Country.FINLAND

    @Column
    var place: String? = null

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    var jobType: JobType = JobType.FULL_TIME

    @Column(nullable = false)
    var remote: Boolean = false

    @Column
    var sourceUrl: String? = null

    @Column(nullable = false)
    var description: String = ""

    @Column(nullable = false)
    var datePosted: Instant = Instant.now()

    @Column
    var dateExpired: Instant? = null

    @Column(nullable = false)
    var deleted: Boolean = false

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is JobEntity) return false

        if (id != other.id) return false
        if (title != other.title) return false
        if (role != other.role) return false
        if (level != other.level) return false
        if (company != other.company) return false
        if (mainWorkLanguage != other.mainWorkLanguage) return false
        if (secondWorkLanguage != other.secondWorkLanguage) return false
        if (country != other.country) return false
        if (place != other.place) return false
        if (jobType != other.jobType) return false
        if (remote != other.remote) return false
        if (sourceUrl != other.sourceUrl) return false
        if (datePosted.truncatedTo(ChronoUnit.MILLIS) != other.datePosted.truncatedTo(ChronoUnit.MILLIS)) return false
        if (dateExpired?.truncatedTo(ChronoUnit.MILLIS) != other.dateExpired?.truncatedTo(ChronoUnit.MILLIS)) return false
        if (deleted != other.deleted) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id?.hashCode() ?: 0
        result = 31 * result + title.hashCode()
        result = 31 * result + (role?.hashCode() ?: 0)
        result = 31 * result + (level?.hashCode() ?: 0)
        result = 31 * result + (company?.hashCode() ?: 0)
        result = 31 * result + mainWorkLanguage.hashCode()
        result = 31 * result + (secondWorkLanguage?.hashCode() ?: 0)
        result = 31 * result + country.hashCode()
        result = 31 * result + (place?.hashCode() ?: 0)
        result = 31 * result + jobType.hashCode()
        result = 31 * result + remote.hashCode()
        result = 31 * result + (sourceUrl?.hashCode() ?: 0)
        result = 31 * result + datePosted.hashCode()
        result = 31 * result + (dateExpired?.hashCode() ?: 0)
        result = 31 * result + deleted.hashCode()
        return result
    }
}