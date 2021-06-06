package com.kkaj.advertising.service;

import com.kkaj.advertising.dto.AnnonceDto;

import java.util.List;
import java.util.Optional;

public interface AnnonceService {
    // rechercher une annonce en fonction de son id
    AnnonceDto findById(Long id);
    // enregistrer une annonce
    AnnonceDto save(AnnonceDto annonceDto);
    // Afficher toute les annonces
    List<AnnonceDto> findAll();
    // supprimer une annonce
    void delete(Long id);
    // publier une annonce
    void publier(Long id);
    // recuperer les annonces d'un concessionnaire
    AnnonceDto findByConcessionnaireAndEtat(Long id, String etat);
    //rechercher les annonces d'un concessionnaire
    AnnonceDto findByConcessionnaire(Long idConcessionnaire);
}
