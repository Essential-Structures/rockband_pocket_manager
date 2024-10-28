package com.sabin.rockband_song_manager.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sabin.rockband_song_manager.data_filters.SongSpecifications;
import com.sabin.rockband_song_manager.exceptions.SongNotFoundException;
import com.sabin.rockband_song_manager.models.DTOs.SongDTO;
import com.sabin.rockband_song_manager.models.entitties.SongEntity;
import com.sabin.rockband_song_manager.repository.SongRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;


import java.util.List;

@Slf4j
@Service
public class SongServiceImpl implements SongServiceable {

        @Autowired
    private final SongRepository repository;
    private final ObjectMapper objectMapper;

    public SongServiceImpl(SongRepository repository, ObjectMapper objectMapper) {
        this.repository = repository;
        this.objectMapper = objectMapper;
    }

    @Override
    public SongDTO saveSong(SongDTO songDTOtoPersist) {
        SongEntity entittyToPersist =
                objectMapper.convertValue(songDTOtoPersist, SongEntity.class);
        SongEntity saved = repository.save(entittyToPersist);
        log.info("We just persisted: {}", saved.toString());
        return objectMapper.convertValue(saved, SongDTO.class);
    }


    @Override
    public List<SongDTO> getSongsByCriteria(String title, Short yearOfRelease) {
        Specification<SongEntity> specs = Specification.
                where(SongSpecifications.titleSearch(title)).
                and(SongSpecifications.yearOfReleaseSearch(yearOfRelease));

        List<SongEntity> songsByCriteria = repository.findAll(specs);
        log.info("Retrieved list of entries from database picked by criteria");

        return songsByCriteria.stream().
                map(songEntity -> objectMapper.convertValue(songEntity, SongDTO.class))
                .toList();
    }

    @Override
    public SongDTO updateSongName(Short id, String newSongName) {
        SongEntity songToUpdate =repository.findById(id).
                orElseThrow(()->new SongNotFoundException("Song not found"));

        songToUpdate.setName(newSongName);
        SongEntity updatedSong = repository.save(songToUpdate);
        log.info("Updated name in song with id {}",id);

        return objectMapper.convertValue(updatedSong, SongDTO.class);
    }

    @Override
    public void deleteSongById(Short id) {
        repository.findById(id).orElseThrow(
                ()->new SongNotFoundException("Song with id "+id+" set to delete not found in database"));

        repository.deleteById(id);
        log.info("Successfully deleted song with id {}",id);
    }
}

