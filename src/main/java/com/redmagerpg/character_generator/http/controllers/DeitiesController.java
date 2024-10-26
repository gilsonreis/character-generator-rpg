package com.redmagerpg.character_generator.http.controllers;

import com.redmagerpg.character_generator.dto.DeityDTO;
import com.redmagerpg.character_generator.services.DeityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/deities")
public class DeitiesController {

    private final DeityService deityService;

    public DeitiesController(DeityService deityService) {
        this.deityService = deityService;
    }

    @GetMapping()
    public ResponseEntity<List<DeityDTO>> getDeities() {
        List<DeityDTO> deitiesList = deityService.getAllDeitys();
        return ResponseEntity.ok(deitiesList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeityDTO> getDeityById(@PathVariable Long id) {
        DeityDTO deityDTO = deityService.getDeityById(id);
        return ResponseEntity.ok(deityDTO);
    }

}
