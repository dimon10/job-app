package com.dimon10.jobservice.entity

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
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.time.Instant

@Entity
@Table(name = "experiences")
class ExperienceEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(nullable = false)
    var positionTitle: String = ""

    @Enumerated(EnumType.STRING)
    @Column
    var role: Role? = null

    @Enumerated(EnumType.STRING)
    @Column
    var level: Level? = null

    @Column
    var description: String? = null

    @Column(nullable = false)
    var startDate: Instant = Instant.now()

    @Column
    var endDate: Instant? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "candidate_id", nullable = false)
    var candidate: CandidateEntity? = null
}
