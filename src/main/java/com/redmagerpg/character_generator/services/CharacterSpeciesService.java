package com.redmagerpg.character_generator.services;

import com.redmagerpg.character_generator.dto.CharacterSpeciesDTO;
import com.redmagerpg.character_generator.entities.CharacterSpecies;
import com.redmagerpg.character_generator.repositories.CharacterSpeciesRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterSpeciesService {

    private final CharacterSpeciesRepository characterSpeciesRepository;

    public CharacterSpeciesService(CharacterSpeciesRepository characterSpeciesRepository) {
        this.characterSpeciesRepository = characterSpeciesRepository;
    }

    public List<CharacterSpeciesDTO> getAllSpecies() {
        List<CharacterSpecies> speciesList = characterSpeciesRepository.findAll();
        return speciesList.stream().map(CharacterSpeciesDTO::new).toList();
    }

    public CharacterSpeciesDTO getSpeciesById(long id) {
        CharacterSpecies species = characterSpeciesRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Character Species with id " + id + " not found"));

        return new CharacterSpeciesDTO(species);
    }
}
