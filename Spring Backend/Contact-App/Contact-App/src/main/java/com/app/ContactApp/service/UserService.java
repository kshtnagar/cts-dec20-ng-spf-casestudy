package com.app.ContactApp.service;

import org.springframework.data.repository.CrudRepository;

import com.app.ContactApp.model.User;


public interface UserService extends CrudRepository<User, Integer> {

}
