package com.joaogabriel.dotaApi.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Controller
@RequestMapping(value = "/health", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Application Status.", description = "Provides Application Health" )
public class HealthController {
    @GetMapping
    public ResponseEntity<Void> getHealthInformation() {
        return ResponseEntity.ok(null);
    }
}
