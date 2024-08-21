package com.mvolinger.cardapiosemanal.core.port.in;

import com.mvolinger.cardapiosemanal.core.domain.models.WeekMenu;

public interface PostWeekMenuInputPort {

    WeekMenu create(String description, String userId);
}