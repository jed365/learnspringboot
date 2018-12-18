package com.example.learnspringboot.dao;

import java.util.List;

import com.example.learnspringboot.entity.Student;

public interface StudentDao {
    public List<Student> getAllStudents();
    public void addStudent(Student student);
    public void updateStudent(Student student);
    public void deleteStudentById(int id);
    public Student getStudentById(int id);
}