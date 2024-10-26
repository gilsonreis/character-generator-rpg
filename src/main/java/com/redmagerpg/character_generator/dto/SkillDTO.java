package com.redmagerpg.character_generator.dto;

import com.redmagerpg.character_generator.entities.Skill;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SkillDTO {

    private Long id;
    private String name;
    private String description;

    public SkillDTO(Skill skill) {
        this.id = skill.getId();
        this.name = skill.getName();
        this.description = skill.getDescription();
    }
}
