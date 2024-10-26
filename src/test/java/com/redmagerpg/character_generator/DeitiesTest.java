package com.redmagerpg.character_generator;

import com.redmagerpg.character_generator.dto.DeityDTO;
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
public class DeitiesTest {

    @Autowired
    protected TestRestTemplate restTemplate;

    private ResponseEntity<List<DeityDTO>> getDeities() {
        return restTemplate.exchange(
                "/api/v1/deities",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<DeityDTO>>() {});
    }

    private ResponseEntity<DeityDTO> getDeitiesById(Long id) {
        return restTemplate.getForEntity("/api/v1/deities/" + id, DeityDTO.class);
    }

    @Test
    public void shouldReturnThreeDeities() {
        assertEquals("should return 3 deities", 3, Objects.requireNonNull(getDeities().getBody()).size());
    }

    @Test
    public void shouldReturnDeityByID() {
        ResponseEntity<DeityDTO> responseCelestialDeity = getDeitiesById(1L);
        DeityDTO celestialDeity = responseCelestialDeity.getBody();
        assertEquals("should return celestial deity", "Thalorin, o Forjador Celestial", celestialDeity.getName());

        ResponseEntity<DeityDTO> responseNeutralDeity = getDeitiesById(2L);
        DeityDTO neutralDeity = responseNeutralDeity.getBody();
        assertEquals("should return neutral deity", "Lunara, a Guardiã da Natureza", neutralDeity.getName());

        ResponseEntity<DeityDTO> responseDarknessDeity = getDeitiesById(3L);
        DeityDTO darknessDeity = responseDarknessDeity.getBody();
        assertEquals("should return darkness deity", "Tharok, o Senhor das Tempestades", darknessDeity.getName());
    }
}
