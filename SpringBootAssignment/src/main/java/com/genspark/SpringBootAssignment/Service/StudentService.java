package com.genspark.SpringBootAssignment.Service;

import com.genspark.SpringBootAssignment.Entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    Student getStudentById(int studentId);
    Student addStudent(Student student);
    Student updateStudent(Student student);
    String deleteStudentById(int studentId);
    List<Student> findStudentsByAddress(String address);
    List<Student> findStudentsByCourse(String course);
    List<Student> findStudentsByName(String name);
}
