package com.sabin.rockband_song_manager.models.DTOs;

import lombok.Data;

@Data
public class SongDTO {
    private String title;
    private String composer;
    private Short yearOfRelease;
}
