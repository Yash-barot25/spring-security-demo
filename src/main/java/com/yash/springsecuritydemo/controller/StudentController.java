package com.yash.springsecuritydemo.controller;


import com.yash.springsecuritydemo.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class StudentController {

    private final List<Student> STUDENTS = Arrays.asList(
      new Student(1L, "Yash Barot") ,
      new Student(2L, "Gabbar Javan"),
      new Student(3L, "Batman")
    );

    @GetMapping("/{studentId}")
    public Student getStudent(@PathVariable Long studentId){
        return STUDENTS.stream()
                .filter(student -> studentId.equals(student.getStudentId()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException(studentId + " No such student found"));
    }


}
