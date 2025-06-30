package com.audiotracker.audiotracker_api.repository;

import com.audiotracker.audiotracker_api.model.Audiobook;
import com.audiotracker.audiotracker_api.model.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SessionRepo extends JpaRepository<Session, Long> {
    @Query("SELECT SUM(s.length) FROM Session s WHERE s.user.id = :userId")
    Integer totalListeningByUser(@Param("userId") Long userId);
    @Query("SELECT DISTINCT s.audiobook FROM Session s where s.user.id = :userId")
    List<Audiobook> findAudiobooksByUserId(@Param("userId") Long userId);
    @Query("SELECT s FROM Session s ORDER BY s.date DESC")
    List<Session> findRecentSessions(org.springframework.data.domain.Pageable pageable);
    List<Session> findByAudiobookId(Long audiobookId);
}


