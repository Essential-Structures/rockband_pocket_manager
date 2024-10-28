package com.sabin.rockband_song_manager.repository;

import com.sabin.rockband_song_manager.models.entitties.SongEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends JpaRepository<SongEntity, Short>,
        JpaSpecificationExecutor<SongEntity> {
}