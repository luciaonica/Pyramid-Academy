package com.bookstrore.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="book")
@NamedQuery(name="Book.findByAuthor", query = "select b from Book b where b.author = :author")
@NamedQuery(name="Book.findByPublicationYearRange", query = "select b from Book b where b.publicationYear between :startYear and :endYear")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private float price;
    private int publicationYear;
}
