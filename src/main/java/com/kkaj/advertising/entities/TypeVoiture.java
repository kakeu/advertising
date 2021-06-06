package com.kkaj.advertising.entities;

public enum TypeVoiture {
    occasion("voiture d'occasion"),
    neuve("voiture neuve");

    private String description;
    TypeVoiture(String description){this.description = description;}
}
