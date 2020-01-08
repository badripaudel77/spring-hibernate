package com.hibernate.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//make entity class
@Entity
//name the table customer
@Table(name = "customer")
public class Customer {

	// map fields to the database columns

	// making primary key
	// naming column cust_id for id field
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //suitable for mysql db
	@Column(name = "id")
	private int id;

	@Column(name = "cust_name")
	private String name;

	@Column(name = "cust_email")
	private String email;

	public Customer() {
		// no-args constructor
	}

	public Customer(String name, String email) {
		super();
		this.name = name;
		this.email = email;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	// generating toString method
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", email=" + email + "]";
	}
}
