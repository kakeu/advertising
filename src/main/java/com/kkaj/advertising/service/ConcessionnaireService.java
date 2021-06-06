package com.kkaj.advertising.service;

import com.kkaj.advertising.dto.AnnonceDto;
import com.kkaj.advertising.dto.ConcessionnaireDto;

import java.util.List;

public interface ConcessionnaireService {

    // enregistrer une concessionnaire
    ConcessionnaireDto save(ConcessionnaireDto concessionnaireDto);
    // Afficher toute les concessionnaires
    List<ConcessionnaireDto> findAll();
    // supprimer une concessionnaire
    void delete(Long id);

}
