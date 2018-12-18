package com.example.learnspringboot.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.example.learnspringboot.entity.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("mysqlDao")
public class MysqlStudentDaoImpl implements StudentDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    private static class StudentRowMapper implements RowMapper<Student>{

        @Override
        public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
            Student student = new Student();
            student.setId(rs.getInt("id"));
            student.setName(rs.getString("name"));
            student.setCourse(rs.getString("course"));
            return student;
        }

    }
    public List<Student> getAllStudents(){
        final String sql = "SELECT id,name,course FROM students";
        List<Student> students = jdbcTemplate.query(sql,new StudentRowMapper());
        return students;
    }
    public void addStudent(Student student){
        final String sql = "INSERT INTO students(name,course) values(?,?)";
        final String name = student.getName();
        final String course = student.getCourse();
        jdbcTemplate.update(sql, new Object[]{name,course});
    }
    public void updateStudent(Student student){
        final String sql = "UPDATE students set name=?,course=? WHERE id=?";
        final String name = student.getName();
        final String course = student.getCourse();
        final Integer id = student.getId();
        jdbcTemplate.update(sql, new Object[]{name,course,id});

    }
    public void deleteStudentById(int id){
        final String sql = "DELETE FROM students WHERE id=?";
        jdbcTemplate.update(sql, id);

    }
    public Student getStudentById(int id){
        final String sql = "SELECT id,name,course FROM students where id=?";
        return  jdbcTemplate.queryForObject(sql,new StudentRowMapper(),id);   
    }
}