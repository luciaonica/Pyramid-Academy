package com.bookstrore;

import com.bookstrore.entity.Book;
import com.bookstrore.repo.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest(showSql = false)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class BookRepositoryTests {

    @Autowired
    private BookRepository repo;

    @Test
    public void testCreateBook(){
        Book book = new Book();
        book.setAuthor("Victor Hugo");
        book.setTitle("Les Contemplations");
        book.setPublicationYear(1862);
        book.setPrice(18.5f);
        Book savedBook = repo.save(book);
        assertThat(savedBook.getId()).isGreaterThan(0);
    }

    @Test
    public void testFindByAuthor() {
        List<Book> list = repo.findByAuthor("Victor Hugo");
        System.out.println(list);
    }

    @Test
    public void testFindByYear() {
        List<Book> list = repo.findByPublicationYearRange(1800, 1900);
        System.out.println(list);
    }
}
