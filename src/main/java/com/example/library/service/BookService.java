package com.example.library.service;
import com.example.library.model.Book;
import com.example.library.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public void save(Book book) {
        bookRepository.save(book);
    }

    public void update(Book book) {
        bookRepository.saveAndFlush(book);
    }

    public void remove(Long id) {
        bookRepository.deleteById(id);
    }

    public Book findById(long id) {
        Book book;
        Optional<Book> optional = bookRepository.findById(id);
        if (optional.isPresent()) {
            book = optional.get();
        } else {
            throw new RuntimeException("There is no book with ID = " + id + " in Database");
        }
        return book;
    }


}
