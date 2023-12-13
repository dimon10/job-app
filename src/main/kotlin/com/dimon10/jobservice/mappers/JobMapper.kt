package com.dimon10.jobservice.mappers

import com.dimon10.jobservice.entity.JobEntity
import com.dimon10.jobservice.payload.JobRequest
import com.dimon10.jobservice.payload.JobResponse
import org.springframework.stereotype.Component

@Component
class JobMapper(private val companyMapper: CompanyMapper, private val skillMapper: SkillMapper) {

    fun mapToEntity(jobRequest: JobRequest): JobEntity {
        return JobEntity().apply {
            id = jobRequest.id
            title = jobRequest.title
            role = jobRequest.role
            level = jobRequest.level
            company = jobRequest.company?.let { companyMapper.mapToEntity(it) }
            mainWorkLanguage = jobRequest.mainWorkLanguage
            secondWorkLanguage = jobRequest.secondWorkLanguage
            country = jobRequest.country
            place = jobRequest.place
            jobType = jobRequest.jobType
            remote = jobRequest.remote
            sourceUrl = jobRequest.sourceUrl
            description = jobRequest.description
            datePosted = jobRequest.datePosted
            dateExpired = jobRequest.dateExpired
            deleted = false
        }

    }

    fun mapToResponse(jobEntity: JobEntity): JobResponse {
        return JobResponse(
            id = jobEntity.id!!,
            title = jobEntity.title,
            role = jobEntity.role,
            level = jobEntity.level,
            company = jobEntity.company?.let { companyMapper.mapToResponse(it) },
            skills = jobEntity.skills.map { skillMapper.mapToResponse(it) }.toSet(),
            mainWorkLanguage = jobEntity.mainWorkLanguage,
            secondWorkLanguage = jobEntity.secondWorkLanguage,
            country = jobEntity.country,
            place = jobEntity.place,
            jobType = jobEntity.jobType,
            remote = jobEntity.remote,
            sourceUrl = jobEntity.sourceUrl,
            description = jobEntity.description,
            datePosted = jobEntity.datePosted,
            dateExpired = jobEntity.dateExpired
        )
    }


}