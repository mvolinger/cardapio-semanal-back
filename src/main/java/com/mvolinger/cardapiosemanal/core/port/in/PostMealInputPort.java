package com.mvolinger.cardapiosemanal.core.port.in;

import com.mvolinger.cardapiosemanal.core.domain.models.Meal;
import com.mvolinger.cardapiosemanal.core.domain.models.User;

public interface PostMealInputPort {

    Meal create(String description, String userId, String mealType);

    Meal create(String description, User user, String mealType);
}