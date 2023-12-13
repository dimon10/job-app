package com.dimon10.jobservice.repository

import com.dimon10.jobservice.entity.CompanyEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CompanyRepository : CrudRepository<CompanyEntity, Long> {
}