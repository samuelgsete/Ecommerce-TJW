package br.edu.ifce.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Cliente extends EntidadeBase {
	
	@Column
	private String nome;
	
	@Column
	private String telefone;
	
	@Column
	private String email;
	
	@Column
	private String senha;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String toString() {
		return "Cliente [nome=" + nome + ", telefone=" + telefone + ", email=" + email + ", senha=" + senha + "]";
	}
}