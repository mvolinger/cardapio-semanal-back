package com.mvolinger.cardapiosemanal.core.port.out;

import com.mvolinger.cardapiosemanal.core.domain.models.WeekMenu;

import java.util.List;
import java.util.UUID;

public interface FindWeekMenuOutputPort {

    WeekMenu findById(UUID id);

    List<WeekMenu> findByUserId(UUID userId);
}