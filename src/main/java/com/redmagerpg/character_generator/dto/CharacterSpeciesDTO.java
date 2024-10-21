package com.redmagerpg.character_generator.dto;

import com.redmagerpg.character_generator.entities.CharacterSpecies;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CharacterSpeciesDTO {
    private Long id;
    private String name;
    private String description;

    public CharacterSpeciesDTO(CharacterSpecies characterSpecies) {
        this.id = characterSpecies.getId();
        this.name = characterSpecies.getName();
        this.description = characterSpecies.getDescription();
    }
}
