package com.redmagerpg.character_generator.entities;

import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "skills")
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, columnDefinition = "MEDIUMTEXT")
    private String description;

    public Skill() {

    }
}
