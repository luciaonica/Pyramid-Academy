package com.genspark.BookManagementSystem.controller;


import com.genspark.BookManagementSystem.entity.UserInfo;
import com.genspark.BookManagementSystem.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserInfoService userInfoService;

    @GetMapping("/all")
    public List<UserInfo> getAllUsers() {
        return userInfoService.getUsers();
    }

    @GetMapping("/{id}")
    public UserInfo getUserById(@PathVariable int id) {
        return userInfoService.getUserById(id);
    }

    @PostMapping("/add")
    public UserInfo addUser(@RequestBody UserInfo userInfo) {
        return userInfoService.addUser(userInfo);
    }

    @PutMapping("/add")
    public UserInfo updateUser(@RequestBody UserInfo userInfo) {
        return userInfoService.updateUser(userInfo);
    }

    @DeleteMapping("/delete/{userId}")
    public String deleteUser(@PathVariable int userId) {
        return userInfoService.deleteUserById(userId);
    }

}

