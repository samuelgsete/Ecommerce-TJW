package br.edu.ifce.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.edu.ifce.config.RepositorioCliente;
import br.edu.ifce.model.Cliente;

/**
 * Servlet implementation class Auth
 */
public class Auth extends HttpServlet {
	
	private RepositorioCliente repositorio = new RepositorioCliente();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Auth() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomeUsuario = request.getParameter("email");
		String senhaUsuario = request.getParameter("senha");
				
		Cliente clienteLogado = repositorio.autenticarCliente(nomeUsuario, senhaUsuario);
		System.out.println(clienteLogado);
		
		if(clienteLogado != null) {
			HttpSession sessao = request.getSession();
			sessao.setAttribute("clienteLogado", clienteLogado);
			RequestDispatcher view = request.getRequestDispatcher("/LojaController");
			view.forward(request, response);
		}
		else {
			HttpSession sessao = request.getSession();
			sessao.setAttribute("clienteLogado", null);
			RequestDispatcher view = request.getRequestDispatcher("/login.html");
			view.forward(request, response);
		}
	}

}
