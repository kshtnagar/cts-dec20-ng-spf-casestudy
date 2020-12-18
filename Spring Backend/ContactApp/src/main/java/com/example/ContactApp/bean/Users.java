package com.example.ContactApp.bean;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class Users {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name="name")
	private String name;
	@Column(name="password")
	private String password;
	@Column(name="mob_no")
	private int mob_no;
	@Column(name="dob")
	private LocalDate dob;
	
	public Users(int id, String name, String password, int mob_no, LocalDate dob) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.mob_no = mob_no;
		this.dob = dob;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getMob_no() {
		return mob_no;
	}

	public void setMob_no(int mob_no) {
		this.mob_no = mob_no;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	
	
	
	
	

}
