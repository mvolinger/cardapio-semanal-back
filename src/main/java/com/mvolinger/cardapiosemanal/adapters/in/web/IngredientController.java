package com.mvolinger.cardapiosemanal.adapters.in.web;

import com.mvolinger.cardapiosemanal.adapters.in.web.dtos.IngredientPostRequest;
import com.mvolinger.cardapiosemanal.adapters.in.web.mapper.IngredientDTOMapper;
import com.mvolinger.cardapiosemanal.core.domain.models.Ingredient;
import com.mvolinger.cardapiosemanal.core.port.in.GetIngredientInputPort;
import com.mvolinger.cardapiosemanal.core.port.in.PostIngredientInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/api/ingredients")
public class IngredientController {

    private final PostIngredientInputPort postIngredientInputPort;
    private final GetIngredientInputPort getIngredientInputPort;

    @Autowired
    public IngredientController(PostIngredientInputPort postIngredientInputPort, GetIngredientInputPort getIngredientInputPort) {
        this.postIngredientInputPort = postIngredientInputPort;
        this.getIngredientInputPort = getIngredientInputPort;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Ingredient> create(@RequestBody IngredientPostRequest ingredientPostRequest) {
        Ingredient ingredient = IngredientDTOMapper.toModel(ingredientPostRequest);
        Ingredient ingredientCreated = postIngredientInputPort.create(ingredient);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(ingredientCreated.getIngredientId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Ingredient> getById(@PathVariable UUID id) {
        Ingredient ingredient = getIngredientInputPort.getById(id);
        return ResponseEntity.ok(ingredient);
    }
}