package com.mvolinger.cardapiosemanal.adapters.out.persistence.mapper;

import com.mvolinger.cardapiosemanal.adapters.out.persistence.models.WeekMenuJpa;
import com.mvolinger.cardapiosemanal.config.CommonMapperConfig;
import com.mvolinger.cardapiosemanal.core.domain.models.WeekMenu;
import org.mapstruct.Mapper;

@Mapper(config = CommonMapperConfig.class)
public interface WeekMenuMapper {

    WeekMenu toModel(WeekMenuJpa weekMenuJpa);

    WeekMenuJpa toJpa(WeekMenu weekMenu);

}