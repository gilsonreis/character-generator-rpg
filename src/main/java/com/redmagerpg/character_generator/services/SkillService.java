package com.redmagerpg.character_generator.services;

import com.redmagerpg.character_generator.entities.Skill;
import com.redmagerpg.character_generator.repositories.SkillRepository;
import com.redmagerpg.character_generator.dto.SkillDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillService {
    private final SkillRepository skillRepository;

    public SkillService(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    public List<SkillDTO> getAllSkills()
    {
        List<Skill> skills = skillRepository.findAll();
        return skills.stream().map(SkillDTO::new).toList();
    }

    public SkillDTO getSkillById(Long id)
    {
        Skill skill = skillRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Skill not found"));

        return new SkillDTO(skill);
    }
}
