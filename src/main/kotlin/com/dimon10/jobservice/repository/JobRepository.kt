package com.dimon10.jobservice.repository

import com.dimon10.jobservice.entity.JobEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository

@Repository
interface JobRepository : JpaRepository<JobEntity, Long>, JpaSpecificationExecutor<JobEntity> {

}