package com.kkaj.advertising.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString
@Entity
@Table(name = "concessionaire")
public class Concessionnaire extends AbstractEntity{
    @Column(name = "nom")
    private String nom;
    @Column(name = "adresse")
    private String adresse;
    @Column(name = "limiteniveau")
    private int limiteNiveau; // nombre d'annonce maximal pour un concessionnaire
    @OneToMany(mappedBy = "concessionnaire")
    private List<Voiture> voitures;
    @OneToMany(mappedBy = "concessionnaire")
    private List<Annonce> annonces;
}
