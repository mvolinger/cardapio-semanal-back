package com.mvolinger.cardapiosemanal.core.port.out;

import com.mvolinger.cardapiosemanal.core.domain.models.WeekMenu;

public interface SaveWeekMenuOutputPort {

    WeekMenu save(WeekMenu weekMenu);
}