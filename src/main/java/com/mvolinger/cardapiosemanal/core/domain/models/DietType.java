package com.mvolinger.cardapiosemanal.core.domain.models;

import java.util.UUID;

public class DietType {

    private UUID dietTypeId;
    private Boolean omnivorous;
    private Boolean celiacDisease;
    private Boolean diabetes;
    private Boolean lactoseIntolerance;
    private Boolean lactovegetarian;
    private Boolean ovolactovegetarian;
    private Boolean ovovegetarian;
    private Boolean pescetarian;
    private Boolean vegan;

    public DietType() {}

    public DietType(UUID dietTypeId, Boolean omnivorous, Boolean celiacDisease, Boolean diabetes, Boolean lactoseIntolerance, Boolean lactovegetarian, Boolean ovolactovegetarian, Boolean ovovegetarian, Boolean pescetarian, Boolean vegan) {
        this.dietTypeId = dietTypeId;
        this.omnivorous = omnivorous;
        this.celiacDisease = celiacDisease;
        this.diabetes = diabetes;
        this.lactoseIntolerance = lactoseIntolerance;
        this.lactovegetarian = lactovegetarian;
        this.ovolactovegetarian = ovolactovegetarian;
        this.ovovegetarian = ovovegetarian;
        this.pescetarian = pescetarian;
        this.vegan = vegan;
    }

    public UUID getDietTypeId() {
        return dietTypeId;
    }

    public void setDietTypeId(UUID dietTypeId) {
        this.dietTypeId = dietTypeId;
    }

    public Boolean getOmnivorous() {
        return omnivorous;
    }

    public void setOmnivorous(Boolean omnivorous) {
        this.omnivorous = omnivorous;
    }

    public Boolean getCeliacDisease() {
        return celiacDisease;
    }

    public void setCeliacDisease(Boolean celiacDisease) {
        this.celiacDisease = celiacDisease;
    }

    public Boolean getDiabetes() {
        return diabetes;
    }

    public void setDiabetes(Boolean diabetes) {
        this.diabetes = diabetes;
    }

    public Boolean getLactoseIntolerance() {
        return lactoseIntolerance;
    }

    public void setLactoseIntolerance(Boolean lactoseIntolerance) {
        this.lactoseIntolerance = lactoseIntolerance;
    }

    public Boolean getLactovegetarian() {
        return lactovegetarian;
    }

    public void setLactovegetarian(Boolean lactovegetarian) {
        this.lactovegetarian = lactovegetarian;
    }

    public Boolean getOvolactovegetarian() {
        return ovolactovegetarian;
    }

    public void setOvolactovegetarian(Boolean ovolactovegetarian) {
        this.ovolactovegetarian = ovolactovegetarian;
    }

    public Boolean getOvovegetarian() {
        return ovovegetarian;
    }

    public void setOvovegetarian(Boolean ovovegetarian) {
        this.ovovegetarian = ovovegetarian;
    }

    public Boolean getPescetarian() {
        return pescetarian;
    }

    public void setPescetarian(Boolean pescetarian) {
        this.pescetarian = pescetarian;
    }

    public Boolean getVegan() {
        return vegan;
    }

    public void setVegan(Boolean vegan) {
        this.vegan = vegan;
    }
}