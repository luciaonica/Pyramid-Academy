package com.genspark.SpringBootAssignment2.Service;

import com.genspark.SpringBootAssignment2.Entity.Book;
import com.genspark.SpringBootAssignment2.Repository.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookDao repo;

    @Override
    public List<Book> getAllBooks() {
        return this.repo.findAll();
    }

    @Override
    public Book getBookById(int bookId) {
        Optional<Book> b = this.repo.findById(bookId);
        Book book = null;
        if (b.isPresent()){
            book = b.get();
        } else {
            throw new RuntimeException("Book ID " + bookId + " not found");
        }
        return book;
    }

    @Override
    public Book addBook(Book book) {
        return this.repo.save(book);
    }

    @Override
    public Book updateBook(Book book) {
        return this.repo.save(book);
    }

    @Override
    public String deleteBookById(int bookId) {
        this.repo.deleteById(bookId);
        return "The book was deleted successfully";
    }

    @Override
    public List<Book> findBooksByAuthor(String author) {
        return this.repo.findBooksByAuthor(author);
    }

    @Override
    public List<Book> findBooksByNumberOfPages(int pages) {
        return this.repo.findBooksByNumberOfPages(pages);
    }

    @Override
    public List<Book> findBookByTitle(String title) {
        return this.repo.findBookByTitle(title);
    }
}
