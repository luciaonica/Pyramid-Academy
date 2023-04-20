package com.genspark.StudentManagementSystem.service;

import com.genspark.StudentManagementSystem.entity.Course;
import com.genspark.StudentManagementSystem.entity.UserInfo;
import com.genspark.StudentManagementSystem.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepository;
    public List<Course> getCourses() {
        return courseRepository.findAll();
    }

    public Course getCourseById(int id) {
        Optional<Course> c = courseRepository.findById(id);
        Course course = null;
        if (c.isPresent()){
            course = c.get();
        } else {
            throw new RuntimeException("Course ID " + id + " not found");
        }
        return course;
    }

    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    public Course updateCourse(Course course) {
        return courseRepository.save(course);
    }

    public String deleteCourseById(int courseId) {
        courseRepository.deleteById(courseId);
        return "The course was deleted successfully";
    }

    public List<Course> getCoursesByUser(int id) {
        return courseRepository.findByUserId(id);
    }


}
