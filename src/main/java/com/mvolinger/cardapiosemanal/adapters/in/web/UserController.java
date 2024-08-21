package com.mvolinger.cardapiosemanal.adapters.in.web;

import com.mvolinger.cardapiosemanal.adapters.in.web.dtos.UserPostRequest;
import com.mvolinger.cardapiosemanal.adapters.in.web.mapper.UserDTOMapper;
import com.mvolinger.cardapiosemanal.core.domain.models.User;
import com.mvolinger.cardapiosemanal.core.port.in.GetUserInputPort;
import com.mvolinger.cardapiosemanal.core.port.in.PostUserInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final PostUserInputPort postUserInputPort;
    private final GetUserInputPort getUserInputPort;

    @Autowired
    public UserController(PostUserInputPort postUserInputPort, GetUserInputPort getUserInputPort) {
        this.postUserInputPort = postUserInputPort;
        this.getUserInputPort = getUserInputPort;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<User> create(@RequestBody UserPostRequest userPostRequest) {
        User user = UserDTOMapper.toModel(userPostRequest);
        User userCreated = postUserInputPort.create(user);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(userCreated.getUserId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<User> getById(@PathVariable UUID id) {
        User user = getUserInputPort.getById(id);
        return ResponseEntity.ok(user);
    }
}