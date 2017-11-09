package com.project.lookify.repositories;

import com.project.lookify.models.Artist;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository 												
public interface ArtistRepository extends CrudRepository<Artist,Long>{
	public Artist getArtistByName(String name);
}
