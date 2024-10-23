package com.alimert.controller.impl;

import com.alimert.controller.IStudentController;
import com.alimert.dto.DtoStudent;
import com.alimert.dto.DtoStudentIU;
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
    public DtoStudent saveStudent(@RequestBody DtoStudentIU dtoStudentIU) {
        return studentService.saveStudent(dtoStudentIU);
    }
    @GetMapping(path = "/list")
    @Override
    public List<DtoStudent> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping(path = "/list/{id}")
    @Override
    public Student getStudentById(@PathVariable(name = "id") Integer id) {
        return studentService.getStudentById(id);
    }

    @DeleteMapping(path = "/delete/{id}")
    @Override
    public void deleteStudent(@PathVariable(name = "id") Integer id) {
        studentService.deleteStudent(id);
    }

    @PutMapping(path = "/update/{id}")
    @Override
    public Student updateStudent(@PathVariable(name = "id") Integer id, @RequestBody Student updateStudent) {
        return studentService.updateStudent(id, updateStudent);
    }


}
