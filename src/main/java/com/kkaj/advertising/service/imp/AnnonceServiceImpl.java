package com.kkaj.advertising.service.imp;

import com.kkaj.advertising.dto.AnnonceDto;
import com.kkaj.advertising.entities.Annonce;
import com.kkaj.advertising.exceptions.EntityNotFoundException;
import com.kkaj.advertising.exceptions.ErrorCodes;
import com.kkaj.advertising.exceptions.InvalidEntityException;
import com.kkaj.advertising.repository.AnnonceRepository;
import com.kkaj.advertising.service.AnnonceService;
import com.kkaj.advertising.validator.AnnonceValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class AnnonceServiceImpl implements AnnonceService {

    private AnnonceRepository annonceRepository;

    @Autowired
    public AnnonceServiceImpl(AnnonceRepository annonceRepository) {
        this.annonceRepository = annonceRepository;
    }


    @Override
    public AnnonceDto findById(Long id) {
        if(id == null){
            log.error("Annonce ID is null");
            return null;
        }
        Optional<Annonce> annonce = annonceRepository.findById(id);

        return Optional.of(AnnonceDto.fromEntity(annonce.get())).orElseThrow(() ->
                new EntityNotFoundException("Aucune Annonce avec l'ID = "+ id +" n'a été trouvé dans la BDD",
                        ErrorCodes.LISTING_NOT_FOUND)
        );
    }

    @Override
    public AnnonceDto save(AnnonceDto annonceDto) {
        // on valide l'entité
        List<String> errors = AnnonceValidator.validate(annonceDto);
        // s'il y a une erreur
        if(!errors.isEmpty()){
            log.error("Annonce is not valid {}",annonceDto);
            throw  new InvalidEntityException("L'annonce n'est pas valide", ErrorCodes.LISTING_NOT_VALID, errors);
        }
        return AnnonceDto.fromEntity(annonceRepository.save(AnnonceDto.toEntity(annonceDto)));
    }

    //on recupère la liste des annonces
    @Override
    public List<AnnonceDto> findAll() {

        return annonceRepository.findAll().stream()
                .map(AnnonceDto::fromEntity)
                .collect(Collectors.toList());
    }

    // on supprime l'annonce en fonction de l'id
    @Override
    public void delete(Long id) {
        if(id == null){
            log.error("Annonce ID is null");
            return;
        }
        annonceRepository.deleteById(id);
    }

    @Override
    public void publier(Long id) {

    }

    @Override
    public AnnonceDto findByConcessionnaireAndEtat(Long idconcessionnaire, String etat) {
        if(idconcessionnaire == null){
            log.error("Concessionnaire ID is null");
            return null;
        }
        if(etat == null){
            log.error("etat de l'annonce is null ");
        }
        Optional<Annonce> annonce = annonceRepository.findAnnonceByConcessionnaireAndEtatAnnonce(idconcessionnaire, etat);

        return Optional.of(AnnonceDto.fromEntity(annonce.get())).orElseThrow(() ->
                new EntityNotFoundException("Aucune Annonce avec pour concessionnaire  l'ID = "+ idconcessionnaire +"  et l' "+ etat+"n'a été trouvé dans la BDD",
                        ErrorCodes.LISTING_NOT_FOUND)
        );
    }

    @Override
    public AnnonceDto findByConcessionnaire(Long idConcessionnaire) {
        if(idConcessionnaire == null){
            log.error("Concessionnaire ID is null");
            return null;
        }
        Optional<Annonce> annonce = annonceRepository.findAnnonceByConcessionnaire(idConcessionnaire);

        return Optional.of(AnnonceDto.fromEntity(annonce.get())).orElseThrow(() ->
                new EntityNotFoundException("Aucune Annonce avec pour concessionnaire l'ID = "+ idConcessionnaire +" n'a été trouvé dans la BDD",
                        ErrorCodes.LISTING_NOT_FOUND)
        );
    }

}
