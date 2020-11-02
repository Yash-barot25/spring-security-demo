package com.yash.springsecuritydemo.model;

import lombok.Getter;

@Getter
public class Student {

    private final Long studentId;
    private final String name;

    public Student(Long studentId, String name) {
        this.studentId = studentId;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                '}';
    }
}
