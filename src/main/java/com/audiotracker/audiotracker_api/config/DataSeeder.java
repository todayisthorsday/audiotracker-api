package com.audiotracker.audiotracker_api.config;

import com.audiotracker.audiotracker_api.model.*;
import com.audiotracker.audiotracker_api.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.Optional;
import java.util.List;

@Configuration
public class DataSeeder {

    @Bean
    public CommandLineRunner seedData (
        UserRepo userRepo,
        GenreRepo genreRepo,
        AudiobookRepo audiobookRepo,
        SessionRepo sessionRepo

        ){
        return args -> {
            // GENRE
            Genre sciFi = new Genre();
            sciFi.setName("Sci-Fi");
            sciFi.setDescription("Futuristic tech, space travel, time travel");
            genreRepo.save(sciFi);

            Genre fantasy = new Genre();
            fantasy.setName("Fantasy");
            fantasy.setDescription("Magic, mythical creatures, epic quests");
            genreRepo.save(fantasy);

            Genre romance = new Genre();
            romance.setName("Romance");
            romance.setDescription("Love, relationships, and emotional storytelling");
            genreRepo.save(romance);

            Genre memoir = new Genre();
            memoir.setName("Memoir");
            memoir.setDescription("First-person life experiences and reflections");
            genreRepo.save(memoir);

            // USERS
            User denika = new User();
            denika.setUsername("nikatracker");
            denika.setPreferredGenre("Memoir");
            denika.setLocation("Newfoundland");
            userRepo.save(denika);

            Optional<User> existingUser = userRepo.findByUsername("meltracker");
            User mel = existingUser.orElseGet(() -> {
                User newUser = new User();
                newUser.setUsername("meltracker");
                newUser.setPreferredGenre("Horror");
                newUser.setLocation("Newfoundland");
                return userRepo.save(newUser);  // save new one if not found
            });


            // AUDIO BOOKS
            Audiobook a = new Audiobook();
            a.setTitle("Project Hail Mary");
            a.setAuthor("Andy Weir");
            a.setGenre(sciFi);
            a.setDuration(720);
            audiobookRepo.save(a);

            Audiobook b = new Audiobook();
            b.setTitle("The Priory of the Orange Tree");
            b.setAuthor("Samantha Shannon");
            b.setGenre(fantasy);
            b.setDuration(1350);
            audiobookRepo.save(b);

            Audiobook c = new Audiobook();
            c.setTitle("Beach Read");
            c.setAuthor("Emily Henry");
            c.setGenre(romance);
            c.setDuration(650);
            audiobookRepo.save(c);

            Audiobook d = new Audiobook();
            d.setTitle("I'm Glad My Mom Died");
            d.setAuthor("Jennette McCurdy");
            d.setGenre(memoir);
            d.setDuration(650);
            audiobookRepo.save(d);

            // SESSIONS
            Session s1 = new Session();
            s1.setUser(denika);
            s1.setAudiobook(d);
            s1.setDate(LocalDate.now().minusDays(1));
            s1.setLength(60);
            sessionRepo.save(s1);

            Session s2 = new Session();
            s2.setUser(mel);
            s2.setAudiobook(b);
            s2.setDate(LocalDate.now().minusDays(2));
            s2.setLength(90);
            sessionRepo.save(s2);
        };
    }
}
