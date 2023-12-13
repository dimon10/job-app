package com.dimon10.jobservice.repository

import com.dimon10.jobservice.core.model.JobType
import com.dimon10.jobservice.core.model.Level
import com.dimon10.jobservice.core.model.Role
import com.dimon10.jobservice.core.model.SocialResource
import com.dimon10.jobservice.entity.CompanyEntity
import com.dimon10.jobservice.entity.CompanySocialLinkEntity
import com.dimon10.jobservice.entity.JobEntity
import com.dimon10.jobservice.entity.SkillEntity
import jakarta.persistence.EntityManager
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest


@DataJpaTest
class JobRepositoryTest {
    @Autowired
    private lateinit var jobRepository: JobRepository
    @Autowired
    private lateinit var companyRepository: CompanyRepository
    @Autowired
    private lateinit var skillRepository: SkillRepository
    @Autowired
    private lateinit var em: EntityManager

    @Test
    fun GivenJobWithNewCompany_whenSave_thenOk() {

        val jobCompany = CompanyEntity().apply {
            name = "ABC-Jobs"
            description = "Test"
            logoUrl = "https://s3.eu-north-1.amazonaws.com/bucket1/logos/abc.svg"
            socialLinks = mutableSetOf(
                CompanySocialLinkEntity(SocialResource.SITE, "https://abc.com", this),
                CompanySocialLinkEntity(SocialResource.LINKEDIN, "https://linkedin.com/abc", this)
            )
        }

        companyRepository.save(jobCompany)

        val jobSkills = skillRepository.saveAll(listOf( SkillEntity("Java", "Java"),
            SkillEntity("Kotlin", "Kotlin")))

        val newJob = JobEntity().apply {
            title = "Senior Java Developer"
            description = "Test"
            company = jobCompany
            role = Role.BACKEND_DEVELOPER
            level = Level.SENIOR
            jobType = JobType.FULL_TIME
            skills = skillRepository.findAllByFullNameIn(listOf("Java", "Kotlin"))
            remote = true
        }

        jobRepository.save(newJob)

        em.clear()
        val actualJob = em.find(JobEntity::class.java, newJob.id)
        assertThat(actualJob).isEqualTo(newJob)
        assertThat(actualJob.skills).hasSize(2)
        assertThat(actualJob.skills).containsExactlyInAnyOrderElementsOf(newJob.skills)
    }

}