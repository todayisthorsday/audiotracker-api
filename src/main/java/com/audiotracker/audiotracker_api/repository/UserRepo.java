package com.audiotracker.audiotracker_api.repository;

import com.audiotracker.audiotracker_api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
