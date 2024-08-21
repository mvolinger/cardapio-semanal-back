package com.mvolinger.cardapiosemanal.core.port.in;

import com.mvolinger.cardapiosemanal.core.domain.models.User;

import java.util.UUID;

public interface GetUserInputPort {

    User getById(UUID id);
}