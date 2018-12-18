package com.example.learnspringboot.service;

import java.util.List;

import com.example.learnspringboot.dao.StudentDao;
import com.example.learnspringboot.entity.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class StudentService{
    @Autowired
    @Qualifier("mysqlDao")
    private StudentDao studentDao;

    public List<Student> getAllStudents(){
        return studentDao.getAllStudents();
    }

    public void addStudent(Student student){
        studentDao.addStudent(student);
    }

    public void updateStudent(Student student){
        studentDao.updateStudent(student);
    }

    public void deleteStudentById(int id){
        studentDao.deleteStudentById(id);
    }

    public Student getStudentById(int id){
        return studentDao.getStudentById(id);
    }
}