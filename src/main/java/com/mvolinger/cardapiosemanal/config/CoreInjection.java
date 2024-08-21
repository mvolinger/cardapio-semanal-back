package com.mvolinger.cardapiosemanal.config;

import com.mvolinger.cardapiosemanal.core.port.in.GetIngredientInputPort;
import com.mvolinger.cardapiosemanal.core.port.in.PostMealInputPort;
import com.mvolinger.cardapiosemanal.core.port.out.*;
import com.mvolinger.cardapiosemanal.core.usecase.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CoreInjection {

    @Bean
    public CreateUserUseCase createUser(SaveUserOutputPort saveUserOutputPort){
        return new CreateUserUseCase(saveUserOutputPort);
    }

    @Bean
    public LoadUserUseCase loadUser(FindUserOutputPort findUserOutputPort){
        return new LoadUserUseCase(findUserOutputPort);
    }

    @Bean
    public CreateIngredientUseCase createIngredient(SaveIngredientOutputPort saveIngredientOutputPort){
        return new CreateIngredientUseCase(saveIngredientOutputPort);
    }

    @Bean
    public LoadIngredientUseCase loadIngredient(FindIngredientOutputPort findIngredientOutputPort){
        return new LoadIngredientUseCase(findIngredientOutputPort);
    }

    @Bean
    public CreateMealUseCase createMeal(SaveMealOutputPort saveMealOutputPort, FindUserOutputPort findUserOutputPort, GetIngredientInputPort getIngredientInputPort){
        return new CreateMealUseCase(saveMealOutputPort, findUserOutputPort, getIngredientInputPort);
    }

    @Bean
    public LoadMealUseCase loadMeal(FindMealOutputPort findMealOutputPort){
        return new LoadMealUseCase(findMealOutputPort);
    }

    @Bean
    public CreateWeekMenuUseCase createWeekMenu(SaveWeekMenuOutputPort saveWeekMenuOutputPort, FindUserOutputPort findUserOutputPort, PostMealInputPort postMealInputPort){
        return new CreateWeekMenuUseCase(saveWeekMenuOutputPort, findUserOutputPort, postMealInputPort);
    }

    @Bean
    public LoadWeekMenuUseCase loadWeekMenu(FindWeekMenuOutputPort findWeekMenuOutputPort){
        return new LoadWeekMenuUseCase(findWeekMenuOutputPort);
    }

    @Bean
    public UpdateWeekMenuUseCase updateWeekMenu(SaveWeekMenuOutputPort saveWeekMenuOutputPort, FindWeekMenuOutputPort findWeekMenuOutputPort, FindUserOutputPort findUserOutputPort){
        return new UpdateWeekMenuUseCase(saveWeekMenuOutputPort, findWeekMenuOutputPort, findUserOutputPort);
    }

    @Bean
    public DeleteWeekMenuUseCase deleteWeekMenu(DeleteWeekMenuOutputPort deleteWeekMenuOutputPort){
        return new DeleteWeekMenuUseCase(deleteWeekMenuOutputPort);
    }
}