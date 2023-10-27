package com.example.demo.service;

import com.example.demo.domain.Course;
import com.example.demo.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    public void Save(Course course)
    {
        courseRepository.save(course);
    }

    public List<Course> getAllCourse() {
        List<Course> Courses = new ArrayList<Course>();
        courseRepository.findAll().forEach(course1 -> Courses.add(course1));;
        return Courses;
    }

    public Course findById(Long id) {
        return courseRepository.findById(id).get();

    }
    public void delete(Long id ) {
        courseRepository.deleteById(id);
    }

    public void update(Long id, Course course) {
        Course course1 = courseRepository.findById(id).get();
        course1.setCoursename(course.getCoursename());
        course1.setDuration(course.getDuration());
        courseRepository.save(course1);
    }
}
