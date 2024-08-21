package com.mvolinger.cardapiosemanal.core.usecase;

import com.mvolinger.cardapiosemanal.core.port.in.DeleteWeekMenuInputPort;
import com.mvolinger.cardapiosemanal.core.port.out.DeleteWeekMenuOutputPort;

import java.util.UUID;

public class DeleteWeekMenuUseCase implements DeleteWeekMenuInputPort {

    private final DeleteWeekMenuOutputPort deleteWeekMenuOutputPort;

    public DeleteWeekMenuUseCase(DeleteWeekMenuOutputPort deleteWeekMenuOutputPort) {
        this.deleteWeekMenuOutputPort = deleteWeekMenuOutputPort;
    }

    @Override
    public void delete(UUID id) {
        deleteWeekMenuOutputPort.delete(id);
    }
}