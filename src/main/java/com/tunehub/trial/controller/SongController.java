package com.tunehub.trial.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.tunehub.trial.entity.Song;
import com.tunehub.trial.service.SongService;

@Controller
public class SongController {

	@Autowired
	SongService service;

	@PostMapping("/addSong")
	public String addSong(@ModelAttribute Song song) {
		boolean song_status=service.songExists(song.getName());

		if(!song_status) {
			service.addSong(song);
			System.out.println( "Song Added Successfully");
		}else 
			System.out.println("Duplicate Found");

		return "adminHome";
	}


	@GetMapping("/viewSong")
	public String viewSong(Model model) {
		List<Song> songList=service.fetchAllSongs();
		model.addAttribute("Songs", songList);
		return "displaySongs";
	}
	
	@GetMapping("/playSongs")
	public String playSongs(Model model) {
		boolean premiumUser=false;
		if(premiumUser==true) {
			List<Song> songList=service.fetchAllSongs();
			System.out.println(songList);
			model.addAttribute("Songs", songList);
			return "displaySongs";
		}else
			return "makePayment";
		
		
		
	}
}
