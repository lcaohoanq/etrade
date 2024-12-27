package com.lcaohoanq.kotlinbasics.domain.student

import com.lcaohoanq.kotlinbasics.mapper.StudentMapper
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Service
import java.util.*

@Service
class StudentService(
    private val studentRepository: StudentRepository,
    private val studentMapper: StudentMapper
) : IStudentService {
    override fun getStudentById(id: UUID): Student {
        return studentRepository.findById(id)
            .orElseThrow { throw RuntimeException("Student not found") }
    }

    override fun getStudents(): List<StudentPort.StudentResponse> {
        return studentRepository.findAll().stream().map(studentMapper::toStudentResponse).toList()
    }

    override fun saveStudent(student: Student): Student {
        return studentRepository.save(student)
    }

    override fun deleteStudent(id: UUID) {
        studentRepository.deleteById(id)
    }

}