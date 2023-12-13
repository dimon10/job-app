package com.dimon10.jobservice.repository

import com.dimon10.jobservice.entity.SkillEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface SkillRepository : CrudRepository<SkillEntity, Long> {
    fun findAllByFullName(fullName: String): MutableSet<SkillEntity>

    fun findAllByFullNameIn(fullNames: List<String>): MutableSet<SkillEntity>
}