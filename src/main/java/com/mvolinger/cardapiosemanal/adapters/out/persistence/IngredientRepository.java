package com.mvolinger.cardapiosemanal.adapters.out.persistence;

import com.mvolinger.cardapiosemanal.adapters.out.persistence.jpa.IngredientJpaRepository;
import com.mvolinger.cardapiosemanal.adapters.out.persistence.mapper.IngredientMapper;
import com.mvolinger.cardapiosemanal.adapters.out.persistence.models.IngredientJpa;
import com.mvolinger.cardapiosemanal.core.domain.models.Ingredient;
import com.mvolinger.cardapiosemanal.core.port.out.FindIngredientOutputPort;
import com.mvolinger.cardapiosemanal.core.port.out.SaveIngredientOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

@Repository
@RequiredArgsConstructor
public class IngredientRepository implements SaveIngredientOutputPort, FindIngredientOutputPort {

    private final IngredientJpaRepository ingredientJpaRepository;
    private final IngredientMapper ingredientMapper;

    @Override
    public Ingredient save(Ingredient ingredient) {
        IngredientJpa ingredientJpa = ingredientMapper.toJpa(ingredient);
        IngredientJpa ingredientJpaSaved = ingredientJpaRepository.save(ingredientJpa);
        return ingredientMapper.toModel(ingredientJpaSaved);
    }

    @Override
    public Ingredient findById(UUID id) {
        IngredientJpa ingredientJpa = ingredientJpaRepository
                .findById(id)
                .orElseThrow(RuntimeException::new);
                //.orElseThrow(() -> new NotFoundException("ingredient not found"));
        return ingredientMapper.toModel(ingredientJpa);
    }

    @Override
    public List<Ingredient> findIngredientsMatchingUserDiet(List<String> userDietTrueAttributes) {
        return ingredientJpaRepository
                .findIngredientsMatchingCriteria(userDietTrueAttributes)
                .stream()
                .map(ingredientMapper::toModel)
                .collect(collectingAndThen(
                        toList(),
                        result -> {
                            if (result.isEmpty()) throw new RuntimeException("Nenhum ingrediente correspondente à dieta do usuário encontrado!");
                            return result;
                        }));
    }
}