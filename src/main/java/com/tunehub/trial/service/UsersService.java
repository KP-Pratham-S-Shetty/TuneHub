package com.tunehub.trial.service;

import com.tunehub.trial.entity.Users;

public interface UsersService {
	public String addUser(Users user);
	public boolean emailExists(String email);
	public boolean validateUser(String email,String pass);
	public String getRole(String email);
	public boolean getPremium(String email);
	public Users getUser(String email);
	public void updateUser(Users user);
}
