package org.internal.service;

import model.saveUsuario;

public class CreateUser {

	public CreateUser(){};
	
	public String create(String username, String bike, String voption, String houses){
		
		saveUsuario save = new saveUsuario();
		String res = save.save(username,bike,voption,houses);
		
		return res;
	}
}
