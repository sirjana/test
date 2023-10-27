package com.example.demo.controller;

import com.example.demo.domain.Course;
import com.example.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    CourseService courseService;

    @PostMapping("/create")
    public ResponseEntity<?> saveUser(@RequestBody Course course) {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        courseService.Save(course);
        map.put("status", 1);
        map.put("message", "Record is Saved Successfully!");
        return new ResponseEntity<>(map, HttpStatus.CREATED);
    }

    @GetMapping("/getall")
    public ResponseEntity<?> getUser() {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        List<Course> courseList = courseService.getAllCourse();
        if (!courseList.isEmpty()) {
            map.put("status", 1);
            map.put("data", courseList);
            return new ResponseEntity<>(map, HttpStatus.OK);
        } else {
            map.clear();
            map.put("status", 0);
            map.put("message", "Data is not found");
            return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        try {
            Course course = courseService.findById(id);
            map.put("status", 1);
            map.put("data", course);
            return new ResponseEntity<>(map, HttpStatus.OK);
        } catch (Exception ex) {
            map.clear();
            map.put("status", 0);
            map.put("message", "Data is not found");
            return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        courseService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateUserById(@PathVariable Long id, @RequestBody Course course) {
        courseService.update(id, course);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
