package com.cbs.dto;



public class UserDTO {

	private String name;
	private String email;
	
	public UserDTO() {
		super();
	}

	public UserDTO(String name, String email) {
		super();
		this.name = name;
		this.email = email;
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

	@Override
	public String toString() {
		return "User [ name=" + name + ", email=" + email + "]";
	}
}
