package com.ajax.web.model;

public class SearchCriteria {

	String username;
	String email;
	String bike;
	String houses;
	String option;

	public String getBike() {
		return bike;
	}

	public void setBike(String bike) {
		this.bike = bike;
	}
	
	public String getHouses() {
		return houses;
	}

	public void setHouses(String houses) {
		this.houses = houses;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "SearchCriteria [username=" + username + ", email=" + email + ", bike=" + bike + "]";
	}

}
