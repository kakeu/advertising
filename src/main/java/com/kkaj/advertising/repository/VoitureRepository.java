package com.kkaj.advertising.repository;

import com.kkaj.advertising.entities.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface VoitureRepository extends JpaRepository<Voiture,Long> {

    Optional<Voiture> findVoitureByPrixAndCouleur(BigDecimal prix, String couleur);
    List<Voiture> findAll();
}
