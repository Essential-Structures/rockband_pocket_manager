package com.sabin.rockband_song_manager.services;

import com.sabin.rockband_song_manager.models.DTOs.SongDTO;

import java.util.List;

public interface SongServiceable {

    SongDTO saveSong(SongDTO songToPersist);

    SongDTO updateSongName(Short id, String newSongName);

    List<SongDTO> getSongsByCriteria(String title, Short yearOfRelease);

    void deleteSongById(Short id);
}