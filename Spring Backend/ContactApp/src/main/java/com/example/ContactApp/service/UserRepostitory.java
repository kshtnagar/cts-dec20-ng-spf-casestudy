package com.example.ContactApp.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ContactApp.bean.Users;

public interface UserRepostitory extends JpaRepository<Users, Integer> {
	

}
