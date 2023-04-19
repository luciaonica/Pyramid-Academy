package com.genspark.BookManagementSystem.service;

import com.genspark.BookManagementSystem.entity.Book;
import com.genspark.BookManagementSystem.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public List<Book> getBooksByUser(int id) {
        return bookRepository.findByUserId(id);
    }


    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public Book updateBook(Book book) {
        return bookRepository.save(book);
    }

    public String deleteBookById(int bookId) {
        bookRepository.deleteById(bookId);
        return "The book was deleted successfully";
    }

    public Book getBookById(int bookId) {
        Optional<Book> b = bookRepository.findById(bookId);
        Book book = null;
        if (b.isPresent()){
            book = b.get();
        } else {
            throw new RuntimeException("Book ID " + bookId + " not found");
        }
        return book;
    }
}
