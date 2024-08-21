package com.mvolinger.cardapiosemanal.adapters.in.web.dtos;

import lombok.Data;

@Data
public class MealPostRequest {

    private String description;
    private String userId;
    private String mealType;
}