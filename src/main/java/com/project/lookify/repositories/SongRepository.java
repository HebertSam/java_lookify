package com.project.lookify.repositories;

import com.project.lookify.models.Song;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository 												
public interface SongRepository extends CrudRepository<Song,Long>{
	public List<Song> findTop10ByOrderByRatingDesc();
}
