package com.mvolinger.cardapiosemanal.core.usecase;

import com.mvolinger.cardapiosemanal.core.domain.models.Meal;
import com.mvolinger.cardapiosemanal.core.port.in.GetMealInputPort;
import com.mvolinger.cardapiosemanal.core.port.out.FindMealOutputPort;

import java.util.UUID;

public class LoadMealUseCase implements GetMealInputPort {

    private final FindMealOutputPort findMealOutputPort;

    public LoadMealUseCase(FindMealOutputPort findMealOutputPort) {
        this.findMealOutputPort = findMealOutputPort;
    }

    @Override
    public Meal getById(UUID id) {
        return findMealOutputPort.findById(id);
    }
}