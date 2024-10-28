package com.sabin.rockband_song_manager.data_filters;

import com.sabin.rockband_song_manager.models.entitties.SongEntity;
import org.springframework.data.jpa.domain.Specification;

public class SongSpecifications {

    public static Specification<SongEntity> titleSearch (String titleName){
        return (root, query, criteriaBuilder)-> (titleName == null ? null :
                criteriaBuilder.like(criteriaBuilder.lower(root.get("song_name")),"%"+titleName.toLowerCase()+"%" ));
    }

    public static Specification<SongEntity> yearOfReleaseSearch (Short yearOfRelease){
        return (root, query, criteriaBuilder)->(yearOfRelease==null? null:
                criteriaBuilder.like(root.get("year_of_release"), "%"+ yearOfRelease +"%"));

    }

}