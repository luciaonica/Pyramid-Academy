package com.bookstrore.service;

import com.bookstrore.entity.Book;
import com.bookstrore.repo.BookRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    private final EntityManager entityManager;

    public Book createBook(Book book){
        return bookRepository.save(book);
    }

    public Book updateBook(Book book) {
        return bookRepository.save(book);
    }

    public String deleteBookById(long bookId) {
        bookRepository.deleteById(bookId);
        return "The book was deleted successfully";
    }

    public List<Book> getBooksByAuthor(String author) {
        //return bookRepository.findByAuthor(author);
        TypedQuery<Book> typedQuery = entityManager.createNamedQuery("Book.findByAuthor", Book.class);
        typedQuery.setParameter("author", author);

        return  typedQuery.getResultList();
    }

    public List<Book> getBooksByPublicationYearRange(int startYear, int endYear) {
        //return bookRepository.findByPublicationYearRange(startYear, endYear);

        TypedQuery<Book> typedQuery = entityManager.createNamedQuery("Book.findByPublicationYearRange", Book.class);
        typedQuery.setParameter("startYear", startYear);
        typedQuery.setParameter("endYear", endYear);

        return  typedQuery.getResultList();
    }
}
