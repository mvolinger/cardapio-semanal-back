package com.mvolinger.cardapiosemanal.adapters.out.persistence.mapper;

import com.mvolinger.cardapiosemanal.adapters.out.persistence.models.IngredientJpa;
import com.mvolinger.cardapiosemanal.config.CommonMapperConfig;
import com.mvolinger.cardapiosemanal.core.domain.models.Ingredient;
import org.mapstruct.Mapper;

@Mapper(config = CommonMapperConfig.class)
public interface IngredientMapper {

    Ingredient toModel(IngredientJpa ingredientJpa);

    IngredientJpa toJpa(Ingredient ingredient);

}