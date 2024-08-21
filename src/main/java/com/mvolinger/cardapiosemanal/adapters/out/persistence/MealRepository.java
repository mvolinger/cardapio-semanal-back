package com.mvolinger.cardapiosemanal.adapters.out.persistence;

import com.mvolinger.cardapiosemanal.adapters.out.persistence.jpa.MealJpaRepository;
import com.mvolinger.cardapiosemanal.adapters.out.persistence.mapper.MealMapper;
import com.mvolinger.cardapiosemanal.adapters.out.persistence.models.MealJpa;
import com.mvolinger.cardapiosemanal.core.domain.models.Meal;
import com.mvolinger.cardapiosemanal.core.port.out.FindMealOutputPort;
import com.mvolinger.cardapiosemanal.core.port.out.SaveMealOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class MealRepository implements SaveMealOutputPort, FindMealOutputPort {

    private final MealJpaRepository mealJpaRepository;
    private final MealMapper mealMapper;

    @Override
    public Meal save(Meal meal) {
        MealJpa mealJpa = mealMapper.toJpa(meal);
        MealJpa mealJpaSaved = mealJpaRepository.save(mealJpa);
        return mealMapper.toModel(mealJpaSaved);
    }

    @Override
    public Meal findById(UUID id) {
        MealJpa mealJpa = mealJpaRepository.findById(id)
                .orElseThrow(RuntimeException::new);
                //.orElseThrow(() -> new NotFoundException("meal not found"));
        return mealMapper.toModel(mealJpa);
    }
}