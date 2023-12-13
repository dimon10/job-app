package com.dimon10.jobservice.controller.rest

import com.dimon10.jobservice.payload.JobRequest
import com.dimon10.jobservice.payload.JobResponse
import com.dimon10.jobservice.service.JobService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class JobRestController @Autowired constructor(private val jobService: JobService) {

    @PostMapping("/jobs")
    fun createJob(@RequestBody jobRequest: JobRequest): JobResponse {
        jobRequest.id?.let { throw IllegalArgumentException("Job id must be null when creating new job") }
        return jobService.createJob(jobRequest)
    }

    @GetMapping("/jobs")
    fun getJobs(): List<JobResponse> {
        return jobService.getJobs()
    }

    @GetMapping("/jobs/{jobId}")
    fun getJob(jobId: Long): JobResponse? {
        return jobService.getJob(jobId)
    }
}