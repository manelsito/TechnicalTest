package com.app.web.entity;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "User", uniqueConstraints = @UniqueConstraint(columnNames = "username"))
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "Name", nullable = false, length = 50)
	private String name;

	@Column(name = "Username", nullable = false, length = 50, unique = true)
	private String username;

	@Column(name = "Password", nullable = false, length = 50)
	private String password;

	@Column(name = "Street", nullable = false, length = 255)
	private String street;

	@Column(name = "City", nullable = false, length = 255)
	private String city;

	@Column(name = "Zipcode", nullable = false, length = 255)
	private String zipcode;

	@Column(name = "Country", nullable = false, length = 255)
	private String country;

	public User() {

	}


	//---CONSTRUCTORS---

	public User(Long id, String username, String country) {
		this.id = id;
		this.username = username;
		this.country = country;
	}



	public User(Long id, String name, String username, String password, String street, String city, String zipcode,
			String country) {
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
		this.street = street;
		this.city = city;
		this.zipcode = zipcode;
		this.country = country;
	}

	public User(String name, String username, String password, String street, String city, String zipcode,
			String country) {
		this.name = name;
		this.username = username;
		this.password = password;
		this.street = street;
		this.city = city;
		this.zipcode = zipcode;
		this.country = country;
	}

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	//---GETTERS & SETTERS---

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
