package com.audiotracker.audiotracker_api.service;

import com.audiotracker.audiotracker_api.model.User;
import com.audiotracker.audiotracker_api.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public Optional<User> getUserById(long id) {
        return userRepo.findById(id);
    }

    public User createUser(User user) {
        return userRepo.save(user);
    }

    public User updateUser(Long id, User updatedUser) {
        return userRepo.findById(id).map(user -> {
            user.setUsername(updatedUser.getUsername());
            user.setPreferredGenre(updatedUser.getPreferredGenre());
            return userRepo.save(user);
        }).orElse(null);
    }

    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }

}
