package com.mvolinger.cardapiosemanal.core.port.in;

import com.mvolinger.cardapiosemanal.core.domain.models.WeekMenu;

import java.util.List;
import java.util.UUID;

public interface GetWeekMenuInputPort {

    WeekMenu getOne(UUID id);

    List<WeekMenu> getByUserId(UUID userId);
}