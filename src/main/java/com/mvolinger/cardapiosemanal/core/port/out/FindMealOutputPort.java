package com.mvolinger.cardapiosemanal.core.port.out;

import com.mvolinger.cardapiosemanal.core.domain.models.Meal;

import java.util.UUID;

public interface FindMealOutputPort {

    Meal findById(UUID id);
}