package br.edu.ifce.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.edu.ifce.model.Cliente;
import br.edu.ifce.model.Produto;


public class JpaInit {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("ecommerce");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		
		Produto mouse = new Produto();
		mouse.setNome("Mouse Multilaser Wireless");
		mouse.setPreco(48.89);
		mouse.setEstoque(10);
		mouse.setDetalhes("Mouse Sem Fio Multilaser Bluetooth");
		
		Produto pendrive = new Produto();
		pendrive.setNome("Pendrive Multilaser 16Gb");
		pendrive.setPreco(28.89);
		pendrive.setEstoque(10);
		pendrive.setDetalhes("Pendrive Multilaser USB 2.0 com 16Gb de armazenamento");
		
		Produto filtro = new Produto();
		filtro.setNome("Filtro de Linha Multilaser");
		filtro.setPreco(15.79);
		filtro.setEstoque(20);
		filtro.setDetalhes("Filtro de Linha com 4 portas e mecanismo de proteção");
		
		Cliente samuel = new Cliente();
		samuel.setNome("Samuel Souza");
		samuel.setTelefone("85989711010");
		samuel.setEmail("samuelsouza@yahoo.com");
		samuel.setSenha("123456");
		
		manager.persist(filtro);
		manager.persist(mouse);
		manager.persist(pendrive);
		manager.persist(samuel);
		
		manager.getTransaction().commit();
		
		manager.close();
		factory.close();
	}

}
