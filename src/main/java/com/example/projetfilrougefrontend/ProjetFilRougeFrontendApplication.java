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
    CommandLineRunner commandLineRunner(){
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
                        null);
                userRepository.save(user);

                User user1 = new User(
                        2L,
                        true,
                        "yassine",
                        "yassine@mail.com",
                        "y123",
                        true,
                        null);
                userRepository.save(user1);

                User user2 = new User(
                        3L,
                        true,
                        "hamid",
                        "hamid@mail.com",
                        "h123",
                        true,
                        null);
                userRepository.save(user2);

                User user3 = new User(
                        4L,
                        true,
                        "nathan",
                        "nathan@mail.com",
                        "n123",
                        true,
                        null);
                userRepository.save(user3);

                User user4 = new User(
                        5L,
                        false,
                        "bot1",
                        "bot1@mail.com",
                        "bot1",
                        true,
                        null);
                userRepository.save(user4);

                User user5 = new User(
                        6L,
                        false,
                        "bot2",
                        "bot2@mail.com",
                        "bot2",
                        true,
                        null);
                userRepository.save(user5);

                User user6 = new User(
                        7L,
                        false,
                        "bot3",
                        "bot3@mail.com",
                        "bot3",
                        true,
                        null);
                userRepository.save(user6);

                Event event = new Event(
                        1L,
                        "RDV n°1",
                        "Rendez vous numéro un",
                        LocalDate.of(2023,03,1),
                        null);
                eventRepository.save(event);


            }
        };
    }

}
