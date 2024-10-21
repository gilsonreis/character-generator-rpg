package com.redmagerpg.character_generator.entities;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "character_species")
public class CharacterSpecies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "name")
    private String name;

    @Column(name = "description", nullable = false, columnDefinition = "MEDIUMTEXT")
    private String description;
}
