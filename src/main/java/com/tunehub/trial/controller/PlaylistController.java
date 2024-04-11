package com.tunehub.trial.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.tunehub.trial.entity.Playlist;
import com.tunehub.trial.entity.Song;
import com.tunehub.trial.service.PlaylistService;
import com.tunehub.trial.service.SongService;

import jakarta.transaction.Transactional;

import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class PlaylistController {

	@Autowired
	SongService songservice;
	@Autowired
	PlaylistService playlistservice;

	@GetMapping("/createPlaylist")
	public String createPlaylist(Model model) {

		List<Song> songList=songservice.fetchAllSongs();
		
		model.addAttribute("songs", songList);
		return "createPlaylist";
	}
	@Transactional
	@PostMapping("addPlaylist")
	public String addPlaylist(@ModelAttribute Playlist playlist) {
		//TODO: process POST request
		System.out.println(playlist);
		playlistservice.addPlaylist(playlist);

		List<Song> songList=playlist.getSong();
		
		
		for(Song s:songList) {
			s.getPlaylists().add(playlist);
			songservice.updateSong(s);
			System.out.println( s.getPlaylists());

		}
		return "adminHome";
	}
	
	@GetMapping("viewPlayList")
	public String viewPlayList(Model model) {
		List<Playlist> allPlaylists=playlistservice.fetchAllPlaylist();
		System.out.println(allPlaylists);
		model.addAttribute("allplaylist", allPlaylists);
		return "viewPlayList";
	}
	


}
