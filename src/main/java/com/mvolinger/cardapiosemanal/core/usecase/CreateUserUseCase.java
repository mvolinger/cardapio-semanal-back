package com.mvolinger.cardapiosemanal.core.usecase;

import com.mvolinger.cardapiosemanal.core.domain.models.User;
import com.mvolinger.cardapiosemanal.core.port.in.PostUserInputPort;
import com.mvolinger.cardapiosemanal.core.port.out.SaveUserOutputPort;

public class CreateUserUseCase implements PostUserInputPort {

    private final SaveUserOutputPort saveUserOutputPort;

    public CreateUserUseCase(SaveUserOutputPort saveUserOutputPort) {
        this.saveUserOutputPort = saveUserOutputPort;
    }

    @Override
    public User create(User user) {
        return saveUserOutputPort.save(user);
    }
}