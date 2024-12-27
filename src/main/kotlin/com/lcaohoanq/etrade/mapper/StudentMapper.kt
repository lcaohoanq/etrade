package com.lcaohoanq.etrade.mapper

import com.lcaohoanq.etrade.domain.student.Student
import com.lcaohoanq.etrade.domain.student.StudentPort
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface StudentMapper {
    fun toStudentResponse(student: Student): StudentPort.StudentResponse
}