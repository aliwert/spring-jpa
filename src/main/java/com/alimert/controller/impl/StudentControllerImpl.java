package com.alimert.controller.impl;

import com.alimert.controller.IStudentController;
import com.alimert.entities.Student;
import com.alimert.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/rest/api/student")

public class StudentControllerImpl implements IStudentController {
    @Autowired
    private IStudentService studentService;


    @PostMapping(path = "/save")
    @Override
    public Student saveStudent(@RequestBody Student student) {

        return studentService.saveStudent(student);
    }
    @GetMapping(path = "/list")
    @Override
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping(path = "/list/{id}")
    @Override
    public Student getStudentById(@PathVariable(name = "id") Integer id) {
        return studentService.getStudentById(id);
    }
}
