package com.kkaj.advertising.service.imp;

import com.kkaj.advertising.dto.AnnonceDto;
import com.kkaj.advertising.dto.ConcessionnaireDto;
import com.kkaj.advertising.exceptions.ErrorCodes;
import com.kkaj.advertising.exceptions.InvalidEntityException;
import com.kkaj.advertising.repository.ConcessionnaireRepository;
import com.kkaj.advertising.service.ConcessionnaireService;
import com.kkaj.advertising.validator.AnnonceValidator;
import com.kkaj.advertising.validator.ConcessionnaireValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ConcessionnaireServiceImpl implements ConcessionnaireService {

    private ConcessionnaireRepository concessionnaireRepository;

    @Autowired
    public ConcessionnaireServiceImpl(ConcessionnaireRepository concessionnaireRepository) {
        this.concessionnaireRepository = concessionnaireRepository;
    }

    @Override
    public ConcessionnaireDto save(ConcessionnaireDto concessionnaireDto) {

        // on valide l'entité
        List<String> errors = ConcessionnaireValidator.validate(concessionnaireDto);
        // s'il y a une erreur
        if(!errors.isEmpty()){
            log.error("Concessionnaire is not valid {}",concessionnaireDto);
            throw  new InvalidEntityException("le concessionnaire  n'est pas valide", ErrorCodes.CONCESSIONAIRE_NOT_VALID, errors);
        }
        return ConcessionnaireDto.fromEntity(concessionnaireRepository.save(ConcessionnaireDto.toEntity(concessionnaireDto)));
    }

    @Override
    public List<ConcessionnaireDto> findAll() {

        return concessionnaireRepository.findAll().stream()
                .map(ConcessionnaireDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        if(id == null){
            log.error("Concessionnaire ID is null");
            return;
        }
        concessionnaireRepository.deleteById(id);
    }
}
