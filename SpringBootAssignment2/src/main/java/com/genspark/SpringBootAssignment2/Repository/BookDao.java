package com.genspark.SpringBootAssignment2.Repository;

import com.genspark.SpringBootAssignment2.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookDao extends JpaRepository<Book, Integer> {

    //the books that have a page count bigger than given number
    @Query(value = "Select * from books where pages >= ?1", nativeQuery = true)
    List<Book> findBooksByNumberOfPages(int numberOfPages);

    @Query(value = "Select * from books where author like %?1%", nativeQuery = true)
    List<Book> findBooksByAuthor(String author);

    @Query(value = "Select * from books where title like %?1%", nativeQuery = true)
    List<Book> findBookByTitle(String title);

}
