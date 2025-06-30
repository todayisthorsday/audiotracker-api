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
    public Genre createGenre(Genre genre) {
        return genreRepo.save(genre);
    }
    public Genre updateGenre(Long id, Genre updatedGenre) {
        return genreRepo.findById(id).map(genre -> {
            genre.setName(updatedGenre.getName());
            genre.setDescription(updatedGenre.getDescription());
            return genreRepo.save(genre);
        }).orElse(null);
    }
    public void deleteGenre(long id) {
        genreRepo.deleteById(id);
    }

    public Optional<Genre> getGenreById(long id) {
        return genreRepo.findById(id);
    }
}
