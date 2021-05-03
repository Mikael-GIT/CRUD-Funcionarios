package Application;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Model.Pessoa;

public class Aplicacao {
	public static void main(String[] args) {
		Pessoa p1 = new Pessoa(null, "Mikael Tavares", "mikaeltavares123@hotmail.com");
		Pessoa p2 = new Pessoa(null, "Matheus Brasil", "matheusbrasil@hotmail.com");
		Pessoa p3 = new Pessoa(null, "Beatriz Souza", "beatrizssouza@hotmail.com");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa"); //o parâmetro
		//é o que passamos no persistence.xml
		
		EntityManager em = emf.createEntityManager();
		
		//em.getTransaction().begin(); //Iniciando transação com o banco
		//em.persist(p1);
		//em.persist(p2);
		//em.persist(p3);
		//em.getTransaction().commit(); //confirmando alterações que foram feitas
		
		Pessoa p = em.find(Pessoa.class, 2);
		System.out.println(p);
		em.close();
		emf.close();
	}
}
