package com.kkaj.advertising;

import com.kkaj.advertising.entities.Annonce;
import com.kkaj.advertising.entities.EtatAnnonce;
import com.kkaj.advertising.repository.AnnonceRepository;
import com.kkaj.advertising.service.AnnonceService;
import com.kkaj.advertising.service.imp.AnnonceServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AnnonceServiceTest {

    @Mock
    AnnonceRepository annonceRepository;



    @InjectMocks
    AnnonceService annonceService = new AnnonceServiceImpl(annonceRepository);

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void return_annonce_when_annonceAdded() {
        EtatAnnonce etatAnnonce = EtatAnnonce.draft;
        Annonce annonce = new Annonce("Achille",etatAnnonce);
        when(annonceRepository.save(any(Annonce.class))).thenReturn(annonce);
        assertEquals(annonce, annonceRepository.save(new Annonce("Junior",etatAnnonce)));
    }



}
