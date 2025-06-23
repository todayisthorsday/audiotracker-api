package com.audiotracker.audiotracker_api.repository;

import com.audiotracker.audiotracker_api.model.Audiobook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AudiobookRepo extends JpaRepository<Audiobook, Long> {
}
