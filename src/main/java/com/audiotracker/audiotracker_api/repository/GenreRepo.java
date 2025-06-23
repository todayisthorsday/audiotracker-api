package com.audiotracker.audiotracker_api.repository;

import com.audiotracker.audiotracker_api.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepo extends JpaRepository<Genre, Long> {

}