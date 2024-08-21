package com.mvolinger.cardapiosemanal.core.usecase;

import com.mvolinger.cardapiosemanal.core.domain.models.WeekMenu;
import com.mvolinger.cardapiosemanal.core.port.in.GetWeekMenuInputPort;
import com.mvolinger.cardapiosemanal.core.port.out.FindWeekMenuOutputPort;

import java.util.List;
import java.util.UUID;

public class LoadWeekMenuUseCase implements GetWeekMenuInputPort {

    private final FindWeekMenuOutputPort findWeekMenuOutputPort;

    public LoadWeekMenuUseCase(FindWeekMenuOutputPort findWeekMenuOutputPort) {
        this.findWeekMenuOutputPort = findWeekMenuOutputPort;
    }

    @Override
    public WeekMenu getOne(UUID id) {
        return findWeekMenuOutputPort.findById(id);
    }

    @Override
    public List<WeekMenu> getByUserId(UUID userId) {
        return findWeekMenuOutputPort.findByUserId(userId);
    }
}