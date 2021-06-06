package com.kkaj.advertising.validator;

import com.kkaj.advertising.dto.AnnonceDto;
import com.kkaj.advertising.dto.ConcessionnaireDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class AnnonceValidator {

    public static List<String> validate(AnnonceDto annonceDto){

        List<String> errors = new ArrayList<>();

        if(annonceDto == null || !StringUtils.hasLength(annonceDto.getVendeur())){
            errors.add("veuillez entrer le nom du vendeur");
        }
        if(annonceDto == null || !StringUtils.hasLength(annonceDto.getPublishDate().toString())){
            errors.add("veuillez entrer la date de publication de l'annonce");
        }
        if(annonceDto.getVoiture()== null){
            errors.add("veuillez entre la voiture de l'annonce");
        }
        if(annonceDto.getConcessionnaire()== null){
            errors.add("veuillez entre le concessionnaire de l'annonce");
        }

        return errors;
    }
}
