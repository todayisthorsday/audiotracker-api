package com.audiotracker.audiotracker_api.controller;

import com.audiotracker.audiotracker_api.model.Audiobook;
import com.audiotracker.audiotracker_api.model.Session;
import com.audiotracker.audiotracker_api.service.AudiobookService;
import com.audiotracker.audiotracker_api.service.SessionService;
import com.audiotracker.audiotracker_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/audiobooks")
public class AudiobookController {

    @Autowired
    private AudiobookService audiobookService;

    @Autowired
    private SessionService sessionService;

    @GetMapping
    public List<Audiobook> getAllAudiobooks() {
        return audiobookService.getAllAudiobooks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Audiobook> getAudiobookById(@PathVariable Long id) {
        return audiobookService.getAudiobookById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Audiobook>> getAudiobooksByUser(@PathVariable Long userId) {
        List<Audiobook> books = audiobookService.getAudiobooksByUser(userId);
        return ResponseEntity.ok(books);
    }

  @GetMapping("/genre/{genreId}")
    public ResponseEntity<List<Audiobook>> getAudiobooksByGenre(@PathVariable Long genreId) {
        List<Audiobook> books = audiobookService.getAudiobooksByGenre(genreId);
        return ResponseEntity.ok(books);
    }

    @GetMapping("/audiobook/{audiobookId}")
    public ResponseEntity<List<Session>> getSessionsByAudiobook(@PathVariable Long audiobookId) {
        List<Session> sessions = sessionService.getSessionsByAudiobook(audiobookId);
        return ResponseEntity.ok(sessions);
    }

    @PostMapping
    public Audiobook createAudiobook(@RequestBody Audiobook audiobook) {
        return audiobookService.createAudiobook(audiobook);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Audiobook> updateAudiobook(@PathVariable Long id, @RequestBody Audiobook audiobook) {
        Audiobook updatedAudiobook = audiobookService.updateAudiobook(id, audiobook);
        return (updatedAudiobook != null) ? ResponseEntity.ok(updatedAudiobook) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAudiobook(@PathVariable Long id) {
        audiobookService.deleteAudiobook(id);
        return ResponseEntity.noContent().build();
    }
}
