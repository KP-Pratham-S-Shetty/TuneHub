package com.tunehub.trial.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tunehub.trial.entity.Song;
import com.tunehub.trial.entity.Users;
import com.tunehub.trial.service.SongService;
import com.tunehub.trial.service.UsersService;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class UsersController {

	@Autowired
	UsersService service;
	
	@Autowired
	SongService songService;


	@PostMapping("/registration")
	public String addUsers(@ModelAttribute Users user) {
		//TODO: process POST request
		boolean user_status=service.emailExists(user.getEmail());

		if (!user_status) {
			service.addUser(user);
			System.out.println("User Added");
		}else {
			System.out.println("Duplicate Found");
			return "registration";
		}
		return "home";
	}

	@PostMapping("/validate")
	public String validate(@RequestParam("email") String email , @RequestParam("password") String pass, HttpSession session , Model model) {
		if(service.validateUser(email,pass)) {
			String role=service.getRole(email);

			session.setAttribute("email", email);

			if(role.equals("admin")) {
				return "adminHome";
			}else {
				Users u = service.getUser(email);
				boolean userStatus = u.isPremium();
				List<Song> songsList = songService.fetchAllSongs();
				model.addAttribute("songs", songsList);
				model.addAttribute("isPremium", userStatus);
				return "customerHome";
			}
				
		}else {
			return "login";
		}
	}

	@GetMapping("payCheck") public String pay(@RequestParam String email) {
		boolean paymentStatus=service.getPremium(email);

		if(paymentStatus==true) { 
			Users user=service.getUser(email);
			user.setPremium(true);
			service.updateUser(user);
		}

		return "login";
	}


	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "login";
	}



}
