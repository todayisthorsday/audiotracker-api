package com.audiotracker.audiotracker_api.service;

import com.audiotracker.audiotracker_api.model.Audiobook;
import com.audiotracker.audiotracker_api.model.Session;
import com.audiotracker.audiotracker_api.repository.SessionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SessionService {

    @Autowired
    private SessionRepo sessionRepo;

    public List<Session> getAllSessions() {
        return sessionRepo.findAll();
    }
    public Optional<Session> getSessionById(long sessionId) {
        return sessionRepo.findById(sessionId);
    }
    public Session createSession(Session session) {
        return sessionRepo.save(session);
    }
    public Session updateSession(Long id, Session updatedSession) {
        return sessionRepo.findById(id).map(session -> {
            session.setDate(updatedSession.getDate());
            session.setLength(updatedSession.getLength());
            session.setUser(updatedSession.getUser());
            session.setAudiobook(updatedSession.getAudiobook());
            return sessionRepo.save(session);
        }).orElse(null);
    }
    public void deleteSession(long sessionId) {
        sessionRepo.deleteById(sessionId);
    }

    public List<Audiobook> getAudiobooksByUser(Long userId) {
        return sessionRepo.findAudiobooksByUserId(userId);
    }

    public Integer getTotalListeningByUser(Long userId) {
        return sessionRepo.totalListeningByUser(userId);
    }

    public List<Session> getRecentSessions(int count) {
        return sessionRepo.findRecentSessions(PageRequest.of(0, count));
    }
}
