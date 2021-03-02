package br.edu.ifrn.pi.bookcrud.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Country implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private String nameInPortuguese;
	@Column(nullable = false)
	private String nameInEnglish;
	@Column(nullable = false)
	private String acronym;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNameInPortuguese() {
		return nameInPortuguese;
	}
	public void setNameInPortuguese(String nameInPortuguese) {
		this.nameInPortuguese = nameInPortuguese;
	}
	public String getNameInEnglish() {
		return nameInEnglish;
	}
	public void setNameInEnglish(String nameInEnglish) {
		this.nameInEnglish = nameInEnglish;
	}
	public String getAcronym() {
		return acronym;
	}
	public void setAcronym(String acronym) {
		this.acronym = acronym;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Country other = (Country) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
