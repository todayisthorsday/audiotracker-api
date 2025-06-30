package com.audiotracker.audiotracker_api.repository;

import com.audiotracker.audiotracker_api.model.Audiobook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AudiobookRepo extends JpaRepository<Audiobook, Long> {
    List<Audiobook> findBySessionsUserId(Long userId);
    List<Audiobook> findByGenreId(Long genreId);
    List<Audiobook> findByUserId(Long userId, Long genreId);
}
