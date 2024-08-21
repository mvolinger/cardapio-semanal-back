package com.mvolinger.cardapiosemanal.core.port.in;

import com.mvolinger.cardapiosemanal.core.domain.models.Meal;

import java.util.UUID;

public interface GetMealInputPort {

    Meal getById(UUID id);
}