package com.tunehub.trial.service;

import java.util.List;

import com.tunehub.trial.entity.Playlist;

public interface PlaylistService {

	public void addPlaylist(Playlist playlist);

	public List<Playlist> fetchAllPlaylist();

}
