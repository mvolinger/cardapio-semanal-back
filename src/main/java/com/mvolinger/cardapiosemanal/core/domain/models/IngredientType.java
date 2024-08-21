package com.mvolinger.cardapiosemanal.core.domain.models;

import java.util.UUID;

public class IngredientType {

    private UUID ingredientTypeId;
    private Boolean carbohydrate;
    private Boolean animalProtein;
    private Boolean plantProtein;
    private Boolean leafVegetable;
    private Boolean rootVegetable;
    private Boolean fruit;

    public IngredientType() {}

    public IngredientType(UUID ingredientTypeId, Boolean carbohydrate, Boolean animalProtein, Boolean plantProtein, Boolean leafVegetable, Boolean rootVegetable, Boolean fruit) {
        this.ingredientTypeId = ingredientTypeId;
        this.carbohydrate = carbohydrate;
        this.animalProtein = animalProtein;
        this.plantProtein = plantProtein;
        this.leafVegetable = leafVegetable;
        this.rootVegetable = rootVegetable;
        this.fruit = fruit;
    }

    public UUID getIngredientTypeId() {
        return ingredientTypeId;
    }

    public void setIngredientTypeId(UUID ingredientTypeId) {
        this.ingredientTypeId = ingredientTypeId;
    }

    public Boolean getCarbohydrate() {
        return carbohydrate;
    }

    public void setCarbohydrate(Boolean carbohydrate) {
        this.carbohydrate = carbohydrate;
    }

    public Boolean getAnimalProtein() {
        return animalProtein;
    }

    public void setAnimalProtein(Boolean animalProtein) {
        this.animalProtein = animalProtein;
    }

    public Boolean getPlantProtein() {
        return plantProtein;
    }

    public void setPlantProtein(Boolean plantProtein) {
        this.plantProtein = plantProtein;
    }

    public Boolean getLeafVegetable() {
        return leafVegetable;
    }

    public void setLeafVegetable(Boolean leafVegetable) {
        this.leafVegetable = leafVegetable;
    }

    public Boolean getRootVegetable() {
        return rootVegetable;
    }

    public void setRootVegetable(Boolean rootVegetable) {
        this.rootVegetable = rootVegetable;
    }

    public Boolean getFruit() {
        return fruit;
    }

    public void setFruit(Boolean fruit) {
        this.fruit = fruit;
    }
}