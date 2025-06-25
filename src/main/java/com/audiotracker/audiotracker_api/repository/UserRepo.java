package com.audiotracker.audiotracker_api.repository;

import com.audiotracker.audiotracker_api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
