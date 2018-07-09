package com.example.learnspringboot.controller;

import java.util.List;

import com.example.learnspringboot.entity.Student;
import com.example.learnspringboot.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController{

    @Autowired
    private StudentService studentService;
    
    @RequestMapping(method=RequestMethod.GET )
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }
}