package com.sabin.rockband_song_manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.*")
public class RockbandSongManagerApplication {


	public static void main(String[] args) {

		SpringApplication.run(RockbandSongManagerApplication.class, args);
	}

}
