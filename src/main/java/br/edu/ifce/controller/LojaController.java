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
 * Servlet implementation class LojaController
 */
public class LojaController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private RepositorioProduto repositorio = new RepositorioProduto();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LojaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Produto> produtos = repositorio.findAll();
		request.setAttribute("produtos", produtos);
		RequestDispatcher view = request.getRequestDispatcher("/views/Loja.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
