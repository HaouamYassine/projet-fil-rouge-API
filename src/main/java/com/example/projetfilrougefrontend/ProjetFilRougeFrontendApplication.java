package com.example.projetfilrougefrontend;

import com.example.projetfilrougefrontend.entity.*;
import com.example.projetfilrougefrontend.repository.*;
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

import static com.example.projetfilrougefrontend.entity.ERole.*;

@SpringBootApplication
public class ProjetFilRougeFrontendApplication {


    @Autowired
    UserRepository userRepository;
    @Autowired
    EventRepository eventRepository;
    @Autowired
    PlanningRepository planningRepository;
    @Autowired
    AffiliateRepository affiliateRepository;

    @Autowired
    RoleRepository roleRepository;
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

                //AJOUT DES ROLES EN BDD
                Role roleuser = new Role(
                        1,
                        ROLE_USER
                );
                roleRepository.save(roleuser);
                Role roleuser2 = new Role(
                        2,
                        ROLE_SUPER_ADMIN
                );
                roleRepository.save(roleuser2);
                Role roleuser3 = new Role(
                        3,
                        ROLE_ADMIN
                );
                roleRepository.save(roleuser3);

            //GENERATIONS DE USERS

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
                        "0600000000");
                Role roleuserX1 = roleRepository.findByName(ERole.ROLE_USER)
                        .orElseThrow(() -> new RuntimeException("Role not found"));
                user.getRoles().add(roleuserX1);
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
                        "0600000000");
                Role roleuserX2 = roleRepository.findByName(ERole.ROLE_USER)
                        .orElseThrow(() -> new RuntimeException("Role not found"));
                user.getRoles().add(roleuserX2);
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
                        "0600000000");
                Role roleuserX3 = roleRepository.findByName(ERole.ROLE_USER)
                        .orElseThrow(() -> new RuntimeException("Role not found"));
                user.getRoles().add(roleuserX3);
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
                        "0600000000");
                Role roleuserX4 = roleRepository.findByName(ERole.ROLE_USER)
                        .orElseThrow(() -> new RuntimeException("Role not found"));
                user.getRoles().add(roleuserX4);
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
                        "0600000000");
                Role roleuserX5 = roleRepository.findByName(ERole.ROLE_USER)
                        .orElseThrow(() -> new RuntimeException("Role not found"));
                user.getRoles().add(roleuserX5);
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
                        "0600000000");
                Role roleuserX6 = roleRepository.findByName(ERole.ROLE_USER)
                        .orElseThrow(() -> new RuntimeException("Role not found"));
                user.getRoles().add(roleuserX6);
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
                        "0600000000");
                Role roleuserX7 = roleRepository.findByName(ERole.ROLE_USER)
                        .orElseThrow(() -> new RuntimeException("Role not found"));
                user.getRoles().add(roleuserX7);
                userRepository.save(user6);


                //GENERATIONS DE PLANNING

                Planning planning = new Planning();
                planning.setId(1L);
                planningRepository.save(planning);

                Planning planning2 = new Planning();
                planning2.setId(2L);
                planningRepository.save(planning2);

                Planning planning3 = new Planning();
                planning3.setId(3L);
                planningRepository.save(planning3);




                //GENERATIONS D'EVENT

                Event event = new Event(
                        1L,
                        "RDV n°1",
                        "Rendez vous numéro un",
                        LocalDate.of(2023, 03, 1),
                        LocalTime.of(8, 30, 0),
                        LocalTime.of(10, 30, 0),
                        planning
                );
                eventRepository.save(event);

                Event event2 = new Event(
                        2L,
                        "RDV n°2",
                        "Rendez vous numéro deux",
                        LocalDate.of(2023, 03, 2),
                        LocalTime.of(15, 30, 0),
                        LocalTime.of(18, 30, 0),
                        planning
                );
                eventRepository.save(event2);

                Event event3 = new Event(
                        3L,
                        "Soutenance CGI",
                        "Rendez vous numéro un",
                        LocalDate.of(2023, 02, 27),
                        LocalTime.of(15, 30, 0),
                        LocalTime.of(16, 30, 0),
                        planning
                );
                eventRepository.save(event3);


                // Test d'ajout d'User avec Evenement:

                Event event4 = new Event(
                        4L,
                        "Anniv Hamid",
                        "personne n'est venu",
                        LocalDate.of(2023, 2, 27),
                        LocalTime.of(15, 30, 0),
                        LocalTime.of(16, 30, 0),
                        planning
                                );
                eventRepository.save(event4);



                //GENERATIONS DES AFFILIATES

                Affiliate affiliate = new Affiliate();
                affiliate.setPlanning(planning);
                affiliate.setUser(user);
                affiliate.setId(1L);
                affiliateRepository.save(affiliate);


                Affiliate affiliate2 = new Affiliate();
                affiliate2.setPlanning(planning2);
                affiliate2.setUser(user2);
                affiliate2.setId(2L);
                affiliateRepository.save(affiliate2);


                Affiliate affiliate3 = new Affiliate();
                affiliate3.setPlanning(planning3);
                affiliate3.setUser(user3);
                affiliate3.setId(3L);
                affiliateRepository.save(affiliate3);




                // Ajout des événements à la liste d'événements de l'utilisateur
//                List<Event> events = new ArrayList<>();
//                events.add(event3);
//                events.add(event4);
//                user6.setEventList(events);
//
//                // Ajout de l'utilisateur à la liste d'utilisateurs de chaque événement
//                event3.setUser(user6);
//                event4.setUser(user6);

//                userRepository.save(user6);
            }
        };
    }

}
