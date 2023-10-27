package com.example.demo.service;

import com.example.demo.domain.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public void Save(Student student)
    {
        studentRepository.save(student);
    }

    public Student getStudentById(long id)
    {
        return studentRepository.findById(id).get();
    }

    public List<Student> getAllStudent() {
        List<Student> Students = new ArrayList<Student>();
        studentRepository.findAll().forEach(student1 -> Students.add(student1));;
        return Students;
    }

    public void update(long id, Student student)
    {
        studentRepository.save(student);
    }

    public void delete(long id)
    {
        studentRepository.deleteById(id);
    }
}
