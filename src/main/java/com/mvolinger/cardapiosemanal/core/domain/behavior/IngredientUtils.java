package com.mvolinger.cardapiosemanal.core.domain.behavior;

import com.mvolinger.cardapiosemanal.core.domain.models.Ingredient;

import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class IngredientUtils {

    public static Ingredient getRandomIngredient(List<Ingredient> list) {
        Collections.shuffle(list);
        return list.get(0);
    }

    public static List<Ingredient> filterBreakfastIngredients(List<Ingredient> ingredients) {
        return ingredients.stream()
                .filter(IngredientUtils::isBreakfast)
                .collect(collectingAndThen(
                        toList(),
                        result -> {
                            if (result.isEmpty()) throw new RuntimeException("Nenhum breakfast encontrado!");
                            return result;
                        }));
    }

    public static List<Ingredient> filterLunchIngredients(List<Ingredient> ingredients) {
        return ingredients.stream()
                .filter(IngredientUtils::isLunch)
                .collect(collectingAndThen(
                        toList(),
                        result -> {
                            if (result.isEmpty()) throw new RuntimeException("Nenhum Lunch encontrado!");
                            return result;
                        }));
    }

    public static List<Ingredient> filterSnackIngredients(List<Ingredient> ingredients) {
        return ingredients.stream()
                .filter(IngredientUtils::isSnack)
                .collect(collectingAndThen(
                        toList(),
                        result -> {
                            if (result.isEmpty()) throw new RuntimeException("Nenhum Snack encontrado!");
                            return result;
                        }));
    }

    public static List<Ingredient> filterDinnerIngredients(List<Ingredient> ingredients) {
        return ingredients.stream()
                .filter(IngredientUtils::isDinner)
                .collect(collectingAndThen(
                        toList(),
                        result -> {
                            if (result.isEmpty()) throw new RuntimeException("Nenhum Dinner encontrado!");
                            return result;
                        }));
    }

    public static List<Ingredient> getCarbohydrateIngredientsList(List<Ingredient> ingredients) {
        return ingredients.stream()
                .filter(IngredientUtils::isCarbohydrate)
                .collect(collectingAndThen(
                        toList(),
                        result -> {
                            if (result.isEmpty()) throw new RuntimeException("Nenhum carboidrato encontrado!");
                            return result;
                        }));
    }

    public static List<Ingredient> getAnimalProteinIngredientsList(List<Ingredient> ingredients) {
        return ingredients.stream()
                .filter(IngredientUtils::isAnimalProtein)
                .collect(collectingAndThen(
                        toList(),
                        result -> {
                            if (result.isEmpty()) throw new RuntimeException("Nenhuma proteína animal encontrada!");
                            return result;
                        }));
    }

    public static List<Ingredient> getPlantProteinIngredientsList(List<Ingredient> ingredients) {
        return ingredients.stream()
                .filter(IngredientUtils::isPlantProtein)
                .collect(collectingAndThen(
                        toList(),
                        result -> {
                            if (result.isEmpty()) throw new RuntimeException("Nenhuma proteína vegetal encontrada!");
                            return result;
                        }));
    }

    public static List<Ingredient> getRootVegetableIngredientsList(List<Ingredient> ingredients) {
        return ingredients.stream()
                .filter(IngredientUtils::isRootVegetable)
                .collect(collectingAndThen(
                        toList(),
                        result -> {
                            if (result.isEmpty()) throw new RuntimeException("Nenhum legume encontrado!");
                            return result;
                        }));
    }

    public static List<Ingredient> getLeafVegetableIngredientsList(List<Ingredient> ingredients) {
        return ingredients.stream()
                .filter(IngredientUtils::isLeafVegetable)
                .collect(collectingAndThen(
                        toList(),
                        result -> {
                            if (result.isEmpty()) throw new RuntimeException("Nenhuma verdura encontrada!");
                            return result;
                        }));
    }

    public static List<Ingredient> getFruitIngredientsList(List<Ingredient> ingredients) {
        return ingredients.stream()
                .filter(IngredientUtils::isFruit)
                .collect(collectingAndThen(
                        toList(),
                        result -> {
                            if (result.isEmpty()) throw new RuntimeException("Nenhuma fruta encontrada!");
                            return result;
                        }));
    }

    public static boolean isBreakfast(Ingredient ingredient) {
        return (ingredient.getMealType() != null
                && ingredient.getMealType().getBreakfast() != null
                && ingredient.getMealType().getBreakfast());
    }

    public static boolean isLunch(Ingredient ingredient) {
        return (ingredient.getMealType() != null
                && ingredient.getMealType().getLunch() != null
                && ingredient.getMealType().getLunch());
    }

    public static boolean isSnack(Ingredient ingredient) {
        return (ingredient.getMealType() != null
                && ingredient.getMealType().getSnack() != null
                && ingredient.getMealType().getSnack());
    }

    public static boolean isDinner(Ingredient ingredient) {
        return (ingredient.getMealType() != null
                && ingredient.getMealType().getDinner() != null
                && ingredient.getMealType().getDinner());
    }

    public static boolean isCarbohydrate(Ingredient ingredient) {
        return (ingredient.getIngredientType() != null
                && ingredient.getIngredientType().getCarbohydrate() != null
                && ingredient.getIngredientType().getCarbohydrate());
    }

    public static boolean isAnimalProtein(Ingredient ingredient) {
        return (ingredient.getIngredientType() != null
                && ingredient.getIngredientType().getAnimalProtein() != null
                && ingredient.getIngredientType().getAnimalProtein());
    }

    public static boolean isPlantProtein(Ingredient ingredient) {
        return (ingredient.getIngredientType() != null
                && ingredient.getIngredientType().getPlantProtein() != null
                && ingredient.getIngredientType().getPlantProtein());
    }

    public static boolean isRootVegetable(Ingredient ingredient) {
        return (ingredient.getIngredientType() != null
                && ingredient.getIngredientType().getRootVegetable() != null
                && ingredient.getIngredientType().getRootVegetable());
    }

    public static boolean isLeafVegetable(Ingredient ingredient) {
        return (ingredient.getIngredientType() != null
                && ingredient.getIngredientType().getLeafVegetable() != null
                && ingredient.getIngredientType().getLeafVegetable());
    }

    public static boolean isFruit(Ingredient ingredient) {
        return (ingredient.getIngredientType() != null
                && ingredient.getIngredientType().getFruit() != null
                && ingredient.getIngredientType().getFruit());
    }
}