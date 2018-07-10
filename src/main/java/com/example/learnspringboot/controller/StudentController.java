package com.example.learnspringboot.controller;

import java.util.List;

import com.example.learnspringboot.entity.Student;
import com.example.learnspringboot.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
    
    @RequestMapping(method=RequestMethod.POST)
    public void addStudent(@RequestBody Student student){
        studentService.addStudent(student);
    }

    @RequestMapping( method = RequestMethod.PUT )
    public void updateStudent(@RequestBody Student student){
        studentService.updateStudent(student);
    }

    @RequestMapping( method = RequestMethod.DELETE, value = "/{id}")
    public void deleteStudentById(@PathVariable("id") int id){
        studentService.deleteStudentById(id);
    }

    @RequestMapping( method = RequestMethod.GET, value = "/{id}")
    public Student getStudentById(@PathVariable("id") int id){
        return studentService.getStudentById(id);
    }
}