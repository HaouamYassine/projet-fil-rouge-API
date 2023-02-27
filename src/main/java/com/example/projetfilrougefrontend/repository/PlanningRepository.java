package com.example.projetfilrougefrontend.repository;

import com.example.projetfilrougefrontend.entity.Planning;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanningRepository extends JpaRepository<Planning, Long> {
}
