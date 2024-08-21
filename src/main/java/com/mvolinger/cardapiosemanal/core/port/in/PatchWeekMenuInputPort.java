package com.mvolinger.cardapiosemanal.core.port.in;

import com.mvolinger.cardapiosemanal.core.domain.models.WeekMenu;

import java.util.UUID;

public interface PatchWeekMenuInputPort {

    WeekMenu update(UUID id, String description, String userId);
}