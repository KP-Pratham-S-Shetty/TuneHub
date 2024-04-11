package com.tunehub.trial.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tunehub.trial.entity.Users;
import com.tunehub.trial.repository.UsersRepository;

@Service
public class UserServiceImplementation implements UsersService {

	@Autowired
	UsersRepository repo;

	@Override
	public String addUser(Users user) {
		// TODO Auto-generated method stub
		repo.save(user);
		return "User Added Successfully";
	}

	@Override
	public boolean emailExists(String email) {
		if(repo.findByEmail(email)==null)
			return false;
		else
			return true;
	}

	@Override
	public boolean validateUser(String email,String pass) {
		Users user=repo.findByEmail(email);
		if(user==null) {
			return false;
		}
		String db_pass=user.getPassword();
		if(pass.equals(db_pass)) {
			return true;
		}
		return false;
	}

	@Override
	public String getRole(String email) {
		Users user=repo.findByEmail(email);
		return user.getRole();
	}

	@Override
	public Users getUser(String email) {
		// TODO Auto-generated method stub
		return repo.findByEmail(email);

	}

	@Override
	public void updateUser(Users user) {
		// TODO Auto-generated method stub
		repo.save(user);
	}

	@Override
	public boolean getPremium(String email) {
		// TODO Auto-generated method stub
		Users U=repo.findByEmail(email);
		return U.isPremium();
	}


}
