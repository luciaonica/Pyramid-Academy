package com.genspark.SpringBootAssignment2.Controller;

import com.genspark.SpringBootAssignment2.Entity.Book;
import com.genspark.SpringBootAssignment2.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public String home(){
        return "<HTML><h1>Welcome to My Book Management System</h1></HTML>";
    }

    @GetMapping("/books")
    public List<Book> getBooks(){
        return this.bookService.getAllBooks();
    }

    @GetMapping("/books/{bookId}")
    public Book getBook(@PathVariable String bookId){
        return this.bookService.getBookById(Integer.parseInt(bookId));
    }

    @PostMapping("/books")
    public Book addBook(@RequestBody Book book){
        return this.bookService.addBook(book);
    }

    @PutMapping("/books")
    public Book updateBook(@RequestBody Book book){
        return this.bookService.updateBook(book);
    }

    @DeleteMapping("/books/{bookId}")
    public String deleteBook(@PathVariable String bookId){
        return this.bookService.deleteBookById(Integer.parseInt(bookId));
    }

    @RequestMapping("/books/findByAuthor")
    public List<Book> getBookByAuthor(@RequestParam(value = "author") String author ){
        return this.bookService.findBooksByAuthor(author);
    }

    @RequestMapping("/books/findByNumberOfPages")
    public List<Book> getBookByNumberOfPages(@RequestParam(value = "pages") String pages ){
        return this.bookService.findBooksByNumberOfPages(Integer.parseInt(pages));
    }

    @RequestMapping("/books/findByTitle")
    public List<Book> getBookByTitle(@RequestParam(value = "title") String title ){
        return this.bookService.findBookByTitle(title);
    }
}
