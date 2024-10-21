package com.redmagerpg.character_generator.services;

import com.redmagerpg.character_generator.dto.CharacterClassesDTO;
import com.redmagerpg.character_generator.entities.CharacterClass;
import com.redmagerpg.character_generator.repositories.CharacterClassRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterClassService {

    private final CharacterClassRepository characterClassRepository;

    public CharacterClassService(CharacterClassRepository characterClassRepository) {
        this.characterClassRepository = characterClassRepository;
    }

    public List<CharacterClassesDTO> getAllClasses() {
        List<CharacterClass> classList = characterClassRepository.findAll();

        return classList.stream().map(CharacterClassesDTO::new).toList();
    }

    public CharacterClassesDTO getClassById(long id) {
        CharacterClass characterClass = characterClassRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Character class with id " + id + " not found"));

        return new CharacterClassesDTO(characterClass);
    }

}
