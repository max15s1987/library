package com.example.library.service;

import com.example.library.model.Genre;
import com.example.library.repository.GenreRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenreService {

    private final GenreRepository genreRepository;

    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public List<Genre> getAllBooks() {
        return genreRepository.findAll();
    }

    public void save(Genre genre) {
        genreRepository.save(genre);
    }

    public void update(Genre genre) {
        genreRepository.saveAndFlush(genre);
    }

    public void remove(Long id) {
        genreRepository.deleteById(id);
    }

    public Genre findById(long id) {
        Genre genre;
        Optional<Genre> optional = genreRepository.findById(id);
        if (optional.isPresent()) {
            genre = optional.get();
        } else {
            throw new RuntimeException("There is no genre with ID = " + id + " in Database");
        }
        return genre;
    }

}
