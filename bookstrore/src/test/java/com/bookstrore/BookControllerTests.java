package com.bookstrore;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.bookstrore.entity.Book;
import com.bookstrore.repo.BookRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Optional;

@SpringBootTest
@AutoConfigureMockMvc
public class BookControllerTests {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    BookRepository repo;

    @Test
    public void testFindBooksByAuthor() throws Exception {
        String url = "/books/byAuthor?author=Victor Hugo";

        MvcResult result = mockMvc.perform(get(url))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();

        String jsonResponse = result.getResponse().getContentAsString();
        Book[] books = objectMapper.readValue(jsonResponse, Book[].class);

        assertThat(books).hasSizeGreaterThan(0);
    }

    @Test
    public void testFindBooksByYearRange() throws Exception {
        String url = "/books/byPublicationYearRange?startYear=1860&endYear=2020";

        MvcResult result = mockMvc.perform(get(url))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();

        String jsonResponse = result.getResponse().getContentAsString();
        Book[] books = objectMapper.readValue(jsonResponse, Book[].class);

        assertThat(books).hasSizeGreaterThan(0);
    }

    @Test
    public void testCreateBook() throws Exception {
        String url = "/books";

        Book book = new Book(null, "The Nightingale", "Kristin Hannah", 28.99f, 2015);

        MvcResult result = mockMvc.perform(post(url).contentType("application/json")
                        .content(objectMapper.writeValueAsString(book)))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        String response = result.getResponse().getContentAsString();
        //System.out.println("book: " + response);

        Book savedBook = objectMapper.readValue(response, Book.class);
        //System.out.println("book: " + savedBook);

        assertThat(savedBook.getId()).isGreaterThan(0);
    }

    @Test
    public void testUpdateBook() throws JsonProcessingException, Exception {
        String url = "/books";

        Long bookId = 4l;
        String bookTitle = "OCP Study Guide";
        String bookAuthor = "Jeanne Boyarsky";
        float bookPrice = 49.0f;
        int year = 2020;

        Book book = new Book(bookId, bookTitle, bookAuthor, bookPrice, year);

        mockMvc.perform(put(url).contentType("application/json")
                        .content(objectMapper.writeValueAsString(book)))
                .andDo(print())
                .andExpect(status().isOk());

        Optional<Book> findById = repo.findById(bookId);
        assertThat(findById.isPresent());

        Book savedBook = findById.get();
        assertThat(savedBook.getTitle()).isEqualTo(bookTitle);
    }
}
