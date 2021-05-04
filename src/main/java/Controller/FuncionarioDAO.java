package Controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Model.Funcionario;

public class FuncionarioDAO {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa"); //o parâmetro
	//é o que passamos no persistence.xml
	
	EntityManager em = emf.createEntityManager();
	
	public Funcionario findById(Integer id) {
		return em.find(Funcionario.class, id);
	}
	
	public void save(Funcionario funcionario) {
		em.getTransaction().begin();
		em.persist(funcionario);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
	
	public void delete(Integer id) {
		em.getTransaction().begin();
		em.remove(id);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
	
	public void update(Integer id, String nome, String email) {
		Funcionario funcionario = em.find(Funcionario.class, id);
		funcionario.setNome(nome);
		funcionario.setEmail(email);
		em.getTransaction().begin();
		em.persist(funcionario);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
}
