package com.kkaj.advertising.validator;

import com.kkaj.advertising.dto.ConcessionnaireDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ConcessionnaireValidator {

    public static List<String> validate(ConcessionnaireDto concessionnaireDto){

        List<String> errors = new ArrayList<>();

        if(concessionnaireDto == null || !StringUtils.hasLength(concessionnaireDto.getNom())){
            errors.add("veuillez entrer le nom du concessionnaire");
        }
        if(concessionnaireDto == null || !StringUtils.hasLength(concessionnaireDto.getAdresse())){
            errors.add("veuillez entrer l'addresse du concessionnaire");
        }
        return errors;
    }
}
