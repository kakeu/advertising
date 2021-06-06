package com.kkaj.advertising.service;

import com.kkaj.advertising.dto.ConcessionnaireDto;
import com.kkaj.advertising.dto.VoitureDto;

import java.util.List;

public interface VoitureService {

    // enregistrer une concessionnaire
    VoitureDto save(VoitureDto voitureDto);
    // Afficher toute les concessionnaires
    List<VoitureDto> findAll();
    // supprimer une concessionnaire
    void delete(Long id);
}
