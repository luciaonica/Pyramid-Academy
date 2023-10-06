package com.bookstrore.controller;

import com.bookstrore.entity.Book;
import com.bookstrore.service.BookService;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping
    public Book createBook(@RequestBody Book book){
        return bookService.createBook(book);
    }

    @PutMapping
    public Book updateBook(@RequestBody Book book) {
        return bookService.updateBook(book);
    }

    @DeleteMapping("/{bookId}")
    public String deleteBook(@PathVariable String bookId) {
        return bookService.deleteBookById(Long.parseLong(bookId));
    }

    @GetMapping("/byAuthor")
    public List<Book> getBooksByAuthor(@RequestParam(value = "author") String author){
        return this.bookService.getBooksByAuthor(author);
    }

    @GetMapping("/byPublicationYearRange")
    public List<Book> getBooksByPublicationYearRange(@RequestParam(value = "startYear") String startYear, @RequestParam(value = "endYear") String endYear){
        return this.bookService.getBooksByPublicationYearRange(Integer.parseInt(startYear), Integer.parseInt(endYear));
    }
}
