package com.audiotracker.audiotracker_api.repository;

import com.audiotracker.audiotracker_api.model.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SessionRepo extends JpaRepository<Session, Long> {
    @Query("SELECT SUM(s.length) FROM Session s WHERE s.user.id = :userId")
    Integer totalListeningByUser(@Param("userId") Long userId);

}
