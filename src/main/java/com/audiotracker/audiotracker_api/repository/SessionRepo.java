package com.audiotracker.audiotracker_api.repository;

import com.audiotracker.audiotracker_api.model.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepo extends JpaRepository<Session, Long> {
}
