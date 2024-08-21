package com.mvolinger.cardapiosemanal.core.usecase;

import com.mvolinger.cardapiosemanal.core.domain.models.Meal;
import com.mvolinger.cardapiosemanal.core.domain.models.User;
import com.mvolinger.cardapiosemanal.core.port.in.GetIngredientInputPort;
import com.mvolinger.cardapiosemanal.core.port.in.PostMealInputPort;
import com.mvolinger.cardapiosemanal.core.port.out.FindUserOutputPort;
import com.mvolinger.cardapiosemanal.core.port.out.SaveMealOutputPort;

import java.util.UUID;

import static com.mvolinger.cardapiosemanal.core.domain.behavior.MealTypeUtils.getModelFromString;

public class CreateMealUseCase implements PostMealInputPort {

    private final SaveMealOutputPort saveMealOutputPort;
    private final FindUserOutputPort findUserOutputPort;
    private final GetIngredientInputPort getIngredientInputPort;

    public CreateMealUseCase(
            SaveMealOutputPort saveMealOutputPort,
            FindUserOutputPort findUserOutputPort,
            GetIngredientInputPort getIngredientInputPort) {
        this.saveMealOutputPort = saveMealOutputPort;
        this.findUserOutputPort = findUserOutputPort;
        this.getIngredientInputPort = getIngredientInputPort;
    }

    @Override
    public Meal create(String description, String userId, String mealType) {
        User user = findUserOutputPort.findById(UUID.fromString(userId));
        return saveMealOutputPort.save(
                new Meal(null,
                        description,
                        user,
                        getModelFromString(mealType),
                        getIngredientInputPort.getMealIngredientsList(user, mealType)));
    }

    @Override
    public Meal create(String description, User user, String mealType) {
        return saveMealOutputPort.save(
                new Meal(null,
                        description,
                        user,
                        getModelFromString(mealType),
                        getIngredientInputPort.getMealIngredientsList(user, mealType)));
    }
}