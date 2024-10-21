package com.redmagerpg.character_generator.repositories;

import com.redmagerpg.character_generator.entities.CharacterSpecies;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterSpeciesRepository extends JpaRepository<CharacterSpecies, Long> {
}
