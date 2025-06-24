package com.audiotracker.audiotracker_api.service;

import com.audiotracker.audiotracker_api.model.Genre;
import com.audiotracker.audiotracker_api.repository.GenreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenreService {

    @Autowired
    private GenreRepo genreRepo;

    public List<Genre> getAllGenres() {
        return genreRepo.findAll();
    }
    public Optional<Genre> getGenreById(long id) {
        return genreRepo.findById(id);
    }
    public Genre createGenre(Genre genre) {
        return genreRepo.save(genre);
    }
    public Genre updateGenre(Long id, updatedGenre) {
        return genreRepo.findById(id).map(genre -> {
            genre.setName(updateGenre().getName());
            genre.setDescription(updatedGenre.getDescription());
            return genreRepo.save(genre);
        }).orElse(null);
    }
    public void deleteGenre(long id) {
        genreRepo.deleteById(id);
    }
}
