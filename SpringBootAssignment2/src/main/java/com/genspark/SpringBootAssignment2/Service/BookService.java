package com.genspark.SpringBootAssignment2.Service;

import com.genspark.SpringBootAssignment2.Entity.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();
    Book getBookById(int bookId);
    Book addBook(Book book);
    Book updateBook(Book book);
    String deleteBookById(int bookId);
    List<Book> findBooksByAuthor(String author);
    List<Book> findBooksByNumberOfPages(int pages);
    List<Book> findBookByTitle(String title);
}
