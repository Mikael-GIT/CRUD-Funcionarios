package Application;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;

import Model.Funcionario;

public class Aplicacao {
	public static void main(String[] args) {
		Funcionario p1 = new Funcionario(null, "Mikael Tavares", "mikaeltavares123@hotmail.com");
		Funcionario p2 = new Funcionario(null, "Matheus Brasil", "matheusbrasil@hotmail.com");
		Funcionario p3 = new Funcionario(null, "Beatriz Souza", "beatrizssouza@hotmail.com");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa"); //o parâmetro
		//é o que passamos no persistence.xml
		
		EntityManager em = emf.createEntityManager();
		List<Funcionario> pessoas = em.createQuery("from Pessoa", Funcionario.class).getResultList();
		for(Funcionario pessoa : pessoas) {
			System.out.println(pessoa);
		}
		em.close();
		emf.close();
	}
}
