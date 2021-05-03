package Application;

import java.util.List;

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
		List<Pessoa> pessoas = em.createQuery("from Pessoa", Pessoa.class).getResultList();
		for(Pessoa pessoa : pessoas) {
			System.out.println(pessoa);
		}
		
		em.close();
		emf.close();
	}
}
