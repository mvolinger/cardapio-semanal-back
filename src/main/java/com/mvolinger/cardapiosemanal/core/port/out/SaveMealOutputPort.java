package com.mvolinger.cardapiosemanal.core.port.out;

import com.mvolinger.cardapiosemanal.core.domain.models.Meal;

public interface SaveMealOutputPort {

    Meal save(Meal meal);
}