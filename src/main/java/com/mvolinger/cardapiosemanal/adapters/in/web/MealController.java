package com.mvolinger.cardapiosemanal.adapters.in.web;

import com.mvolinger.cardapiosemanal.adapters.in.web.dtos.MealPostRequest;
import com.mvolinger.cardapiosemanal.core.domain.models.Meal;
import com.mvolinger.cardapiosemanal.core.port.in.GetMealInputPort;
import com.mvolinger.cardapiosemanal.core.port.in.PostMealInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/api/meals")
public class MealController {

    private final PostMealInputPort postMealInputPort;
    private final GetMealInputPort getMealInputPort;

    @Autowired
    public MealController(PostMealInputPort postMealInputPort, GetMealInputPort getMealInputPort) {
        this.postMealInputPort = postMealInputPort;
        this.getMealInputPort = getMealInputPort;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Meal> create(@RequestBody MealPostRequest mealPostRequest) {
        Meal meal = postMealInputPort.create(
                mealPostRequest.getDescription(),
                mealPostRequest.getUserId(),
                mealPostRequest.getMealType());
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(meal.getMealId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Meal> getById(@PathVariable UUID id) {
        Meal meal = getMealInputPort.getById(id);
        return ResponseEntity.ok(meal);
    }
}