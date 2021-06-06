package com.kkaj.advertising.entities;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString
@Entity
@Table(name = "voiture")
public class Voiture extends AbstractEntity{

    @Column(name = "marque")
    private String marque;
    @Column(name = "prix")
    private BigDecimal prix;
    @Column(name = "couleur")
    private String couleur;
    @Column(name = "typevoiture")
    private  TypeVoiture typeVoiture;
    @Column(name = "categoryvoiture")
    private CategoryVoiture categoryVoiture;
    @ManyToOne
    @JoinColumn(name = "idconcessionaire")
    private Concessionnaire concessionnaire;
    @OneToMany(mappedBy = "voiture")
    private List<Annonce> annonces;
}
