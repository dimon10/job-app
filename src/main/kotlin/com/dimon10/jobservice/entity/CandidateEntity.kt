package com.dimon10.jobservice.entity

import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.JoinTable
import jakarta.persistence.ManyToMany
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import java.time.Instant

@Entity
@Table(name = "candidates")
class CandidateEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(nullable = false)
    var name: String = ""

    @Column
    var email: String? = null

    @OneToMany(mappedBy = "candidate", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    var socialLinks: MutableSet<CandidateSocialLinkEntity>? = mutableSetOf()

    @Column
    var phone: String? = null

    @Column(nullable = false)
    var dateCreated: Instant = Instant.now()

    @Column
    var dateUpdated: Instant? = Instant.now()

    @Column
    var dateDeleted: Instant? = null

    @Column(nullable = false)
    var deleted: Boolean = false

    @ManyToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    @JoinTable(
        name = "candidates_skills",
        joinColumns = [JoinColumn(name = "candidate_id")],
        inverseJoinColumns = [JoinColumn(name = "skill_id")]
    )
    var skills: MutableSet<SkillEntity> = mutableSetOf()

    @OneToMany(mappedBy = "candidate", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    var experience: MutableCollection<ExperienceEntity>? = mutableListOf()

    @Column(nullable = false)
    var yearsOfExperience: Int = 0
//
//    @ManyToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
//    @JoinTable(
//        name = "candidates_languages",
//        joinColumns = [JoinColumn(name = "candidate_id")],
//        inverseJoinColumns = [JoinColumn(name = "language_id")]
//    )
//    var workLanguages: MutableSet<Language> = mutableSetOf()
//
//    @Enumerated(EnumType.STRING)
//    @Column
//    var country: Country = Country.FINLAND
//
//    @Column
//    var place: String? = null
//
//    var workPermit: MutableSet<Country> = mutableSetOf()
//    var preferredRoles: MutableSet<Role> = mutableSetOf()
//    var preferredJobTypes: MutableSet<JobType> = mutableSetOf()
}