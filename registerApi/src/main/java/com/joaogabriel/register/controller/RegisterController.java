package com.joaogabriel.register.controller;

import com.joaogabriel.register.dto.UserRegistrationDTO;
import com.joaogabriel.register.service.RegisterService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Controller
@RequestMapping(value = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Register", description = "Register Application" )
public class RegisterController {
    private final RegisterService registerService;

    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }
    @Operation(summary = "Register new user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Return Http 201 Created when new user is register succefully"),
            @ApiResponse(responseCode = "500", description = "Return validation error"),
    })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> registerUser(@Valid @RequestBody final UserRegistrationDTO payload) {
        return new ResponseEntity<>(registerService.registerNewUser(payload),HttpStatus.CREATED);
    }
}
