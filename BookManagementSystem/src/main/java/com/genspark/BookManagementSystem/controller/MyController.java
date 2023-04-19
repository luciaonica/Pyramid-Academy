package com.genspark.BookManagementSystem.controller;

import com.genspark.BookManagementSystem.entity.Book;
import com.genspark.BookManagementSystem.entity.User;
import com.genspark.BookManagementSystem.service.BookService;
import com.genspark.BookManagementSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/home")
public class MyController {

    @Autowired
    BookService bookService;
    @Autowired
    UserService userService;

    @GetMapping("/public")
    public  String publicUser(){
        return "<html><h1>Welcome to Book Management System</h1></html>";
    }

    @GetMapping("/viewbooks")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_NORMAL')")
    public List<Book> showBooksByUser(Principal principal){
        User user = userService.getUserByEmail(principal.getName());
        if (user.getRole().equals("ADMIN")){
            return bookService.getAllBooks();
        }
        return bookService.getBooksByUser(user.getUserId());
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @PostMapping("/books")
    public Book addBook(@RequestBody Book book){
        return bookService.addBook(book);
    }

    @PutMapping("/books")
    public Book updateBook(@RequestBody Book book){
        return bookService.updateBook(book);
    }

    @PutMapping("/users")
    public User updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    @DeleteMapping("/books/{bookId}")
    public String deleteBook(@PathVariable String bookId){
        return bookService.deleteBookById(Integer.parseInt(bookId));
    }

    @DeleteMapping("/users/{userId}")
    public String deleteUser(@PathVariable String userId){
        return userService.deleteUserById(Integer.parseInt(userId));
    }

    @GetMapping("/users")
    public List<User> getUser(){
        return userService.getAllUsers();
    }

    @GetMapping("/books/{bookId}")
    public Book getBook(@PathVariable String bookId){
        return bookService.getBookById(Integer.parseInt(bookId));
    }

    @GetMapping("/users/{userId}")
    public User getUser(@PathVariable String userId){
        return userService.getUserById(Integer.parseInt(userId));
    }

}
