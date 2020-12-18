package com.app.ContactApp.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.ContactApp.Exception.UserNotFoundException;
import com.app.ContactApp.model.Contacts;
import com.app.ContactApp.model.User;

import antlr.collections.List;

@Service
public class ContactDao {
	
	@Autowired
	private ContactService dao;
	
	public Contacts save(Contacts contacts) {
		Contacts createdContacts = dao.save(contacts);
		return createdContacts;
	}
	
	public String deleteContact(int id) throws UserNotFoundException  {
		Optional<Contacts> option = dao.findById(id);
		if(option.isPresent()) {
			Contacts con = option.get();
			dao.deleteById(con.getId());
			return "Success";
		}
		else
			throw new UserNotFoundException("User not found");
	}
	
	public Iterable<Contacts> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	public ArrayList<Contacts> findByUserId(int uid) {
		ArrayList<Contacts> con = new ArrayList<Contacts>();
		Iterable<Contacts> Allcon = dao.findAll();
		for(Contacts i :Allcon) {
			if(i.getUid()==uid) {
				con.add(i);
			}
		}
		return con;
	}

}
