package com.mvolinger.cardapiosemanal.core.domain.behavior;

import com.mvolinger.cardapiosemanal.core.domain.models.MealType;
import org.apache.commons.lang3.StringUtils;

public class MealTypeUtils {

    public static final String BREAKFAST = "breakfast";
    public static final String LUNCH = "lunch";
    public static final String SNACK = "snack";
    public static final String DINNER = "dinner";

    public static MealType getModelFromString(String type) {
        isValidMealType(type);
        MealType mealType = new MealType();
        mealType.setBreakfast(Boolean.FALSE);
        mealType.setLunch(Boolean.FALSE);
        mealType.setDinner(Boolean.FALSE);
        mealType.setSnack(Boolean.FALSE);
        switch(type) {
            case BREAKFAST:
                mealType.setBreakfast(Boolean.TRUE);
                break;
            case LUNCH:
                mealType.setLunch(Boolean.TRUE);
                break;
            case SNACK:
                mealType.setSnack(Boolean.TRUE);
                break;
            case DINNER:
                mealType.setDinner(Boolean.TRUE);
                break;
        }
        return mealType;
    }

    public static void isValidMealType(String type) {
        if(StringUtils.isEmpty(type) ||
                !(type.equals(BREAKFAST) || type.equals(LUNCH) || type.equals(SNACK) || type.equals(DINNER))) {
            throw new IllegalArgumentException("Invalid meal type: " + type);
        }
    }

}