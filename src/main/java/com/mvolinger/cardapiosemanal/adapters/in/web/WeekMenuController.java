package com.mvolinger.cardapiosemanal.adapters.in.web;

import com.mvolinger.cardapiosemanal.adapters.in.web.dtos.WeekMenuPostRequest;
import com.mvolinger.cardapiosemanal.core.domain.models.WeekMenu;
import com.mvolinger.cardapiosemanal.core.port.in.DeleteWeekMenuInputPort;
import com.mvolinger.cardapiosemanal.core.port.in.GetWeekMenuInputPort;
import com.mvolinger.cardapiosemanal.core.port.in.PatchWeekMenuInputPort;
import com.mvolinger.cardapiosemanal.core.port.in.PostWeekMenuInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/menus")
public class WeekMenuController {

    private final PostWeekMenuInputPort postWeekMenuInputPort;
    private final GetWeekMenuInputPort getWeekMenuInputPort;
    private final PatchWeekMenuInputPort patchWeekMenuInputPort;
    private final DeleteWeekMenuInputPort deleteWeekMenuInputPort;

    @Autowired
    public WeekMenuController(
            PostWeekMenuInputPort postWeekMenuInputPort,
            GetWeekMenuInputPort getWeekMenuInputPort,
            PatchWeekMenuInputPort patchWeekMenuInputPort,
            DeleteWeekMenuInputPort deleteWeekMenuInputPort) {
        this.postWeekMenuInputPort = postWeekMenuInputPort;
        this.getWeekMenuInputPort = getWeekMenuInputPort;
        this.patchWeekMenuInputPort = patchWeekMenuInputPort;
        this.deleteWeekMenuInputPort = deleteWeekMenuInputPort;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<WeekMenu> create(@RequestBody WeekMenuPostRequest weekMenuPostRequest) {
        WeekMenu weekMenu = postWeekMenuInputPort.create(
                weekMenuPostRequest.getDescription(),
                weekMenuPostRequest.getUserId());
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(weekMenu.getWeekMenuId())
                .toUri();
        return ResponseEntity.created(uri).body(weekMenu);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<WeekMenu> getOne(@PathVariable UUID id) {
        return ResponseEntity.ok(getWeekMenuInputPort.getOne(id));
    }

    @GetMapping("/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<WeekMenu>> geListByUserId(@PathVariable UUID userId) {
        return ResponseEntity.ok(getWeekMenuInputPort.getByUserId(userId));
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<WeekMenu> update(
            @PathVariable UUID id,
            @RequestBody WeekMenuPostRequest weekMenuPostRequest) {
        return ResponseEntity.ok(patchWeekMenuInputPort
                .update(id, weekMenuPostRequest.getDescription(), weekMenuPostRequest.getUserId()));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        deleteWeekMenuInputPort.delete(id);
    }
}