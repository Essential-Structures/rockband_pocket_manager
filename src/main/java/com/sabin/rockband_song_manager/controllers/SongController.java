package com.sabin.rockband_song_manager.controllers;

import com.sabin.rockband_song_manager.models.DTOs.SongDTO;
import com.sabin.rockband_song_manager.models.DTOs.SongNameDTO;
import com.sabin.rockband_song_manager.services.SongServiceable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/songs")
@RestController
public class SongController {


    @Autowired
    private final SongServiceable songService;

    public SongController(SongServiceable songService) {
        this.songService = songService;
    }

    @PostMapping
    public ResponseEntity<SongDTO> persistSongsMetadata(@RequestBody SongDTO songToPersist) {
        return new ResponseEntity<>(songService.saveSong(songToPersist), HttpStatus.OK);
    }

    @GetMapping("/{songName}")
    public ResponseEntity<List<SongDTO>> retrieveSongBySpecs(
            @RequestParam(value = "songName", required = false) String songName,
            @RequestParam(value = "yearOfRelease", required = false) Short yearOfRelease) {

        return ResponseEntity.ok(songService.getSongsByCriteria(songName, yearOfRelease));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<SongDTO> updateSongName(@RequestBody SongNameDTO newSongName,
                                                  @PathVariable("id") Short id) {
        return new ResponseEntity<>(songService.updateSongName(id, newSongName.getNewSongName()),
                HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSongbyId(@PathVariable Short id) {
        songService.deleteSongById(id);
        return ResponseEntity.noContent().build();

    }
}

