package com.mvolinger.cardapiosemanal.adapters.out.persistence.mapper;

import com.mvolinger.cardapiosemanal.adapters.out.persistence.models.UserJpa;
import com.mvolinger.cardapiosemanal.config.CommonMapperConfig;
import com.mvolinger.cardapiosemanal.core.domain.models.User;
import org.mapstruct.Mapper;

@Mapper(config = CommonMapperConfig.class)
public interface UserMapper {

    User toModel(UserJpa userJpa);

    UserJpa toJpa(User user);

}