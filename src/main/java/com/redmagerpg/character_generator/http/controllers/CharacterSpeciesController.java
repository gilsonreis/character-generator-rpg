package com.redmagerpg.character_generator.http.controllers;

import com.redmagerpg.character_generator.dto.CharacterSpeciesDTO;
import com.redmagerpg.character_generator.services.CharacterSpeciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/species")
public class CharacterSpeciesController {

    private final CharacterSpeciesService characterSpeciesService;

    public CharacterSpeciesController(CharacterSpeciesService characterSpeciesService) {
        this.characterSpeciesService = characterSpeciesService;
    }

    @GetMapping()
    public ResponseEntity<List<CharacterSpeciesDTO>> getSpecies() {
        List<CharacterSpeciesDTO> speciesList = characterSpeciesService.getAllSpecies();

        return ResponseEntity.ok(speciesList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CharacterSpeciesDTO> getSpeciesById(@PathVariable("id") Long id) {
        CharacterSpeciesDTO speciesDTO = characterSpeciesService.getSpeciesById(id);
        return ResponseEntity.ok(speciesDTO);
    }
}
