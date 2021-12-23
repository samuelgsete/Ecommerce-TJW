package br.edu.ifce.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Produto extends EntidadeBase {
	
	@Column
	private String nome;
	@Column
	private double preco;
	@Column
	private int estoque;
	@Column
	private String detalhes;
		
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getEstoque() {
		return estoque;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}

	public String getDetalhes() {
		return detalhes;
	}

	public void setDetalhes(String detalhes) {
		this.detalhes = detalhes;
	}

	public String toString() {
		return "Produto [nome=" + nome + ", preco=" + preco + ", estoque=" + estoque + ", detalhes=" + detalhes + "]";
	}
}