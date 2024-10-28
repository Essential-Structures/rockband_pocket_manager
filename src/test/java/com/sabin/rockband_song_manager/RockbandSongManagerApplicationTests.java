package com.sabin.rockband_song_manager;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class RockbandSongManagerApplicationTests {

	@Test
	void contextLoads() {
	}

}
