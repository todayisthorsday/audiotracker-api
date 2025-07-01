package com.audiotracker.audiotracker_api.repository;

import com.audiotracker.audiotracker_api.model.Audiobook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AudiobookRepo extends JpaRepository<Audiobook, Long> {
    @Query("SELECT DISTINCT s.audiobook FROM Session s WHERE s.user.id = :userId")
    List<Audiobook> findAudiobooksListenedByUser(@Param("userId") Long userId);
    List<Audiobook> findByGenreId(Long genreId);
}
