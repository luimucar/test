package model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Usuario;

public class saveUsuario {

	public saveUsuario(){};
	
	public String save(String username, String bike, String voption, String houses){
		
		EntityManagerFactory factory =
		Persistence.createEntityManagerFactory("pets");
		EntityManager em = factory.createEntityManager();

		Usuario p = new Usuario();
		p.setUsername(username);
		p.setBike(bike);
		p.setHouses(houses);
		p.setVoption(voption);

		em.getTransaction().begin();

		em.persist(p);

		em.getTransaction().commit();
		return "OK";
	}
}
