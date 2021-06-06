package com.kkaj.advertising.entities;

public enum CategoryVoiture {
    Basse("basse game"),
    moyenne("moyenne game"),
    haute("haute game");

    private String description;
    CategoryVoiture(String description){this.description = description;}
}
