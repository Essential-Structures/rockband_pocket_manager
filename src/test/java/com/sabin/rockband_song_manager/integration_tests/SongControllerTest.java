package com.sabin.rockband_song_manager.integration_tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sabin.rockband_song_manager.models.DTOs.SongDTO;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@Slf4j
@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@Transactional
@AutoConfigureTestDatabase
class SongControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testCreateBookShouldPass() throws Exception {
        SongDTO songDTO = new SongDTO();
        songDTO.setTitle("test title");
        songDTO.setComposer("test composer");

        mockMvc.perform(post("/api/songs")
                        .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(songDTO)))
                .andExpect(status().isOk());
    }
}

