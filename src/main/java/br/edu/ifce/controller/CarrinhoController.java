package br.edu.ifce.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifce.model.Carrinho;
import br.edu.ifce.model.Item;
import br.edu.ifce.model.Produto;

/**
 * Servlet implementation class CarrinhoController
 */
public class CarrinhoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public Carrinho carrinho = new Carrinho();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarrinhoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unlikely-arg-type")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String app = request.getParameter("app");
		if(app == null) {
			String nome = request.getParameter("nome");
			double preco = Double.parseDouble(request.getParameter("preco"));
			String detalhes = request.getParameter("detalhes");
			int qtdItem= Integer.parseInt(request.getParameter("qtdItem"));
			
			Produto produto = new Produto();
			produto.setNome(nome);
			produto.setPreco(preco);
			produto.setDetalhes(detalhes);
			
			Item item = new Item();
			item.setProduto(produto);
			item.setQtdItem(qtdItem);
					
			List<Item> items = carrinho.getItems();
			items.add(item);
			carrinho.setItems(items);
			
			Double valor = calcularValor(items);
			carrinho.setValor(valor);			
		}
		else if(app.equalsIgnoreCase("remover")) {
			Integer indice = Integer.parseInt(request.getParameter("indice"));
			Item itemRemovido = carrinho.getItems().get(indice);	
			List<Item> items = carrinho.getItems();
			items.remove(itemRemovido);	
			
			Double valor = calcularValor(items);
			carrinho.setValor(valor);
		}
		
		request.setAttribute("carrinho", carrinho);
		RequestDispatcher view = request.getRequestDispatcher("/views/Carrinho.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private double calcularValor(List<Item> items) {
		Double valor = 0.0;
		for(Item itemCarrinho: items) {
			Double x = itemCarrinho.getProduto().getPreco();
			valor += x * (double) itemCarrinho.getQtdItem();
		}
		return valor;
	}

}
