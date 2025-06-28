package com.audiotracker.audiotracker_api.repository;

import com.audiotracker.audiotracker_api.model.Audiobook;
import com.audiotracker.audiotracker_api.model.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SessionRepo extends JpaRepository<Session, Long> {
    @Query("SELECT SUM(s.length) FROM Session s WHERE s.user.id = :userId")
    Integer totalListeningByUser(@Param("userId") Long userId);
    @Query("SELECT DISTINCT s.audiobook FROM Session s where s.user.id = :userId")
    List<Audiobook> findAudiobooksByUserId(@Param("userId") Long userId);
}


