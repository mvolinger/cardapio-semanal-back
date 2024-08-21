package com.mvolinger.cardapiosemanal.core.port.out;

import com.mvolinger.cardapiosemanal.core.domain.models.User;

public interface SaveUserOutputPort {

    User save(User user);
}