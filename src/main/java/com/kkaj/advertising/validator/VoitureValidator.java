package com.kkaj.advertising.validator;

import com.kkaj.advertising.dto.AnnonceDto;
import com.kkaj.advertising.dto.VoitureDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class VoitureValidator {

    public static List<String> validate(VoitureDto voitureDto){

        List<String> errors = new ArrayList<>();

        if(voitureDto == null || !StringUtils.hasLength(voitureDto.getCouleur())){
            errors.add("veuillez entrer la couleur de la voiture");
        }
        if(voitureDto == null || !StringUtils.hasLength(voitureDto.getPrix().toString())){
            errors.add("veuillez entrer la prix de la voiture");
        }
        if(voitureDto == null || !StringUtils.hasLength(voitureDto.getMarque())){
            errors.add("veuillez entrer la marque de la voiture");
        }
        if(voitureDto == null || !StringUtils.hasLength(voitureDto.getCategoryVoiture().toString())){
            errors.add("veuillez entrer la categorie de la voiture");
        }
        if(voitureDto == null || !StringUtils.hasLength(voitureDto.getTypeVoiture().toString())){
            errors.add("veuillez entrer le type de voiture");
        }
        if(voitureDto.getConcessionnaire()== null){
            errors.add("veuillez entre le concessionnaire de la voiture");
        }
        return errors;
    }
}
