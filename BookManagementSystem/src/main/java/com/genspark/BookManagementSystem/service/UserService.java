package com.genspark.BookManagementSystem.service;

import com.genspark.BookManagementSystem.entity.User;
import com.genspark.BookManagementSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User getUserByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public User addUser(User user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        return userRepository.save(user);
    }

    public User updateUser(User user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        return userRepository.save(user);
    }

    public String deleteUserById(int userId) {
        userRepository.deleteById(userId);
        return "The user was deleted successfully";
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(int userId) {
        Optional<User> u = userRepository.findById(userId);
        User user = null;
        if (u.isPresent()){
            user = u.get();
        } else {
            throw new RuntimeException("User ID " + userId + " not found");
        }
        return user;
    }
}