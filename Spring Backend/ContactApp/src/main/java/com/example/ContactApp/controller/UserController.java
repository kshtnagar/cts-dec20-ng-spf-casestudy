package com.example.ContactApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ContactApp.bean.Users;
import com.example.ContactApp.service.UserService;


@RestController
@RequestMapping(path="/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping(value="", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public Users createUserAPI(@RequestBody Users user) {
		Users createdUser = userService.addUser(user); 
		return createdUser;
		
	}
	
	@GetMapping(value="/{id}" ,produces=MediaType.APPLICATION_JSON_VALUE)
	public Users getUserAPI(@PathVariable("id") int id) {
		System.out.println("Get");
		Users user= userService.findUser(id);
		return user;
	}
	
	
	

}
