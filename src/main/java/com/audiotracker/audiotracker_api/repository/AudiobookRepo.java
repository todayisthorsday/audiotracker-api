package com.audiotracker.audiotracker_api.repository;

import com.audiotracker.audiotracker_api.model.Audiobook;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AudiobookRepo extends JpaRepository<Audiobook, Long> {
    List<Audiobook> findBySessionsUserId(Long userId);
    List<Audiobook> findByGenreId(Long genreId);
}
