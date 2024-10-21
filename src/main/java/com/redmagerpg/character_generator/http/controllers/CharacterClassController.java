package com.redmagerpg.character_generator.http.controllers;

import com.redmagerpg.character_generator.entities.CharacterClass;
import com.redmagerpg.character_generator.services.CharacterClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/classes")
public class CharacterClassController {

    @Autowired
    private CharacterClassService CharacterClassService;

    @GetMapping()
    public ResponseEntity getClasses() {
        List<CharacterClass> classesList = CharacterClassService.getAllClasses();

        return ResponseEntity.ok(classesList);
    }
}
