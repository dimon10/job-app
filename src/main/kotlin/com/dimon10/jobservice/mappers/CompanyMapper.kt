package com.dimon10.jobservice.mappers

import com.dimon10.jobservice.entity.CompanyEntity
import com.dimon10.jobservice.entity.CompanySocialLinkEntity
import com.dimon10.jobservice.payload.CompanyRequest
import com.dimon10.jobservice.payload.CompanyResponse
import com.dimon10.jobservice.payload.SocialLinkResponse
import org.springframework.stereotype.Component

@Component
class CompanyMapper {

    fun mapToEntity(companyRequest: CompanyRequest): CompanyEntity {
        return CompanyEntity().apply {
            id = companyRequest.id
            name = companyRequest.name
            description = companyRequest.description
            logoUrl = companyRequest.logoUrl
            socialLinks = companyRequest.socialLinks?.map {
                CompanySocialLinkEntity().apply {
                    id = it.id
                    resource = it.resource
                    url = it.url
                }
            }?.toMutableSet()
        }
    }

    fun mapToResponse(companyEntity: CompanyEntity): CompanyResponse {
        return CompanyResponse(
            id = companyEntity.id ?: throw IllegalArgumentException("Company id must not be null in the response"),
            name = companyEntity.name,
            description = companyEntity.description,
            logoUrl = companyEntity.logoUrl,
            socialLinks = companyEntity.socialLinks?.map {
                SocialLinkResponse(id = it.id!!, resource = it.resource!!, url = it.url)
            }?.toSet()
        )
    }

}
