package com.kkaj.advertising.entities;

public enum EtatAnnonce {
    published ("disponible en ligne"),
    draft("non disponible en ligne");

    private  String description;
    EtatAnnonce(String description){this.description = description;}
}
