package br.edu.ifce.controller;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifce.config.RepositorioProduto;
import br.edu.ifce.model.Produto;

/**
 * Servlet implementation class CadastrarProduto
 */
public class CadastrarProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private RepositorioProduto repositorio = new RepositorioProduto();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastrarProduto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("CadastroProduto.html");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		double preco = Double.parseDouble(request.getParameter("preco"));
		int estoque = Integer.parseInt(request.getParameter("estoque"));
		String detalhes = request.getParameter("detalhes");
		
		Produto novoProduto = new Produto();
		novoProduto.setNome(nome);
		novoProduto.setPreco(preco);
		novoProduto.setEstoque(estoque);
		novoProduto.setDetalhes(detalhes);
		
		repositorio.save(novoProduto);
		List<Produto> produtos = repositorio.findAll();
		request.setAttribute("produtos", produtos);
		RequestDispatcher view = request.getRequestDispatcher("views/ListarProdutos.jsp");
		view.forward(request, response);
	}
}
