package com.redmagerpg.character_generator.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "deities")
public class Deity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    @Lob
    private String description;

    @Column(columnDefinition = "MEDIUMTEXT")
    private String proficiency;

    public Deity() {
    }

    public Deity(String name, String description, String proficiency) {
        this.name = name;
        this.description = description;
        this.proficiency = proficiency;
    }
}
