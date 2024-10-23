package com.alimert.controller;

import com.alimert.entities.Student;

import java.util.List;

public interface IStudentController {
    public Student saveStudent(Student student);
    public List<Student> getAllStudents();
}
