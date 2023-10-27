package com.example.demo.controller;

import com.example.demo.domain.Course;
import com.example.demo.domain.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/create")
    private long SaveStudent(@RequestBody Student student)
    {
        studentService.Save(student);
        return student.getId();
    }

    @GetMapping("/{id}")
    private Student getBooks(@PathVariable("id") int id)
    {
        return studentService.getStudentById(id);
    }

    @GetMapping("/getall")
    private List<Student> getAllStudent()
    {
        return studentService.getAllStudent();
    }

    @PutMapping("/update/{id}")
    private Student update( @PathVariable long id, @RequestBody Student student)
    {
        studentService.update(id, student);
        return student;
    }

    @DeleteMapping("/delete/{id}")
    private void deleteBook(@PathVariable("id") long id)
    {
        studentService.delete(id);
    }
}
