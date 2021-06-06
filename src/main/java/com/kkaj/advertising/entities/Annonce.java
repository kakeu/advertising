package com.kkaj.advertising.entities;


import lombok.*;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString
@Entity
@Table(name = "annonce")
public class Annonce extends AbstractEntity{

    @Column(name = "vendeur")
    private String vendeur;
    @Column(name = "etatannonce")
    private  EtatAnnonce etatAnnonce = EtatAnnonce.draft;
    @Column(name = "publishdate")
    private Date publishDate;
    @ManyToOne
    @JoinColumn(name = "idconcessionnaire")
    private Concessionnaire concessionnaire;
    @ManyToOne
    @JoinColumn(name = "idvoiture")
    private Voiture voiture;

    public Annonce(String vendeur, EtatAnnonce etatAnnonce) {
        this.vendeur = vendeur;
        this.etatAnnonce = etatAnnonce;
        //this.publishDate = publishDate;
    }
}
