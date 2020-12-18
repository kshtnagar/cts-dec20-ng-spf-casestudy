package com.app.ContactApp.service;

import org.springframework.data.repository.CrudRepository;

import com.app.ContactApp.model.Contacts;

public interface ContactService extends CrudRepository<Contacts, Integer> {

}
