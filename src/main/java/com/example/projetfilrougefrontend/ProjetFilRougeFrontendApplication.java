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
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class ProjetFilRougeFrontendApplication {

    @Autowired
    RoleRepository roleRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    EventRepository eventRepository;
    @Autowired
    PlanningRepository planningRepository;
    @Autowired
    AffiliateRepository affiliateRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(ProjetFilRougeFrontendApplication.class, args);
    }


    @Bean
    @Transactional
    CommandLineRunner commandLineRunner() {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {

            //GENERATIONS DE USERS
                String mdp1 = "admin";
                String mdpEncode1 = passwordEncoder.encode(mdp1);
                User user = new User(
                        1L,
                        true,
                        "admin",
                        "admin@mail.com",
                        mdpEncode1,
                        true,
                        "Paris",
                        "Admin",
                        "Admin",
                        LocalDate.of(1996, 6, 25),
                        "Other",
                        "0600000000");
                userRepository.save(user);

                String mdp2 = "y123";
                String mdpEncode2 = passwordEncoder.encode(mdp2);
                User user1 = new User(
                        2L,
                        true,
                        "yassine",
                        "yassine@mail.com",
                        mdpEncode2,
                        true,
                        "Bruxelles",
                        "Yassine",
                        "Haouam",
                        LocalDate.of(1996, 6, 25),
                        "M",
                        "0600000000");
                userRepository.save(user1);

                String mdp3 = "h123";
                String mdpEncode3 = passwordEncoder.encode(mdp3);
                User user2 = new User(
                        3L,
                        true,
                        "hamid",
                        "hamid@mail.com",
                        mdpEncode3,
                        true,
                        "London",
                        "Hamid",
                        "Zouba",
                        LocalDate.of(1997, 9, 18),
                        "M",
                        "0600000000");
                userRepository.save(user2);

                String mdp4 = "n123";
                String mdpEncode4 = passwordEncoder.encode(mdp4);
                User user3 = new User(
                        4L,
                        true,
                        "nathan",
                        "nathan@mail.com",
                        mdpEncode4,
                        true,
                        "Madrid",
                        "Nathan",
                        "Angular",
                        LocalDate.of(1980, 8, 12),
                        "M",
                        "0600000000");
                userRepository.save(user3);

                String mdp5 = "bot1";
                String mdpEncode5 = passwordEncoder.encode(mdp5);
                User user4 = new User(
                        5L,
                        false,
                        "bot1",
                        "bot1@mail.com",
                        mdpEncode5,
                        true,
                        "Rome",
                        "bot",
                        "bot1",
                        LocalDate.of(2000, 1, 1),
                        "Other",
                        "0600000000");
                userRepository.save(user4);

                String mdp6 = "bot2";
                String mdpEncode6 = passwordEncoder.encode(mdp6);
                User user5 = new User(
                        6L,
                        false,
                        "bot2",
                        "bot2@mail.com",
                        mdpEncode6,
                        true,
                        "Berlin",
                        "bot",
                        "bot2",
                        LocalDate.of(2000, 1, 1),
                        "Other",
                        "0600000000");
                userRepository.save(user5);

                String mdp7 = "bot3";
                String mdpEncode7 = passwordEncoder.encode(mdp7);
                User user6 = new User(
                        7L,
                        false,
                        "bot3",
                        "bot3@mail.com",
                        mdpEncode7,
                        true,
                        "Alger",
                        "bot",
                        "bot3",
                        LocalDate.of(2000, 1, 1),
                        "Other",
                        "0600000000");
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
                        "Réunion",
                        "Réunion budgetaire",
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


                List<Role> roles = Arrays.asList(
                        new Role(ERole.ROLE_USER),
                        new Role(ERole.ROLE_ADMIN),
                        new Role(ERole.ROLE_SUPER_ADMIN));

                roleRepository.saveAll(roles);

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
