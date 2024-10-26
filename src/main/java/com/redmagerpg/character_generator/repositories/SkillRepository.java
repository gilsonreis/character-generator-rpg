package com.redmagerpg.character_generator.repositories;

import com.redmagerpg.character_generator.entities.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skill, Long> {
}
