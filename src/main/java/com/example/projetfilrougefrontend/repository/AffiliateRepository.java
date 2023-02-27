package com.example.projetfilrougefrontend.repository;

import com.example.projetfilrougefrontend.entity.Affiliate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AffiliateRepository extends JpaRepository<Affiliate, Long> {
}
