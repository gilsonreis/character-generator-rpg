package com.redmagerpg.character_generator.repositories;

import com.redmagerpg.character_generator.entities.CharacterClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterClassRepository extends JpaRepository<CharacterClass, Long> {
}
