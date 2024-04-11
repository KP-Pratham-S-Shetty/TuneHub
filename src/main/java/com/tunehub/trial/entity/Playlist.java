package com.tunehub.trial.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinColumn;

@Entity
public class Playlist {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String name;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
	    name = "playlist_song",
	    joinColumns = @JoinColumn(name = "playlist_id"),
	    inverseJoinColumns = @JoinColumn(name = "song_id")
	)
	List<Song> songs;
	
    public Playlist() {
    	super();
    	songs = new ArrayList<>();
    }
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Song> getSong() {
		return songs;
	}
	public void setSong(List<Song> songs) {
		this.songs = songs;
	}
	@Override
	public String toString() {
		return "Playlist [id=" + id + ", name=" + name + ", song=" + songs + "]";
	}
	public Playlist(int id, String name, List<Song> songs) {
		super();
		this.id = id;
		this.name = name;
		this.songs = songs;
	}

	

}
