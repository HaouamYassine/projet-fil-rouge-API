package com.example.projetfilrougefrontend;

import com.example.projetfilrougefrontend.entity.Event;
import com.example.projetfilrougefrontend.entity.User;
import com.example.projetfilrougefrontend.repository.EventRepository;
import com.example.projetfilrougefrontend.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class ProjetFilRougeFrontendApplication {


    @Autowired
    UserRepository userRepository;
    @Autowired
    EventRepository eventRepository;
//    @Autowired
//    BCryptPasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(ProjetFilRougeFrontendApplication.class, args);
    }


    @Bean
    @Transactional
    CommandLineRunner commandLineRunner() {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                User user = new User(
                        1L,
                        true,
                        "admin",
                        "admin@mail.com",
                        "admin",
                        true,
                        "Paris",
                        "Admin",
                        "Admin",
                        LocalDate.of(1996, 6, 25),
                        "Other",
                        "0600000000",
                        null);
                userRepository.save(user);

                User user1 = new User(
                        2L,
                        true,
                        "yassine",
                        "yassine@mail.com",
                        "y123",
                        true,
                        "Bruxelles",
                        "Yassine",
                        "Haouam",
                        LocalDate.of(1996, 6, 25),
                        "M",
                        "0600000000",
                        null);
                userRepository.save(user1);

                User user2 = new User(
                        3L,
                        true,
                        "hamid",
                        "hamid@mail.com",
                        "h123",
                        true,
                        "London",
                        "Hamid",
                        "Zouba",
                        LocalDate.of(1997, 9, 18),
                        "M",
                        "0600000000",
                        null);
                userRepository.save(user2);

                User user3 = new User(
                        4L,
                        true,
                        "nathan",
                        "nathan@mail.com",
                        "n123",
                        true,
                        "Madrid",
                        "Nathan",
                        "Angular",
                        LocalDate.of(1980, 8, 12),
                        "M",
                        "0600000000",
                        null);
                userRepository.save(user3);

                User user4 = new User(
                        5L,
                        false,
                        "bot1",
                        "bot1@mail.com",
                        "bot1",
                        true,
                        "Rome",
                        "bot",
                        "bot1",
                        LocalDate.of(2000, 1, 1),
                        "Other",
                        "0600000000",
                        null);
                userRepository.save(user4);

                User user5 = new User(
                        6L,
                        false,
                        "bot2",
                        "bot2@mail.com",
                        "bot2",
                        true,
                        "Berlin",
                        "bot",
                        "bot2",
                        LocalDate.of(2000, 1, 1),
                        "Other",
                        "0600000000",
                        null);
                userRepository.save(user5);

                User user6 = new User(
                        7L,
                        false,
                        "bot3",
                        "bot3@mail.com",
                        "bot3",
                        true,
                        "Alger",
                        "bot",
                        "bot3",
                        LocalDate.of(2000, 1, 1),
                        "Other",
                        "0600000000",
                        null);
                userRepository.save(user6);

                Event event = new Event(
                        "RDV n°1",
                        "Rendez vous numéro un",
                        LocalDate.of(2023, 03, 1),
                        LocalTime.of(8, 30, 0),
                        LocalTime.of(10, 30, 0)
                );
                eventRepository.save(event);

                Event event2 = new Event(
                        "RDV n°2",
                        "Rendez vous numéro deux",
                        LocalDate.of(2023, 03, 2),
                        LocalTime.of(15, 30, 0),
                        LocalTime.of(18, 30, 0)
                );
                eventRepository.save(event2);

                Event event3 = new Event(
                        "Soutenance CGI",
                        "Rendez vous numéro un",
                        LocalDate.of(2023, 02, 27),
                        LocalTime.of(15, 30, 0),
                        LocalTime.of(16, 30, 0)
                );
                eventRepository.save(event3);


                // Test d'ajout d'User avec Evenement:

                Event event4 = new Event(
                        "Anniv Hamid",
                        "personne n'est venu",
                        LocalDate.of(2023, 2, 27),
                        LocalTime.of(15, 30, 0),
                        LocalTime.of(16, 30, 0));
                eventRepository.save(event4);

                // Ajout des événements à la liste d'événements de l'utilisateur
                List<Event> events = new ArrayList<>();
                events.add(event3);
                events.add(event4);
                user6.setEventList(events);

                // Ajout de l'utilisateur à la liste d'utilisateurs de chaque événement
                event3.setUsers(Arrays.asList(user6));
                event4.setUsers(Arrays.asList(user6));

                userRepository.save(user6);
                eventRepository.save(event3);
                eventRepository.save(event4);
            }
        };
    }

}
