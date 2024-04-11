package com.tunehub.trial.service;

import java.util.List;


import com.tunehub.trial.entity.Song;

public interface SongService {

	public void addSong(Song song);

	public List<Song> fetchAllSongs();

	public boolean songExists(String songName);
	
	public void updateSong(Song song);
	



}
