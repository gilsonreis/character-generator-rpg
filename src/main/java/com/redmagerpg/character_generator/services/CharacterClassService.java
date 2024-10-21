package com.redmagerpg.character_generator.services;

import com.redmagerpg.character_generator.entities.CharacterClass;
import com.redmagerpg.character_generator.repositories.CharacterClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterClassService {

    @Autowired
    private CharacterClassRepository characterClassRepository;

    public List<CharacterClass> getAllClasses() {
        return characterClassRepository.findAll();
    }

}
