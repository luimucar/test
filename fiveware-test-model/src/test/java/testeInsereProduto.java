

//TestaInsereProduto.java
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Produto;

public class testeInsereProduto {

public static void main(String[] args)
{
EntityManagerFactory factory =
Persistence.createEntityManagerFactory("pets");
EntityManager em = factory.createEntityManager();

Produto p = new Produto();
p.setNome("camiseta");
p.setPreco(12.23);

em.getTransaction().begin();

em.persist(p);

em.getTransaction().commit();
}
}