package com.mvolinger.cardapiosemanal.core.usecase;

import com.mvolinger.cardapiosemanal.core.domain.models.Ingredient;
import com.mvolinger.cardapiosemanal.core.domain.models.User;
import com.mvolinger.cardapiosemanal.core.port.in.GetIngredientInputPort;
import com.mvolinger.cardapiosemanal.core.port.out.FindIngredientOutputPort;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.mvolinger.cardapiosemanal.core.domain.behavior.DietTypeUtils.getUserDietTypeTrueAttributes;
import static com.mvolinger.cardapiosemanal.core.domain.behavior.IngredientUtils.*;
import static com.mvolinger.cardapiosemanal.core.domain.behavior.MealTypeUtils.*;

public class LoadIngredientUseCase implements GetIngredientInputPort {

    private final FindIngredientOutputPort findIngredientOutputPort;

    public LoadIngredientUseCase(FindIngredientOutputPort findIngredientOutputPort) {
        this.findIngredientOutputPort = findIngredientOutputPort;
    }

    @Override
    public Ingredient getById(UUID id) {
        return findIngredientOutputPort.findById(id);
    }

    @Override
    public List<Ingredient> getMealIngredientsList(User user, String mealType) {
        isValidMealType(mealType);
        List<Ingredient> ingredientsMatchingUserDiet = findIngredientOutputPort
                .findIngredientsMatchingUserDiet(getUserDietTypeTrueAttributes(user.getDietType()));
        switch (mealType) {
            case BREAKFAST:
                return getBreakfastIngredientsList(user, ingredientsMatchingUserDiet);
            case LUNCH:
                return getLunchIngredientsList(user, ingredientsMatchingUserDiet);
            case SNACK:
                return getSnackIngredientsList(user, ingredientsMatchingUserDiet);
            case DINNER:
                return getDinnerIngredientsList(user, ingredientsMatchingUserDiet);
        }
        throw new RuntimeException("Something went wrong");
    }

    public List<Ingredient> getBreakfastIngredientsList(User user, List<Ingredient> ingredientsMatchingUserDiet) {
        return getMealIngredients(user, filterBreakfastIngredients(ingredientsMatchingUserDiet));
    }

    public List<Ingredient> getLunchIngredientsList(User user, List<Ingredient> ingredientsMatchingUserDiet) {
        return getMealIngredients(user, filterLunchIngredients(ingredientsMatchingUserDiet));
    }

    public List<Ingredient> getSnackIngredientsList(User user, List<Ingredient> ingredientsMatchingUserDiet) {
        return getMealIngredients(user, filterSnackIngredients(ingredientsMatchingUserDiet));
    }

    public List<Ingredient> getDinnerIngredientsList(User user, List<Ingredient> ingredientsMatchingUserDiet) {
        return getMealIngredients(user, filterDinnerIngredients(ingredientsMatchingUserDiet));
    }

    private List<Ingredient> getMealIngredients(User user, List<Ingredient> filteredIngredients) {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(getRandomIngredient(getCarbohydrateIngredientsList(filteredIngredients)));
        ingredients.add(getRandomIngredient(getPlantProteinIngredientsList(filteredIngredients)));
        ingredients.add(getRandomIngredient(getRootVegetableIngredientsList(filteredIngredients)));
        ingredients.add(getRandomIngredient(getLeafVegetableIngredientsList(filteredIngredients)));
        ingredients.add(getRandomIngredient(getFruitIngredientsList(filteredIngredients)));
        if(!user.getDietType().getVegan()) {
            ingredients.add(getRandomIngredient(getAnimalProteinIngredientsList(filteredIngredients)));
        }
        return ingredients;
    }
}