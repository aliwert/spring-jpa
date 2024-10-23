package com.alimert.services;

import com.alimert.dto.DtoStudent;
import com.alimert.dto.DtoStudentIU;
import com.alimert.entities.Student;

import java.util.List;

public interface IStudentService {

    public DtoStudent saveStudent(DtoStudentIU student);
    public List<DtoStudent> getAllStudents();
    public Student getStudentById(Integer id);
    public void deleteStudent(Integer id);
    public Student updateStudent(Integer id, Student updateStudent);
}
