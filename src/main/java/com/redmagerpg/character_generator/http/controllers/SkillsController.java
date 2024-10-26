package com.redmagerpg.character_generator.http.controllers;

import com.redmagerpg.character_generator.services.SkillService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.redmagerpg.character_generator.dto.SkillDTO;

import java.util.List;

@RestController
@RequestMapping("/api/v1/skills")
public class SkillsController {

    private final SkillService skillService;

    public SkillsController(SkillService skillService) {
        this.skillService = skillService;
    }

    @GetMapping()
    public ResponseEntity<List<SkillDTO>> getAllSkills()
    {
        return ResponseEntity.ok(skillService.getAllSkills());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SkillDTO> getSkillById(@PathVariable Long id) {
        SkillDTO skillDTO = skillService.getSkillById(id);
        return ResponseEntity.ok(skillDTO);
    }
}
