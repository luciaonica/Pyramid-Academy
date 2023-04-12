package com.genspark.SpringBootAssignment.Controller;

import com.genspark.SpringBootAssignment.Entity.Student;
import com.genspark.SpringBootAssignment.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public String home(){
        return "<HTML><h1>Welcome to Student Management System</h1></HTML>";
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        return this.studentService.getAllStudents();
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable String studentId ){
        return this.studentService.getStudentById(Integer.parseInt(studentId));
    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student){
        return this.studentService.addStudent(student);
    }

    @PutMapping("/students")
    public Student updateStudent(@RequestBody Student student){
        return this.studentService.updateStudent(student);
    }

    @DeleteMapping("/students/{studentId}")
    public String deleteStudent(@PathVariable String studentId){
        return this.studentService.deleteStudentById(Integer.parseInt(studentId));
    }

    @RequestMapping("/students/findByAddress")
    public List<Student> getStudentByAddress(@RequestParam(value = "add") String address ){
        return this.studentService.findStudentsByAddress(address);
    }

    @RequestMapping("/students/findByCourse")
    public List<Student> getStudentByCourse(@RequestParam(value = "course") String course){
        return this.studentService.findStudentsByCourse(course);
    }

    @RequestMapping("/students/findByName")
    public List<Student> getStudentByName(@RequestParam(value = "name") String name){
        return this.studentService.findStudentsByName(name);
    }
}
