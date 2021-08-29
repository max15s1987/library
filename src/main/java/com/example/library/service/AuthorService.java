package com.example.library.service;

import com.example.library.model.Author;
import com.example.library.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public void save(Author author) {
        authorRepository.save(author);
    }

    public void update(Author author) {
        authorRepository.saveAndFlush(author);
    }

    public void remove(Long id) {
        authorRepository.deleteById(id);
    }

    public Author findById(long id) {
        Author author;
        Optional<Author> optional = authorRepository.findById(id);
        if (optional.isPresent()) {
            author = optional.get();
        } else {
            throw new RuntimeException("There is no author with ID = " + id + " in Database");
        }
        return author;
    }

}
