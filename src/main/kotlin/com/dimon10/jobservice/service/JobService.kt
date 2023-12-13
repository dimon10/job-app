package com.dimon10.jobservice.service

import com.dimon10.jobservice.mappers.JobMapper
import com.dimon10.jobservice.payload.JobRequest
import com.dimon10.jobservice.payload.JobResponse
import com.dimon10.jobservice.repository.CompanyRepository
import com.dimon10.jobservice.repository.JobRepository
import com.dimon10.jobservice.repository.SkillRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import kotlin.jvm.optionals.getOrNull

@Service
class JobService @Autowired constructor(
    private val jobRepository: JobRepository,
    private val skillRepository: SkillRepository,
    private val companyRepository: CompanyRepository,
    private val jobMapper: JobMapper
) {
    fun getJobs(): List<JobResponse> {

        return jobRepository.findAll().map { jobMapper.mapToResponse(it) }
    }

    fun getJob(jobId: Long): JobResponse? {
        return jobRepository.findById(jobId).map { jobMapper.mapToResponse(it) }.getOrNull()
    }

    fun createJob(jobRequest: JobRequest): JobResponse {
        val jobEntity = jobMapper.mapToEntity(jobRequest)
        // save new company if it doesn't exist
        jobEntity.company = jobEntity.company?.id?.let { companyRepository.findById(it).getOrNull() }
            ?: jobEntity.company?.let { companyRepository.save(it) }
        // find skills entity by ids
        jobRequest.skills.takeIf { it.isNotEmpty() }
            ?.let { jobEntity.skills = skillRepository.findAllById(it).toMutableSet() }

        val savedJob = jobRepository.save(jobEntity)
        return jobMapper.mapToResponse(savedJob)
    }

//    fun updateJob(jobRequest: JobRequest): JobResponse

    fun deleteJob(jobId: Long) {}
}