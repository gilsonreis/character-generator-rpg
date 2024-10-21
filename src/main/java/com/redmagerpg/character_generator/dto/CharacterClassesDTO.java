package com.redmagerpg.character_generator.dto;

import com.redmagerpg.character_generator.entities.CharacterClass;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CharacterClassesDTO {
    private Long id;
    private String name;
    private String description;

    public CharacterClassesDTO(CharacterClass characterClass) {
        this.id = characterClass.getId();
        this.name = characterClass.getName();
        this.description = characterClass.getDescription();
    }
}
