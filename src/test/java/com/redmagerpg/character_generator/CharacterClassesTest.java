package com.redmagerpg.character_generator;

import com.redmagerpg.character_generator.dto.CharacterClassesDTO;
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
public class CharacterClassesTest {

    @Autowired
    protected TestRestTemplate restTemplate;

    private ResponseEntity<List<CharacterClassesDTO>> getClasses() {
        return restTemplate.exchange(
                "/api/v1/classes",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<CharacterClassesDTO>>() {});
    }

    private ResponseEntity<CharacterClassesDTO> getClassesById(Long id) {
        return restTemplate.getForEntity("/api/v1/classes/" + id, CharacterClassesDTO.class);
    }

    @Test
    public void shouldReturnFourSpecies() {
        assertEquals("should return 4 classes", 4, Objects.requireNonNull(getClasses().getBody()).size());
    }

    @Test
    public void shouldReturnHumanSpecies() {
        ResponseEntity<CharacterClassesDTO> responseBard = getClassesById(1L);
        CharacterClassesDTO bardClass = responseBard.getBody();
        assertEquals("should return bard class", "Bardo", bardClass.getName());

        ResponseEntity<CharacterClassesDTO> respondeWarrior = getClassesById(2L);
        CharacterClassesDTO warriorClass = respondeWarrior.getBody();
        assertEquals("should return warrior class", "Guerreiro", warriorClass.getName());

        ResponseEntity<CharacterClassesDTO> responseRogue = getClassesById(3L);
        CharacterClassesDTO rogueClass = responseRogue.getBody();
        assertEquals("should return rogue class", "Ladino", rogueClass.getName());

        ResponseEntity<CharacterClassesDTO> responseMage = getClassesById(4L);
        CharacterClassesDTO mageClass = responseMage.getBody();
        assertEquals("should return mage class", "Mago", mageClass.getName());
    }
}
