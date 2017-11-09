package com.project.lookify.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Range;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Song{
	@Id
	@GeneratedValue
	private long id;
	@Size(min=2, max=255)
	private String title;
	@Range(min=1, max=10)
	private int rating;
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="artist_id")
	private Artist artist;

	// Member variables and annotations go here.
	
	@DateTimeFormat(pattern="MM:dd:yyyy HH:mm:ss")
	private Date createdAt;
	
	@DateTimeFormat(pattern="MM:dd:yyyy HH:mm:ss")
	private Date updatedAt;

	@PrePersist
	public void onCreate(){this.createdAt = new Date();}
	@PreUpdate
	public void onUpdate(){this.updatedAt = new Date();}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public void setTitle(String title){
		this.title = title;
	}
	public void setRating(int rating){
		this.rating = rating;
	}
	public String getTitle(){
		return title;
	}
	public int getRating(){
		return rating;
	}
	public Artist getArtist(){
		return artist;
	}
	
	// Setters and Getters go here

	public Song(){}
	
	public Song(String tile, int rating, Artist artist){
		this.title = tile;
		this.rating = rating;
		this.artist = artist;
		this.createdAt = new Date();
		this.updatedAt = new Date();
	}
}
