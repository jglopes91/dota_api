package com.joaogabriel.dotaApi.controller;

import com.joaogabriel.dotaApi.dto.hero.HeroListAPIResponseDTO;
import com.joaogabriel.dotaApi.service.HeroService;
import io.swagger.v3.oas.annotations.OpenAPI31;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Controller
@RequestMapping(value = "/heroes")
@Tag(name = "Hero", description = "Hero Controller" )
public class HeroController {
    private final HeroService heroService;
    public HeroController(final HeroService heroService) {
        this.heroService = heroService;
    }

    @Operation(summary = "Get Heros List")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returns list of all dota characters."),
            @ApiResponse(responseCode = "500", description = "Return RuntimeException from Dota API."),
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getHeroList() {
        return ResponseEntity.ok(heroService.findAllHeros());
    }

    @Operation(summary = "Get Hero By Name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Return character when founded by name."),
            @ApiResponse(responseCode = "500", description = "Return RuntimeException from Dota API."),
    })
    @GetMapping(value = "/{heroName}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getHeroListByName(@PathVariable("heroName") String name) {
        return ResponseEntity.ok(heroService.findHerosByName(name));
    }
}
