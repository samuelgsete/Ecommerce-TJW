package br.edu.ifce.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import static javax.persistence.GenerationType.IDENTITY;

@MappedSuperclass
public abstract class EntidadeBase {
	
	@Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}