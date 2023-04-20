package com.genspark.StudentManagementSystem.service;

import com.genspark.StudentManagementSystem.entity.UserInfo;
import com.genspark.StudentManagementSystem.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserInfoService {

    @Autowired
    UserInfoRepository userInfoRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<UserInfo> getUsers() {
        return userInfoRepository.findAll();
    }

    public UserInfo getUserById(int id) {
        Optional<UserInfo> u = userInfoRepository.findById(id);
        UserInfo user = null;
        if (u.isPresent()){
            user = u.get();
        } else {
            throw new RuntimeException("User ID " + id + " not found");
        }
        return user;
    }

    public UserInfo addUser(UserInfo userInfo) {
        String encodedPassword = passwordEncoder.encode(userInfo.getPassword());
        userInfo.setPassword(encodedPassword);
        return userInfoRepository.save(userInfo);
    }

    public UserInfo updateUser(UserInfo userInfo) {
        String encodedPassword = passwordEncoder.encode(userInfo.getPassword());
        userInfo.setPassword(encodedPassword);
        return userInfoRepository.save(userInfo);
    }

    public String deleteUserById(int userId) {
        userInfoRepository.deleteById(userId);
        return "The user was deleted successfully";
    }

    public UserInfo getUserByName(String name) {
        return userInfoRepository.findByName(name).get();
    }
}
