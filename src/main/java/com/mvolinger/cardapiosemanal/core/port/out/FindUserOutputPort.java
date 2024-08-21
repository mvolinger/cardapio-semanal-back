package com.mvolinger.cardapiosemanal.core.port.out;

import com.mvolinger.cardapiosemanal.core.domain.models.User;

import java.util.UUID;

public interface FindUserOutputPort {

    User findById(UUID id);
}