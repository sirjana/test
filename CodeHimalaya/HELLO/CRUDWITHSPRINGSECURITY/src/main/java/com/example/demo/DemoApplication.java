package com.example.demo;

import com.example.demo.domain.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);


        List<String> studentlist = Arrays.asList("bhusan", "shyam", "Hari");

        long namecount = studentlist.stream().filter(x -> x.startsWith("b")).count();
       // System.out.println("name of student which name starts with letter b: " + namecount);
    }
























}
