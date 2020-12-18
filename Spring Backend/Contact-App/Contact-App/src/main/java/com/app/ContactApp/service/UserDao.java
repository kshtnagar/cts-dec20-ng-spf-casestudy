package com.app.ContactApp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.ContactApp.Exception.UserNotFoundException;
import com.app.ContactApp.model.User;


@Service
public class UserDao {
	@Autowired
	private UserService dao;
	
	public User save(User user) {
		User createdUser = dao.save(user);
		return createdUser;
	}
	
	
	public  User findById(int id) throws UserNotFoundException {
		Optional<User> option = dao.findById(id);
		if(option.isPresent())
			return option.get();
		else
			throw new UserNotFoundException("User not found");
	}
	
	public String deleteUser(int id) throws UserNotFoundException  {
		Optional<User> option = dao.findById(id);
		if(option.isPresent()) {
			dao.deleteById(id);
			return "Success";
		}
		else
			throw new UserNotFoundException("User not found");
	}
	
	
	public User login(int id, String password) throws UserNotFoundException  {
		Optional<User> option = dao.findById(id);
		if(option.isPresent()) {
			User user = option.get();
			if(user.getPassword().equals(password)) {
			return user;
			}
			throw new UserNotFoundException("User not found");
		}
		else
			throw new UserNotFoundException("User not found");
	}


	public Iterable<User> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

}
