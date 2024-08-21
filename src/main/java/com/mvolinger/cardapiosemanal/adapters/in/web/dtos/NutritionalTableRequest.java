package com.mvolinger.cardapiosemanal.adapters.in.web.dtos;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class NutritionalTableRequest {

    private BigDecimal energy;
    private BigDecimal carbohydrates;
    private BigDecimal fiber;
    private BigDecimal saturatedFat;
    private BigDecimal totalLipid;
    private BigDecimal protein;
    private BigDecimal sodium;
}