package com.kkaj.advertising.repository;

import com.kkaj.advertising.entities.Annonce;
import com.kkaj.advertising.entities.EtatAnnonce;
import com.kkaj.advertising.entities.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AnnonceRepository extends JpaRepository<Annonce,Long> {
    List<Annonce> findAll();
    // rechercher en fonction de l'ID du concessionnaire et de l'etat
    Optional<Annonce> findAnnonceByConcessionnaireAndEtatAnnonce(Long id, String etat);
    // recherche en fonction de l'ID du concessionaire
    Optional<Annonce> findAnnonceByConcessionnaire(Long id);
}
