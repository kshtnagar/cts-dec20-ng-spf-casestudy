package com.example.ContactApp.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ContactApp.bean.Users;


@Service
public class UserService{
	
	@Autowired
	private UserRepostitory dao;
	
	
	public Users addUser(Users user) {
		Users createdUser = dao.save(user);
		return createdUser;
	}
	
	
	public  Users findUser(int id) {
		Optional<Users> option = dao.findById(id);
		if(option.isPresent())
			return option.get();
		else
			return null;
	}
	
	public String deleteUser(int id) {
		Optional<Users> option = dao.findById(id);
		if(option.isPresent()) {
			dao.deleteById(id);
			return "Success";
		}
		else
			return null;
	}


	public Iterable<Users> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

}
