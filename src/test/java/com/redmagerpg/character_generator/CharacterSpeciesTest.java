package com.redmagerpg.character_generator;

import com.redmagerpg.character_generator.dto.CharacterSpeciesDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Objects;

import static org.springframework.test.util.AssertionErrors.assertEquals;

@SpringBootTest(classes = CharacterGeneratorApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CharacterSpeciesTest {

    @Autowired
    protected TestRestTemplate restTemplate;

    private ResponseEntity<List<CharacterSpeciesDTO>> getSpecies() {
        return restTemplate.exchange(
                "/api/v1/species",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<CharacterSpeciesDTO>>() {});
    }

    private ResponseEntity<CharacterSpeciesDTO> getSpeciesById(Long id) {
        return restTemplate.getForEntity("/api/v1/species/" + id, CharacterSpeciesDTO.class);
    }

    @Test
    public void shouldReturnThreeSpecies() {
        assertEquals("should return 3 species", 3, Objects.requireNonNull(getSpecies().getBody()).size());
    }

    @Test
    public void shouldReturnHumanSpecies() {
        ResponseEntity<CharacterSpeciesDTO> responseHuman = getSpeciesById(3L);
        CharacterSpeciesDTO humanSpecies = responseHuman.getBody();
        assertEquals("should return human species", "Humanos", humanSpecies.getName());

        ResponseEntity<CharacterSpeciesDTO> responseDwarf = getSpeciesById(1L);
        CharacterSpeciesDTO dwarfSpecies = responseDwarf.getBody();
        assertEquals("should return dwarf species", "Anões", dwarfSpecies.getName());

        ResponseEntity<CharacterSpeciesDTO> responseElf = getSpeciesById(2L);
        CharacterSpeciesDTO elfSpecies = responseElf.getBody();
        assertEquals("should return Elf species", "Elfos", elfSpecies.getName());
    }
}
