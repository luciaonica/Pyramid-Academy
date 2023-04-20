package com.genspark.StudentManagementSystem.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/welcome")
public class MyController {

    @GetMapping("")
    public String welcome() {
        return "<html><h1>Welcome to Student Management System</h1></html>";
    }
}
