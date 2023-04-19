package com.genspark.BookManagementSystem.repository;

import com.genspark.BookManagementSystem.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    @Query(value = "SELECT b.* FROM books b INNER JOIN issues i ON b.book_id = i.book_id WHERE i.user_id = :userId", nativeQuery = true)
    List<Book> findByUserId(@Param("userId") int userId);
}
