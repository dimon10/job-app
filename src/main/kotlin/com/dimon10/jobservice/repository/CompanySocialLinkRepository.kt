package com.dimon10.jobservice.repository

import com.dimon10.jobservice.entity.CompanySocialLinkEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CompanySocialLinkRepository : CrudRepository<CompanySocialLinkEntity, Long> {
}