package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {


    @Autowired
    StudentService studentService;

    @GetMapping("/{id}")
    private Student getStudents(@PathVariable("id") int id)
    {
        return studentService.getStudentById(id);
    }

    @GetMapping("/")
    private List<Student> getAllStudent()
    {
        return studentService.getAllStudent();
    }

    @PostMapping("/create")
    private long SaveStudent(@RequestBody Student student)
    {
        studentService.Save(student);
        return student.getId();
    }

}
