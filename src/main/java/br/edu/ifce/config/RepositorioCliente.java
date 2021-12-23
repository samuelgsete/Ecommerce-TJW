package br.edu.ifce.config;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.edu.ifce.model.Cliente;

public class RepositorioCliente {
	
	private EntityManagerFactory factory;
	private EntityManager manager;
	
	private void initTransaction() {
		factory = Persistence.createEntityManagerFactory("ecommerce");
		manager = factory.createEntityManager();
		manager.getTransaction().begin();
	}
	
	private void closeTransaction() {
		manager.getTransaction().commit();
		manager.close();
		factory.close();
	}
	
	public Cliente autenticarCliente(String email, String senha) {
		initTransaction();
		
		List<Cliente> cliente = manager.createQuery("SELECT c FROM Cliente c WHERE c.email = '" + email + "' AND c.senha = '" + senha +"'", Cliente.class).getResultList();
				
		closeTransaction();
		
		if(cliente.isEmpty()) {
			return null;
		}
		
		return cliente.get(0);
	}
}
