package com.sabin.rockband_song_manager;

import org.springframework.boot.SpringApplication;

public class TestRockbandSongManagerApplication {

	public static void main(String[] args) {
		SpringApplication.from(RockbandSongManagerApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
