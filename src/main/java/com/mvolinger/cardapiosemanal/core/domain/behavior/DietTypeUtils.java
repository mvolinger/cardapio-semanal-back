package com.mvolinger.cardapiosemanal.core.domain.behavior;

import com.mvolinger.cardapiosemanal.core.domain.models.DietType;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class DietTypeUtils {

    public static List<String> getUserDietTypeTrueAttributes(DietType userDietType) {
        List<String> trueAttributes = new ArrayList<>();
        for(Field field : userDietType.getClass().getDeclaredFields()) {
            if(field.getType() == Boolean.class) {
                try {
                    field.setAccessible(true);
                    Boolean value = (Boolean) field.get(userDietType);
                    if (value != null && value) {
                        trueAttributes.add(field.getName());
                    }
                } catch (IllegalAccessException e) {
                    //TODO Criar exception
                }
            }
        }
        return trueAttributes;
    }
}