package com.alimert.services.impl;

import com.alimert.dto.DtoStudent;
import com.alimert.dto.DtoStudentIU;
import com.alimert.entities.Student;
import com.alimert.repository.StudentRepository;
import com.alimert.services.IStudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class StudentServiceImpl implements IStudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public DtoStudent saveStudent(DtoStudentIU dtoStudentIU) {
        DtoStudent response = new DtoStudent();
        Student student = new Student();
        BeanUtils.copyProperties(dtoStudentIU, student);

        Student dbStudent = studentRepository.save(student);
        BeanUtils.copyProperties(dbStudent, response);
        return response;
    }

    @Override
    public List<DtoStudent> getAllStudents() {
        List<DtoStudent> dtoStudents = new ArrayList<>();
        List<Student> studentList = studentRepository.findAll();
        for (Student student : studentList) {
            DtoStudent dtoStudent = new DtoStudent();
            BeanUtils.copyProperties(student, dtoStudent);
            dtoStudents.add(dtoStudent);
        }
        return dtoStudents;
    }

    @Override
    public Student getStudentById(Integer id) {
        Optional<Student> optional = studentRepository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public void deleteStudent(Integer id) {
        Student dbStudent = getStudentById(id);
        if (dbStudent != null) {
            studentRepository.delete(dbStudent);
        }
    }

    @Override
    public Student updateStudent(Integer id, Student updateStudent) {
        Student dbUpdateStudent = getStudentById(id);
        if (dbUpdateStudent != null) {
            dbUpdateStudent.setFirstName(updateStudent.getFirstName());
            dbUpdateStudent.setLastName(updateStudent.getLastName());
            dbUpdateStudent.setBirthOfDate(updateStudent.getBirthOfDate());
            return studentRepository.save(dbUpdateStudent);
        }
        return null;
    }
}
