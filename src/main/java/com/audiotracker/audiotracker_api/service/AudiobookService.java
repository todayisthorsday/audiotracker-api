package com.audiotracker.audiotracker_api.service;

import com.audiotracker.audiotracker_api.model.Audiobook;
import com.audiotracker.audiotracker_api.repository.AudiobookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AudiobookService {

    @Autowired
    private AudiobookRepo audiobookRepo;

    public List<Audiobook> getAllAudiobooks() {
        return audiobookRepo.findAll();
    }
    public Optional<Audiobook> getAudiobookById(long id) {
        return audiobookRepo.findById(id);
    }

    public Audiobook createAudiobook(Audiobook audiobook) {
        return audiobookRepo.save(audiobook);
    }

    public Audiobook updateAudiobook(Long id, Audiobook updatedAudiobook) {
        return audiobookRepo.findById(id).map(audiobook -> {
            audiobook.setTitle(updatedAudiobook.getTitle());
            audiobook.setAuthor(updatedAudiobook.getAuthor());
            audiobook.setDuration(updatedAudiobook.getDuration());
            audiobook.setNarrator(updatedAudiobook.getNarrator());
            audiobook.setGenre(updatedAudiobook.getGenre());
            return audiobookRepo.save(audiobook);
        }).orElse(null);
    }
    public void deleteAudiobook(long id) {
        audiobookRepo.deleteById(id);
    }
}
