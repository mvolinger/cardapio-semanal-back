package com.mvolinger.cardapiosemanal.adapters.out.persistence.mapper;

import com.mvolinger.cardapiosemanal.adapters.out.persistence.models.MealJpa;
import com.mvolinger.cardapiosemanal.config.CommonMapperConfig;
import com.mvolinger.cardapiosemanal.core.domain.models.Meal;
import org.mapstruct.Mapper;

@Mapper(config = CommonMapperConfig.class)
public interface MealMapper {

    Meal toModel(MealJpa mealJpa);

    MealJpa toJpa(Meal meal);

}