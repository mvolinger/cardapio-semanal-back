package com.mvolinger.cardapiosemanal.core.domain.models;

import java.util.UUID;

public class MealType {

    private UUID mealTypeId;
    private Boolean breakfast;
    private Boolean lunch;
    private Boolean snack;
    private Boolean dinner;

    public MealType() {}

    public MealType(UUID mealTypeId, Boolean breakfast, Boolean lunch, Boolean snack, Boolean dinner) {
        this.mealTypeId = mealTypeId;
        this.breakfast = breakfast;
        this.lunch = lunch;
        this.snack = snack;
        this.dinner = dinner;
    }

    public UUID getMealTypeId() {
        return mealTypeId;
    }

    public void setMealTypeId(UUID mealTypeId) {
        this.mealTypeId = mealTypeId;
    }

    public Boolean getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(Boolean breakfast) {
        this.breakfast = breakfast;
    }

    public Boolean getLunch() {
        return lunch;
    }

    public void setLunch(Boolean lunch) {
        this.lunch = lunch;
    }

    public Boolean getSnack() {
        return snack;
    }

    public void setSnack(Boolean snack) {
        this.snack = snack;
    }

    public Boolean getDinner() {
        return dinner;
    }

    public void setDinner(Boolean dinner) {
        this.dinner = dinner;
    }
}