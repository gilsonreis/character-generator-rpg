package com.redmagerpg.character_generator.dto;

import com.redmagerpg.character_generator.entities.Deity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DeityDTO {

    private Long id;
    private String name;
    private String description;
    private String proficiency;

    public DeityDTO(Deity deity) {
        this.id = deity.getId();
        this.name = deity.getName();
        this.description = deity.getDescription();
        this.proficiency = deity.getProficiency();
    }

}
