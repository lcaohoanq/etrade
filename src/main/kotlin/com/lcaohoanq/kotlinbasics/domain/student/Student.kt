package com.lcaohoanq.kotlinbasics.domain.student

import com.lcaohoanq.kotlinbasics.base.BaseEntity
import jakarta.persistence.Entity
import java.time.LocalDateTime
import java.util.*

@Entity
class Student(
    var name: String,
    var age: Int,
    id: UUID,
    createdAt: LocalDateTime,
    updatedAt: LocalDateTime
) : BaseEntity(id, createdAt, updatedAt) {

    override fun toString(): String {
        return "Student(name='$name', age=$age, id=$id, createdAt=$createdAt, updatedAt=$updatedAt)"
    }

}