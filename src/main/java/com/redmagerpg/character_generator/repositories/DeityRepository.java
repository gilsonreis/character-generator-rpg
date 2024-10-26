package com.redmagerpg.character_generator.repositories;

import com.redmagerpg.character_generator.entities.Deity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeityRepository extends JpaRepository<Deity, Long> { }
