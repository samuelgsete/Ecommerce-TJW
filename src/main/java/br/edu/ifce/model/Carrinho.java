package br.edu.ifce.model;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {
	
	private List<Item> items = new ArrayList<Item>();
	private double valor = 0;

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}	
}