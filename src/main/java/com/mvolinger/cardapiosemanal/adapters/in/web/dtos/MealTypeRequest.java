package com.mvolinger.cardapiosemanal.adapters.in.web.dtos;

import lombok.Data;

@Data
public class MealTypeRequest {

    private Boolean breakfast;
    private Boolean lunch;
    private Boolean snack;
    private Boolean dinner;
}