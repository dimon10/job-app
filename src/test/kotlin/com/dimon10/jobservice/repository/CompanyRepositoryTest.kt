package com.dimon10.jobservice.repository

import com.dimon10.jobservice.core.model.SocialResource
import com.dimon10.jobservice.entity.CompanyEntity
import com.dimon10.jobservice.entity.CompanySocialLinkEntity
import jakarta.persistence.EntityManager
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
class CompanyRepositoryTest {
    @Autowired
    private lateinit var companyRepository: CompanyRepository

    @Autowired
    private lateinit var em: EntityManager

    @Test
    fun givenCompany_whenSave_thenOk() {
        val newCompany = CompanyEntity().apply {
            name = "Test"
            description = "Test"
            logoUrl = "https://s3.eu-north-1.amazonaws.com/bucket1/logos/abc.svg"
            socialLinks = mutableSetOf(
                CompanySocialLinkEntity(SocialResource.SITE, "https://abc.com", this),
                CompanySocialLinkEntity(SocialResource.LINKEDIN, "https://linkedin.com/abc", this)
            )
        }

        companyRepository.save(newCompany)

        em.clear()
        val actualCompany = em.find(CompanyEntity::class.java, newCompany.id)
        assertThat(actualCompany).isEqualTo(newCompany)
        // lazy fetch for social links
        assertThat(actualCompany.socialLinks).hasSize(2)
        assertThat(actualCompany.socialLinks).containsExactlyInAnyOrderElementsOf(newCompany.socialLinks)
    }
}