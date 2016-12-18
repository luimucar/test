

//TestaInsereProduto.java
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Usuario;

public class testeInsereUsuario {

public static void main(String[] args)
{
EntityManagerFactory factory =
Persistence.createEntityManagerFactory("pets");
EntityManager em = factory.createEntityManager();

Usuario p = new Usuario();
p.setUsername("braulio");
p.setBike("1");
p.setHouses("2");
p.setVoption("option1");

em.getTransaction().begin();

em.persist(p);

em.getTransaction().commit();
}
}