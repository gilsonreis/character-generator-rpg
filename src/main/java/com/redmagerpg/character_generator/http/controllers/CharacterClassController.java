package com.redmagerpg.character_generator.http.controllers;

import com.redmagerpg.character_generator.dto.CharacterClassesDTO;
import com.redmagerpg.character_generator.services.CharacterClassService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/classes")
public class CharacterClassController {


    private final CharacterClassService characterClassService;

    public CharacterClassController(CharacterClassService CharacterClassService) {
        this.characterClassService = CharacterClassService;
    }

    @GetMapping()
    public ResponseEntity<List<CharacterClassesDTO>> getClasses() {
        List<CharacterClassesDTO> classesList = characterClassService.getAllClasses();

        return ResponseEntity.ok(classesList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CharacterClassesDTO> getClassById(@PathVariable Integer id) {
        CharacterClassesDTO classesDTO = characterClassService.getClassById(id);

        return ResponseEntity.ok(classesDTO);
    }

}
