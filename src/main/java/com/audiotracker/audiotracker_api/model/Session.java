package com.audiotracker.audiotracker_api.model;

import jakarta.persistence.*;
import com.audiotracker.audiotracker_api.model.User;

import java.time.LocalDate;

@Entity
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;
    private int length; // MINUTES

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "audiobook_id")
    private Audiobook audiobook;

    // GETTERS & SETTERS

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public Audiobook getAudiobook() {
        return audiobook;
    }

    public void setAudiobook(Audiobook audiobook) {
        this.audiobook = audiobook;
    }
}
