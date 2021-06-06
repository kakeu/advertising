package com.kkaj.advertising.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kkaj.advertising.entities.Annonce;
import com.kkaj.advertising.entities.Concessionnaire;
import com.kkaj.advertising.entities.Voiture;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class ConcessionnaireDto {
    private long id;
    private String nom;
    private String adresse;
    @JsonIgnore
    private List<AnnonceDto> annonces;
    @JsonIgnore
    private List<VoitureDto> voitures;


    public static ConcessionnaireDto fromEntity(Concessionnaire concessionnaire){
        if(concessionnaire == null){
            return null;
        }
        return ConcessionnaireDto.builder()
                .id(concessionnaire.getId())
                .nom(concessionnaire.getNom())
                .adresse(concessionnaire.getAdresse())
                .build();
    }

    public static Concessionnaire toEntity(ConcessionnaireDto concessionnaireDto){
        if(concessionnaireDto == null){
            return null;
        }
        Concessionnaire concessionnaire = new Concessionnaire();
        concessionnaire.setId(concessionnaireDto.getId());
        concessionnaire.setNom(concessionnaireDto.getNom());
        concessionnaire.setAdresse(concessionnaireDto.getAdresse());
        return concessionnaire;
    }
}



