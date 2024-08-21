package com.mvolinger.cardapiosemanal.adapters.in.web.dtos;

import lombok.Data;

@Data
public class UserPostRequest {

    private String email;
    private String password;
    private String name;
    private String lastname;
    private DietTypeRequest dietType;
}