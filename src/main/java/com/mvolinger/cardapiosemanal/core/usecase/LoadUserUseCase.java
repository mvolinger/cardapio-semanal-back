package com.mvolinger.cardapiosemanal.core.usecase;

import com.mvolinger.cardapiosemanal.core.domain.models.User;
import com.mvolinger.cardapiosemanal.core.port.in.GetUserInputPort;
import com.mvolinger.cardapiosemanal.core.port.out.FindUserOutputPort;

import java.util.UUID;

public class LoadUserUseCase implements GetUserInputPort {

    private final FindUserOutputPort findUserOutputPort;

    public LoadUserUseCase(FindUserOutputPort findUserOutputPort) {
        this.findUserOutputPort = findUserOutputPort;
    }

    @Override
    public User getById(UUID id) {
        return findUserOutputPort.findById(id);
    }
}