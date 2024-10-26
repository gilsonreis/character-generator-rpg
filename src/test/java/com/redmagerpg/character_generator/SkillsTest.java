package com.redmagerpg.character_generator;

import com.redmagerpg.character_generator.dto.SkillDTO;
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
public class SkillsTest {

    @Autowired
    protected TestRestTemplate restTemplate;

    private ResponseEntity<List<SkillDTO>> getSkills() {
        return restTemplate.exchange(
                "/api/v1/skills",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<SkillDTO>>() {});
    }

    private ResponseEntity<SkillDTO> getSkillsById(Long id) {
        return restTemplate.getForEntity("/api/v1/skills/" + id, SkillDTO.class);
    }

    @Test
    public void shouldReturnFiveSkills() {
        assertEquals("should return 5 skills", 5, Objects.requireNonNull(getSkills().getBody()).size());
    }

    @Test
    public void shouldReturnDeityByID() {
        ResponseEntity<SkillDTO> responseSkillAcrobatic = getSkillsById(1L);
        SkillDTO skillAcrobatic = responseSkillAcrobatic.getBody();
        assertEquals("should return acrobatic skill", "Acrobacia", skillAcrobatic.getName());

        ResponseEntity<SkillDTO> responseSkillAlchemy = getSkillsById(2L);
        SkillDTO skillAlchemy = responseSkillAlchemy.getBody();
        assertEquals("should return alchemy skill", "Alquimia", skillAlchemy.getName());

        ResponseEntity<SkillDTO> responseSkillArcana = getSkillsById(3L);
        SkillDTO skillArcana = responseSkillArcana.getBody();
        assertEquals("should return arcana skill", "Arcanismo", skillArcana.getName());

        ResponseEntity<SkillDTO> responseSkillAstronomy = getSkillsById(4L);
        SkillDTO skillAstronomy = responseSkillAstronomy.getBody();
        assertEquals("should return astronomy skill", "Astronomia", skillAstronomy.getName());

        ResponseEntity<SkillDTO> responseSkillAthletics = getSkillsById(5L);
        SkillDTO skillAthletics = responseSkillAthletics.getBody();
        assertEquals("should return athletics skill", "Atletismo", skillAthletics.getName());
    }
}
