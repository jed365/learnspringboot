package com.example.learnspringboot.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.learnspringboot.entity.Student;

import org.springframework.stereotype.Repository;

@Repository
public class StudentDao{
    private static Map<Integer,Student> students;
    static {
        students = new HashMap<Integer,Student>(){
           private static final long serialVersionUID = 5573462579429373668L;
		   {    
            put(1,new Student(1,"张三","语文")); 
            put(2,new Student(2,"李四","数学")); 
            put(3,new Student(3,"王五","英语")); 
           }
        };
    }
    
    public List<Student> getAllStudents(){
        return new ArrayList<>(students.values());
    }

    public void addStudent(Student student){
        students.put(student.getId(),student);
    }

    public void updateStudent(Student student){
        Student stu = students.get(student.getId());
        stu.setId(student.getId());
        stu.setName(student.getName());
        stu.setCourse(student.getCourse());
        students.put(stu.getId(),stu);
    }

    public void deleteStudentById(int id){
        students.remove(id);
    }

    public Student getStudentById(int id){
        return students.get(id);
    }
}