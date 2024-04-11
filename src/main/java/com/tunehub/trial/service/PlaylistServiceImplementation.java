package com.tunehub.trial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tunehub.trial.entity.Playlist;
import com.tunehub.trial.repository.PlaylistRepository;

@Service
public class PlaylistServiceImplementation implements PlaylistService {

	@Autowired
	PlaylistRepository repo;
	@Override
	public void addPlaylist(Playlist playlist) {
		// TODO Auto-generated method stub
		repo.save(playlist);
	}
	
	@Override
	public List<Playlist> fetchAllPlaylist() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

}
