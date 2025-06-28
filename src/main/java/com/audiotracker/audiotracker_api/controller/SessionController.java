package com.audiotracker.audiotracker_api.controller;

import com.audiotracker.audiotracker_api.model.Audiobook;
import com.audiotracker.audiotracker_api.model.Session;
import com.audiotracker.audiotracker_api.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sessions")
public class SessionController {

    @Autowired
    private SessionService sessionService;

    @GetMapping
    public List<Session> getAllSessions() {
        return sessionService.getAllSessions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Session> getSessionById(@PathVariable long id) {
        return sessionService.getSessionById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/user/{userId}/total-time")
    public ResponseEntity<Integer> getTotalListeningTime(@PathVariable Long userId) {
        Integer total = sessionService.getTotalListeningByUser(userId);
        return (total != null) ? ResponseEntity.ok(total) : ResponseEntity.notFound().build();
    }

    @GetMapping("/audiobook/{audiobookId}")
    public ResponseEntity<List<Session>> getSessionsByAudiobook(@PathVariable Long audiobookId) {
        List<Session> sessions = sessionService.getSessionsByAudiobook(audiobookId);
        return ResponseEntity.ok(sessions);
    }


    @PostMapping
    public ResponseEntity<Session> createSession(@RequestBody Session session) {
        return ResponseEntity.ok(sessionService.createSession(session));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Session> updateSession(@PathVariable Long id, @RequestBody Session session) {
        Session updated = sessionService.updateSession(id, session);
        return (updated != null) ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Session> deleteSession(@PathVariable Long id) {
        sessionService.deleteSession(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/user/{userId}/audiobooks")
    public ResponseEntity<List<Audiobook>> getAudiobooksByUser(@PathVariable Long userId) {
        List<Audiobook> audiobooks = sessionService.getAudiobooksByUser(userId);
        return audiobooks.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(audiobooks);
    }

}
