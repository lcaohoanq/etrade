package com.lcaohoanq.kotlinbasics.domain.student

import java.util.*

interface IStudentService {
    fun getStudentById(id: UUID): Student

    fun getStudents(): List<StudentPort.StudentResponse>

    fun saveStudent(student: Student): Student

    fun deleteStudent(id: UUID)
}