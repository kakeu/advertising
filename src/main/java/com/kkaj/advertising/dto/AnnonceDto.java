package com.kkaj.advertising.dto;

import com.kkaj.advertising.entities.Annonce;
import com.kkaj.advertising.entities.Concessionnaire;
import com.kkaj.advertising.entities.EtatAnnonce;
import com.kkaj.advertising.entities.Voiture;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.Date;

@Builder
@Data
public class AnnonceDto {
    private long id;
    private String vendeur;
    private EtatAnnonce etatAnnonce = EtatAnnonce.draft;
    private Date publishDate;
    private ConcessionnaireDto concessionnaire;
    private VoitureDto voiture;

    public static AnnonceDto fromEntity(Annonce annonce){
        if(annonce == null){
            return null;
        }
        return AnnonceDto.builder()
                .id(annonce.getId())
                .vendeur(annonce.getVendeur())
                .etatAnnonce(annonce.getEtatAnnonce())
                .publishDate(annonce.getPublishDate())
                .concessionnaire(ConcessionnaireDto.fromEntity(annonce.getConcessionnaire()))
                .voiture(VoitureDto.fromEntity(annonce.getVoiture()))
                .build();
    }

    public static Annonce toEntity(AnnonceDto annonceDto){
        if(annonceDto == null){
            return null;
        }
        Annonce annonce = new Annonce();
        annonce.setId(annonceDto.getId());
        annonce.setEtatAnnonce(annonceDto.getEtatAnnonce());
        annonce.setVendeur(annonceDto.getVendeur());
        annonce.setPublishDate(annonceDto.getPublishDate());
        annonce.setVoiture(VoitureDto.toEntity(annonceDto.getVoiture()));
        annonce.setConcessionnaire(ConcessionnaireDto.toEntity(annonceDto.getConcessionnaire()));
        return annonce;
    }

}
