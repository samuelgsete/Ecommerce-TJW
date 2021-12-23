package br.edu.ifce.model;

public class Item {
	
	private Produto produto;
	private int qtdItem;
	
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public int getQtdItem() {
		return qtdItem;
	}
	public void setQtdItem(int qtdItem) {
		this.qtdItem = qtdItem;
	}
	
	public String toString() {
		return "Item [produto=" + produto + ", qtdItem=" + qtdItem + "]";
	}
	
}