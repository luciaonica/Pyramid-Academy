package com.genspark.BookManagementSystem.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/welcome")
public class MyController {

    @GetMapping("")
    public  String publicUser(){
        return "<html><h1>Welcome to Book Management System</h1></html>";
    }

}
