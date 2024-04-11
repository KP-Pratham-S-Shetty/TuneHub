package com.tunehub.trial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tunehub.trial.entity.Song;
import com.tunehub.trial.repository.SongRepository;

@Service
public class SongServiceImplementation implements SongService {
	@Autowired
	SongRepository repo;

	@Override
	public void addSong(Song song) {
		// TODO Auto-generated method stub
		repo.save(song);
	}

	@Override
	public List<Song> fetchAllSongs() {
		return repo.findAll();
	}

	@Override
	public boolean songExists(String songName) {
		Song song=repo.findByName(songName);
		if(song==null) 
			return false;
		else 
			return true;
	}

	@Override
	public void updateSong(Song song) {
		repo.save(song);
	}


}
