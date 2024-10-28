package com.sabin.rockband_song_manager.exceptions;

import lombok.Data;

@Data
public class SongNotFoundException extends RuntimeException {

    public SongNotFoundException(String message) {
        super(message);
    }
}
