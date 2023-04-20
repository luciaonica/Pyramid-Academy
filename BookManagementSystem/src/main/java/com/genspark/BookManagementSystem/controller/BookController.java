package com.genspark.BookManagementSystem.controller;

import com.genspark.BookManagementSystem.entity.Book;
import com.genspark.BookManagementSystem.entity.UserInfo;
import com.genspark.BookManagementSystem.service.BookService;
import com.genspark.BookManagementSystem.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookService bookService;

    @Autowired
    UserInfoService userInfoService;

    @GetMapping("/all")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_USER')")
    public List<Book> getAllBooks(Principal principal) {
        UserInfo userInfo = userInfoService.getUserByName(principal.getName());
        if (userInfo.getRoles().contains("ADMIN")) {
            return bookService.getAllBooks();
        }
        return bookService.getBooksByUser(userInfo.getId());
    }

    @PostMapping("/add")
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @PutMapping("/add")
    public Book updateBook(@RequestBody Book book) {
        return bookService.updateBook(book);
    }

    @DeleteMapping("/delete/{bookId}")
    public String deleteBook(@PathVariable int bookId) {
        return bookService.deleteBookById(bookId);
    }
}
