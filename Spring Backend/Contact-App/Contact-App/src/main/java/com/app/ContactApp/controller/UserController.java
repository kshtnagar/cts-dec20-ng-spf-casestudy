package com.app.ContactApp.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.ContactApp.Exception.UserNotFoundException;
import com.app.ContactApp.model.User;
import com.app.ContactApp.service.UserDao;
import com.app.ContactApp.service.UserService;



@RestController
@CrossOrigin(origins="*")
public class UserController {
	
	@Autowired
	private UserDao userDao;
	
	@PostMapping(value="/user", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	private User create(@RequestBody User user) {
		return userDao.save(user);
	}
	
	@GetMapping("/user")
		private Iterable<User> view(){
			return userDao.findAll();
		}
	
	@GetMapping("/user/{id}")
	private ResponseEntity<Object> findById(@PathVariable("id") int id) throws UserNotFoundException {
		ResponseEntity<Object> response = null;
		try {
		User user = userDao.findById(id);
		response = ResponseEntity.status(200).body(user);
		} catch(UserNotFoundException e) {
			response = ResponseEntity.status(404).body(e.getMessage());
		}
		return response;
	}
	
	@GetMapping("/login/objectKey/{id}/{password}")
	private ResponseEntity<Object> login(@PathVariable("id") int id,@PathVariable("password") String password){
		ResponseEntity<Object> response = null;
		try {
		User user = userDao.login(id,password);
		response = ResponseEntity.status(200).body(user);
		} catch(UserNotFoundException e) {
			response = ResponseEntity.status(404).body(e.getMessage());
		}
		return response;
	}
}
