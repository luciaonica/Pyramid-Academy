package com.genspark.StudentManagementSystem.controller;

import com.genspark.StudentManagementSystem.entity.Course;
import com.genspark.StudentManagementSystem.entity.UserInfo;
import com.genspark.StudentManagementSystem.service.CourseService;
import com.genspark.StudentManagementSystem.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    CourseService courseService;

    @Autowired
    UserInfoService userInfoService;

    @GetMapping("/all")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_STUDENT')")
    public List<Course> getAllCourses(Principal principal) {
        UserInfo userInfo = userInfoService.getUserByName(principal.getName());
        if (userInfo.getRoles().contains("ADMIN")) {
            return courseService.getCourses();
        }
        return courseService.getCoursesByUser(userInfo.getId());
    }

    @PostMapping("/add")
    public Course addCourse(@RequestBody Course course) {
        return courseService.addCourse(course);
    }

    @PutMapping("/add")
    public Course updateCourse(@RequestBody Course course) {
        return courseService.updateCourse(course);
    }

    @DeleteMapping("/delete/{courseId}")
    public String deleteCourse(@PathVariable int courseId) {
        return courseService.deleteCourseById(courseId);
    }


}
