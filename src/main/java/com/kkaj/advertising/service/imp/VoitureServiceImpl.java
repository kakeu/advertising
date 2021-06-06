package com.kkaj.advertising.service.imp;

import com.kkaj.advertising.dto.AnnonceDto;
import com.kkaj.advertising.dto.ConcessionnaireDto;
import com.kkaj.advertising.dto.VoitureDto;
import com.kkaj.advertising.exceptions.ErrorCodes;
import com.kkaj.advertising.exceptions.InvalidEntityException;
import com.kkaj.advertising.repository.VoitureRepository;
import com.kkaj.advertising.service.VoitureService;
import com.kkaj.advertising.validator.AnnonceValidator;
import com.kkaj.advertising.validator.VoitureValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class VoitureServiceImpl implements VoitureService {

    private VoitureRepository voitureRepository;

    @Autowired
    public VoitureServiceImpl(VoitureRepository voitureRepository) {
        this.voitureRepository = voitureRepository;
    }

    @Override
    public VoitureDto save(VoitureDto voitureDto) {

        // on valide l'entité
        List<String> errors = VoitureValidator.validate(voitureDto);
        // s'il y a une erreur
        if(!errors.isEmpty()){
            log.error("Voiture is not valid {}",voitureDto);
            throw  new InvalidEntityException("L'annonce n'est pas valide", ErrorCodes.VOITURE_NOT_VALID, errors);
        }
        return VoitureDto.fromEntity(voitureRepository.save(VoitureDto.toEntity(voitureDto)));
    }

    @Override
    public List<VoitureDto> findAll() {

        return voitureRepository.findAll().stream()
                .map(VoitureDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        if(id == null){
            log.error("Voiture ID is null");
            return;
        }
        voitureRepository.deleteById(id);
    }
}
