package com.mvolinger.cardapiosemanal.core.port.in;

import com.mvolinger.cardapiosemanal.core.domain.models.User;

public interface PostUserInputPort {

    User create(User user);
}