package com.project.lookify.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import com.project.lookify.models.Artist;
import com.project.lookify.models.Song;
import com.project.lookify.repositories.ArtistRepository;
import com.project.lookify.repositories.SongRepository;

@Service
public class LookifyService {
	private SongRepository songRepository;
	private ArtistRepository artistRepository;
		
	public LookifyService(SongRepository songRepository, ArtistRepository artistRepository){
		this.songRepository = songRepository;
		this.artistRepository = artistRepository;
	}
	
	public List<Artist> getAllArtists(){
		return (List<Artist>) artistRepository.findAll();
	}
	public List<Song> getAllSongs(){
		return (List<Song>) songRepository.findAll();
	}
	public Artist createArtist(Artist artist){
		artistRepository.save(artist);
		return artist;
	}
	public void createSong(Song song){
		songRepository.save(song);
	}
	public Artist getArtist(long id){
		return artistRepository.findOne(id);
	}
	public Song getSong(long id){
		return songRepository.findOne(id);
	}
	public Artist getArtistByName(String name){
		return artistRepository.getArtistByName(name);
	}
	public void updateArtist(Artist artist){
		artistRepository.save(artist);
	}
	public List<Song> getTop10(){
		return songRepository.findTop10ByOrderByRatingDesc();
	}
	public void deleteSong(long id){
		songRepository.delete(id);
	}
}
