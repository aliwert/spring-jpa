package com.alimert.services.impl;

import com.alimert.dto.DtoCourse;
import com.alimert.dto.DtoStudent;
import com.alimert.dto.DtoStudentIU;
import com.alimert.entities.Course;
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
    public DtoStudent getStudentById(Integer id) {
        DtoStudent dtoStudent = new DtoStudent();
        Optional<Student> optional = studentRepository.findStudentById(id);
        if (optional.isEmpty()) {
            return null;
        }
        Student dbStudent = optional.get();
        BeanUtils.copyProperties(dbStudent, dtoStudent);
        if (dbStudent.getCourses() != null && !dbStudent.getCourses().isEmpty()) {
            for (Course course : dbStudent.getCourses()) {
                DtoCourse dtoCourse = new DtoCourse();
                BeanUtils.copyProperties(course, dtoCourse);

                dtoStudent.getCourses().add(dtoCourse);


            }
        }
        return dtoStudent;

    }

    @Override
    public void deleteStudent(Integer id) {
        Optional<Student> optional = studentRepository.findById(id);
        if (optional != null) {
            studentRepository.delete(optional.get());
        }
    }

    @Override
    public DtoStudent updateStudent(Integer id, DtoStudentIU dtoStudentIU) {
        DtoStudent dtoStudent = new DtoStudent();

        Optional<Student> optional = studentRepository.findById(id);
        if (optional.isPresent()) {
            Student dbStudent = optional.get();
            dbStudent.setFirstName(dtoStudentIU.getFirstName());
            dbStudent.setLastName(dtoStudentIU.getLastName());
            dbStudent.setBirthOfDate(dtoStudentIU.getBirthOfDate());
            Student updated = studentRepository.save(dbStudent);
            BeanUtils.copyProperties(updated, dtoStudent);
            return dtoStudent;
        }
        return null;
    }
}
