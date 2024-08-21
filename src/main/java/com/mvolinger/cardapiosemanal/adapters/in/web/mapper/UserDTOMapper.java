package com.mvolinger.cardapiosemanal.adapters.in.web.mapper;

import com.mvolinger.cardapiosemanal.core.domain.models.DietType;
import com.mvolinger.cardapiosemanal.core.domain.models.User;
import com.mvolinger.cardapiosemanal.adapters.in.web.dtos.UserPostRequest;

public class UserDTOMapper {

    public static User toModel(UserPostRequest userPostRequest) {
        return new User(
                null,
                userPostRequest.getName(),
                userPostRequest.getLastname(),
                userPostRequest.getEmail(),
                userPostRequest.getPassword(),
                getDietType(userPostRequest)
        );
    }

    private static DietType getDietType(UserPostRequest userPostRequest) {
        return new DietType(
                null,
                userPostRequest.getDietType().getOmnivorous(),
                userPostRequest.getDietType().getCeliacDisease(),
                userPostRequest.getDietType().getDiabetes(),
                userPostRequest.getDietType().getLactoseIntolerance(),
                userPostRequest.getDietType().getLactovegetarian(),
                userPostRequest.getDietType().getOvolactovegetarian(),
                userPostRequest.getDietType().getOvovegetarian(),
                userPostRequest.getDietType().getPescetarian(),
                userPostRequest.getDietType().getVegan()
        );
    }
}