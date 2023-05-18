package com.app.web.dto;

public class UserRegisterDTO {
	private Long id;

	private String name;

	private String username;

	private String password;

	private String street;

	private String city;

	private String zipcode;

	private String country;

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

	public UserRegisterDTO(Long id, String name, String username, String password, String street, String city,
			String zipcode, String country) {
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
		this.street = street;
		this.city = city;
		this.zipcode = zipcode;
		this.country = country;
	}

	public UserRegisterDTO(String name, String username, String password, String street, String city, String zipcode,
			String country) {
		this.name = name;
		this.username = username;
		this.password = password;
		this.street = street;
		this.city = city;
		this.zipcode = zipcode;
		this.country = country;
	}

	public UserRegisterDTO() {
	}

	public UserRegisterDTO(String username) {
		this.username = username;
	}

}
