package com.dimon10.jobservice.mappers

import com.dimon10.jobservice.entity.SkillEntity
import com.dimon10.jobservice.payload.SkillResponse
import org.springframework.stereotype.Component

@Component
class SkillMapper {
    fun mapToResponse(skillEntity: SkillEntity): SkillResponse {
        return SkillResponse(
            id = skillEntity.id ?: throw IllegalArgumentException("Skill id must not be null in the response"),
            fullName = skillEntity.fullName,
            shortName = skillEntity.shortName,
            description = skillEntity.description
        )
    }


}