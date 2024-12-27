package com.lcaohoanq.kotlinbasics.domain.student

import lombok.RequiredArgsConstructor
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
class StudentController(
    private val studentService: IStudentService
) {

    @GetMapping("")
    fun getStudents(): ResponseEntity<List<StudentPort.StudentResponse>> {
        return ResponseEntity.ok(studentService.getStudents())
    }

}