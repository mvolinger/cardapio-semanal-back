package com.mvolinger.cardapiosemanal.adapters.in.web.dtos;

import lombok.Data;

@Data
public class DietTypeRequest {

    private Boolean omnivorous;
    private Boolean celiacDisease;
    private Boolean diabetes;
    private Boolean lactoseIntolerance;
    private Boolean lactovegetarian;
    private Boolean ovolactovegetarian;
    private Boolean ovovegetarian;
    private Boolean pescetarian;
    private Boolean vegan;
}