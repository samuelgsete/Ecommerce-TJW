package br.edu.ifce.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifce.config.RepositorioProduto;
import br.edu.ifce.model.Produto;

/**
 * Servlet implementation class ProdutoController
 */
public class ProdutoController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private RepositorioProduto repositorio = new RepositorioProduto();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProdutoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String app = request.getParameter("app");
			
		if(app.equalsIgnoreCase("listar")) {
			List<Produto> produtos = repositorio.findAll();
			request.setAttribute("produtos", produtos);
			RequestDispatcher view = request.getRequestDispatcher("views/ListarProdutos.jsp");
			view.forward(request, response);
		}
		
		if(app.equalsIgnoreCase("excluir")) {
			Integer id = Integer.parseInt(request.getParameter("produtoId"));
			repositorio.delete(id);
			List<Produto> produtos = repositorio.findAll();
			request.setAttribute("produtos", produtos);
			RequestDispatcher view = request.getRequestDispatcher("views/ListarProdutos.jsp");
			view.forward(request, response);
		}
		else if(app.equalsIgnoreCase("editar")) {
			Integer id = Integer.parseInt(request.getParameter("produtoId"));
			Produto produto = repositorio.findById(id);
			request.setAttribute("produto", produto);
			RequestDispatcher view = request.getRequestDispatcher("views/EditarProduto.jsp");
			view.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		String nome = request.getParameter("nome");
		double preco = Double.parseDouble(request.getParameter("preco"));
		int estoque = Integer.parseInt(request.getParameter("estoque"));
		String detalhes = request.getParameter("detalhes");
		
		Produto produto = new Produto();
		produto.setId(id);
		produto.setNome(nome);
		produto.setPreco(preco);
		produto.setEstoque(estoque);
		produto.setDetalhes(detalhes);
				
		repositorio.update(produto);
		List<Produto> produtos = repositorio.findAll();
		request.setAttribute("produtos", produtos);
		RequestDispatcher view = request.getRequestDispatcher("views/ListarProdutos.jsp");
		view.forward(request, response);
	}

}
