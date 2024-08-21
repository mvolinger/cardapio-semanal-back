package com.mvolinger.cardapiosemanal.core.usecase;

import com.mvolinger.cardapiosemanal.core.domain.models.Meal;
import com.mvolinger.cardapiosemanal.core.domain.models.User;
import com.mvolinger.cardapiosemanal.core.domain.models.WeekMenu;
import com.mvolinger.cardapiosemanal.core.port.in.PostMealInputPort;
import com.mvolinger.cardapiosemanal.core.port.in.PostWeekMenuInputPort;
import com.mvolinger.cardapiosemanal.core.port.out.FindUserOutputPort;
import com.mvolinger.cardapiosemanal.core.port.out.SaveWeekMenuOutputPort;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.mvolinger.cardapiosemanal.core.domain.behavior.MealTypeUtils.*;

public class CreateWeekMenuUseCase implements PostWeekMenuInputPort {

    private final static String DEFAULT_DESCRIPTION = "Meal automatically created by menu generation";
    private final static int DAYS_IN_WEEK = 7;

    private final SaveWeekMenuOutputPort saveWeekMenuOutputPort;
    private final FindUserOutputPort findUserOutputPort;
    private final PostMealInputPort postMealInputPort;

    public CreateWeekMenuUseCase(
            SaveWeekMenuOutputPort saveWeekMenuOutputPort,
            FindUserOutputPort findUserOutputPort,
            PostMealInputPort postMealInputPort) {
        this.saveWeekMenuOutputPort = saveWeekMenuOutputPort;
        this.findUserOutputPort = findUserOutputPort;
        this.postMealInputPort = postMealInputPort;
    }

    @Override
    public WeekMenu create(String description, String userId) {

        User user = findUserOutputPort.findById(UUID.fromString(userId));

        List<Meal> meals = new ArrayList<>();
        meals.addAll(getWeekMeals(user, BREAKFAST));
        meals.addAll(getWeekMeals(user, LUNCH));
        meals.addAll(getWeekMeals(user, SNACK));
        meals.addAll(getWeekMeals(user, DINNER));

        return saveWeekMenuOutputPort.save(new WeekMenu(null, description, user, meals));
    }

    private List<Meal> getWeekMeals(User user, String mealType) {
        List<Meal> meals = new ArrayList<>();
        int i = 0;
        while (i < DAYS_IN_WEEK) {
            meals.add(postMealInputPort.create(DEFAULT_DESCRIPTION, user, mealType));
            i++;
        }
        return meals;
    }
}