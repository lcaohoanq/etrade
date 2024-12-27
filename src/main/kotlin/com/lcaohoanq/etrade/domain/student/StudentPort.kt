package com.lcaohoanq.etrade.domain.student

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime

interface StudentPort {
    
    data class StudentDTO(
        val name: String,
        val age: Int
    )
    
    data class StudentResponse(
        val id: String,
        val name: String,
        @JsonProperty("created_at") val createAt: LocalDateTime,
        @JsonProperty("updated_at")val updateAt: LocalDateTime
    )
    
}