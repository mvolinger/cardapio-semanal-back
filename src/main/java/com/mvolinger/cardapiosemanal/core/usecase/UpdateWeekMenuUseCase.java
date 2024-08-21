package com.mvolinger.cardapiosemanal.core.usecase;

import com.mvolinger.cardapiosemanal.core.domain.models.User;
import com.mvolinger.cardapiosemanal.core.domain.models.WeekMenu;
import com.mvolinger.cardapiosemanal.core.port.in.PatchWeekMenuInputPort;
import com.mvolinger.cardapiosemanal.core.port.out.FindUserOutputPort;
import com.mvolinger.cardapiosemanal.core.port.out.FindWeekMenuOutputPort;
import com.mvolinger.cardapiosemanal.core.port.out.SaveWeekMenuOutputPort;

import java.util.UUID;

public class UpdateWeekMenuUseCase implements PatchWeekMenuInputPort {

    private final SaveWeekMenuOutputPort saveWeekMenuOutputPort;
    private final FindWeekMenuOutputPort findWeekMenuOutputPort;
    private final FindUserOutputPort findUserOutputPort;

    public UpdateWeekMenuUseCase(
            SaveWeekMenuOutputPort saveWeekMenuOutputPort,
            FindWeekMenuOutputPort findWeekMenuOutputPort,
            FindUserOutputPort findUserOutputPort) {
        this.saveWeekMenuOutputPort = saveWeekMenuOutputPort;
        this.findWeekMenuOutputPort = findWeekMenuOutputPort;
        this.findUserOutputPort = findUserOutputPort;
    }

    @Override
    public WeekMenu update(UUID id, String description, String userId) {
        WeekMenu weekMenu = findWeekMenuOutputPort.findById(id);
        User user = findUserOutputPort.findById(UUID.fromString(userId));
        weekMenu.setDescription(description);
        weekMenu.setUser(user);
        return saveWeekMenuOutputPort.save(weekMenu);
    }
}