package com.redmagerpg.character_generator.services;

import com.redmagerpg.character_generator.dto.DeityDTO;
import com.redmagerpg.character_generator.entities.Deity;
import com.redmagerpg.character_generator.repositories.DeityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeityService {
    private final DeityRepository deityRepository;

    public DeityService(DeityRepository deityRepository1) {
        this.deityRepository = deityRepository1;
    }

    public List<DeityDTO> getAllDeitys() {
        List<Deity> deityList = deityRepository.findAll();
        return deityList.stream().map(DeityDTO::new).toList();
    }

    public DeityDTO getDeityById(Long id) {
        Deity deity = deityRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Deity not found"));

        return new DeityDTO(deity);

    }
}
