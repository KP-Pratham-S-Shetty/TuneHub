package com.tunehub.trial.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tunehub.trial.entity.Users;

public interface UsersRepository extends JpaRepository<Users,Integer>{
	public Users findByEmail(String email);
}
