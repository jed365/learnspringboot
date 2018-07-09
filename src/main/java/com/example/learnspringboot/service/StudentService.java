package com.example.learnspringboot.service;

import java.util.List;

import com.example.learnspringboot.dao.StudentDao;
import com.example.learnspringboot.entity.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService{
    @Autowired
    private StudentDao studentDao;

    public List<Student> getAllStudents(){
        return studentDao.getAllStudents();
    }
}