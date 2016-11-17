package com.pabloazana.models;


public class AwesomePlace {

    private int id;
    private String name;
    private String littleDescription;
    private String cardImageUri;
    private String backgroundImageUri;
    private Detail details;

    public AwesomePlace(int id, String name, String littleDescription, String cardImageUri,
                        String backgroundImageUri, Detail details) {
        this.id = id;
        this.name = name;
        this.littleDescription = littleDescription;
        this.cardImageUri = cardImageUri;
        this.backgroundImageUri = backgroundImageUri;
        this.details = details;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLittleDescription() {
        return littleDescription;
    }

    public String getCardImageUri() {
        return cardImageUri;
    }

    public String getBackgroundImageUri() {
        return backgroundImageUri;
    }

    public Detail getDetails() {
        return details;
    }
}
