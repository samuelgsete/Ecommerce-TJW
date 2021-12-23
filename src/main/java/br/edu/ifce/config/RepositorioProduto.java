package br.edu.ifce.config;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.edu.ifce.model.Produto;

public class RepositorioProduto {
	
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
	
	public List<Produto> findAll() {
		initTransaction();
		
		List<Produto> produtos = manager.createQuery("SELECT p FROM Produto p", Produto.class).getResultList();
		
		closeTransaction();
		
		return produtos;
	}
		
	public Produto findById(Integer produtoId) {
		initTransaction();
		
		Produto produto = manager.find(Produto.class, produtoId);
				
		closeTransaction();
		
		return produto;
	}
	
	public void save(Produto novoProduto) {	
		initTransaction();
		
		manager.persist(novoProduto);
		
		closeTransaction();
	}
	
	public void update(Produto produto) {
		initTransaction();
		
		Produto produtoCriado = manager.find(Produto.class, produto.getId());
		produtoCriado.setId(produto.getId());
		produtoCriado.setNome(produto.getNome());
		produtoCriado.setPreco(produto.getPreco());
		produtoCriado.setEstoque(produto.getEstoque());
		produtoCriado.setDetalhes(produto.getDetalhes());
		
		manager.merge(produtoCriado);
						
		closeTransaction();
	}
	
	public void delete(Integer produtoId) {
		initTransaction();
		
		Produto produto = manager.find(Produto.class, produtoId);
		manager.remove(produto);
						
		closeTransaction();
	}
}