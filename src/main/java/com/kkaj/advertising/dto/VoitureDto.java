package com.kkaj.advertising.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kkaj.advertising.entities.*;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.List;

@Builder
@Data
public class VoitureDto {
    private long id;
    private String marque;
    private BigDecimal prix;
    private String couleur;
    private TypeVoiture typeVoiture;
    private CategoryVoiture categoryVoiture;
    private ConcessionnaireDto concessionnaire;
    @JsonIgnore
    private List<AnnonceDto> annonce;


    public static VoitureDto fromEntity(Voiture voiture){
        if(voiture == null){
            return null;
        }
        return VoitureDto.builder()
                .id(voiture.getId())
                .marque(voiture.getMarque())
                .prix(voiture.getPrix())
                .couleur(voiture.getCouleur())
                .typeVoiture(voiture.getTypeVoiture())
                .categoryVoiture(voiture.getCategoryVoiture())
                .concessionnaire(ConcessionnaireDto.fromEntity(voiture.getConcessionnaire()))
                .build();
    }

    public static Voiture toEntity(VoitureDto voitureDto){
        if(voitureDto == null){
            return null;
        }
        Voiture voiture = new Voiture();
        voiture.setId(voitureDto.getId());
        voiture.setMarque(voitureDto.getMarque());
        voiture.setPrix(voitureDto.getPrix());
        voiture.setCouleur(voitureDto.getCouleur());
        voiture.setTypeVoiture(voitureDto.getTypeVoiture());
        voiture.setCategoryVoiture(voitureDto.getCategoryVoiture());
        voiture.setConcessionnaire(ConcessionnaireDto.toEntity(voitureDto.getConcessionnaire()));
        return voiture;
    }
}
