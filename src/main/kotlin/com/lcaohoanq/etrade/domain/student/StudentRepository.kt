package com.lcaohoanq.etrade.domain.student

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface StudentRepository : JpaRepository<Student, UUID> {

    fun findByName(name: String): List<Student>

}