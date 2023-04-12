package com.genspark.SpringBootAssignment.Service;

import com.genspark.SpringBootAssignment.Entity.Student;
import com.genspark.SpringBootAssignment.Repository.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentDao repo;

    @Override
    public List<Student> getAllStudents() {
        return this.repo.findAll();
    }

    @Override
    public Student getStudentById(int studentId) {
        Optional<Student> st = this.repo.findById(studentId);
        Student student = null;
        if (st.isPresent()){
            student = st.get();
        } else {
            throw new RuntimeException("Student ID " + studentId + " not found");
        }
        return student;
    }

    @Override
    public Student addStudent(Student student) {
        return this.repo.save(student);
    }

    @Override
    public Student updateStudent(Student student) {
        return this.repo.save(student);
    }

    @Override
    public String deleteStudentById(int studentId) {
        this.repo.deleteById(studentId);
        return "The student was deleted successfully";
    }

    @Override
    public List<Student> findStudentsByAddress(String address) {
        return this.repo.findStudentsByAddress(address);
    }

    @Override
    public List<Student> findStudentsByCourse(String course) {
        return this.repo.findStudentsByCourse(course);
    }

    @Override
    public List<Student> findStudentsByName(String name) {
        return this.repo.findStudentsByName(name);
    }
}
