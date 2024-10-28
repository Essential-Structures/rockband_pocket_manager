package com.sabin.rockband_song_manager.unit_tests.mock_injection;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sabin.rockband_song_manager.models.DTOs.SongDTO;
import com.sabin.rockband_song_manager.models.entitties.SongEntity;
import com.sabin.rockband_song_manager.repository.SongRepository;
import com.sabin.rockband_song_manager.services.SongServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SongServiceImplTest {

    @Mock
    private ObjectMapper objectMapper;

    @Mock
    private SongRepository songRepository;

    @InjectMocks
    private SongServiceImpl songService;


    @Test
    void testSaveSong() {
        //given
        SongDTO songDTO = new SongDTO();
        songDTO.setTitle("Test Title");
        songDTO.setComposer("Test Composer");

        SongEntity songEntity = new SongEntity();
        songEntity.setID(1);
        songEntity.setName("Test Name");
        songEntity.setComposer("Test Composer");

        when(objectMapper.convertValue(songDTO, SongEntity.class)).thenReturn(songEntity);
        when(songRepository.save(songEntity)).thenReturn(songEntity);
        when(objectMapper.convertValue(songEntity, SongDTO.class)).thenReturn(songDTO);

        //when
        SongDTO savedSongDTO = songService.saveSong(songDTO);

        //then
        verify(songRepository, Mockito.times(1)).save(songEntity);
        assertEquals(songDTO.getComposer(), savedSongDTO.getComposer());
        assertEquals(songDTO.getTitle(), savedSongDTO.getTitle());
    }


}