package com.mvolinger.cardapiosemanal.core.domain.models;

import java.math.BigDecimal;
import java.util.UUID;

public class NutritionalTable {

    private UUID nutritionalTableId;
    private BigDecimal energy;
    private BigDecimal carbohydrates;
    private BigDecimal fiber;
    private BigDecimal saturatedFat;
    private BigDecimal totalLipid;
    private BigDecimal protein;
    private BigDecimal sodium;

    public NutritionalTable() {}

    public NutritionalTable(UUID nutritionalTableId, BigDecimal energy, BigDecimal carbohydrates, BigDecimal fiber, BigDecimal saturatedFat, BigDecimal totalLipid, BigDecimal protein, BigDecimal sodium) {
        this.nutritionalTableId = nutritionalTableId;
        this.energy = energy;
        this.carbohydrates = carbohydrates;
        this.fiber = fiber;
        this.saturatedFat = saturatedFat;
        this.totalLipid = totalLipid;
        this.protein = protein;
        this.sodium = sodium;
    }

    public UUID getNutritionalTableId() {
        return nutritionalTableId;
    }

    public void setNutritionalTableId(UUID nutritionalTableId) {
        this.nutritionalTableId = nutritionalTableId;
    }

    public BigDecimal getEnergy() {
        return energy;
    }

    public void setEnergy(BigDecimal energy) {
        this.energy = energy;
    }

    public BigDecimal getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(BigDecimal carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public BigDecimal getFiber() {
        return fiber;
    }

    public void setFiber(BigDecimal fiber) {
        this.fiber = fiber;
    }

    public BigDecimal getSaturatedFat() {
        return saturatedFat;
    }

    public void setSaturatedFat(BigDecimal saturatedFat) {
        this.saturatedFat = saturatedFat;
    }

    public BigDecimal getTotalLipid() {
        return totalLipid;
    }

    public void setTotalLipid(BigDecimal totalLipid) {
        this.totalLipid = totalLipid;
    }

    public BigDecimal getProtein() {
        return protein;
    }

    public void setProtein(BigDecimal protein) {
        this.protein = protein;
    }

    public BigDecimal getSodium() {
        return sodium;
    }

    public void setSodium(BigDecimal sodium) {
        this.sodium = sodium;
    }
}