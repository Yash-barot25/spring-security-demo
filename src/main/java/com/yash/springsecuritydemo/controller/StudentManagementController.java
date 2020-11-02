package com.yash.springsecuritydemo.controller;

import com.yash.springsecuritydemo.model.Student;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("management/api/v1")
public class StudentManagementController {

    private final List<Student> STUDENTS = Arrays.asList(
            new Student(1L, "Yash Barot") ,
            new Student(2L, "Gabbar Javan"),
            new Student(3L, "Batman")
    );


    @GetMapping
    @PreAuthorize("hasAnyRole('ADMINTRAINEE', 'ADMIN')")
    public List<Student> getStudents(){
        System.out.println("ALL STUDENTS");
        return STUDENTS;
    }

    @DeleteMapping(path ="{studentId}")
    @PreAuthorize("hasAuthority('student:write')")
    public void deleteStudent(@PathVariable("studentId") Long id){
        System.out.println("DELETE STUDENT " + id);
    }

    @PutMapping(path = "{studentId}")
    @PreAuthorize("hasAuthority('student:write')")
    public void updateStudent (@PathVariable("studentId") Long id, @RequestBody Student student){
        System.out.println("Update student " + id  + " " + student);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('student:write')")
    public void insertStudent(@RequestBody Student student){
        System.out.println("Insert student " + student);
    }

}
