package com.lcaohoanq.kotlinbasics.mapper

import com.lcaohoanq.kotlinbasics.domain.student.Student
import com.lcaohoanq.kotlinbasics.domain.student.StudentPort
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface StudentMapper {
    fun toStudentResponse(student: Student): StudentPort.StudentResponse
}