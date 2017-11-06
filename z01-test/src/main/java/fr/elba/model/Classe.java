package fr.elba.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "classes")
public class Classe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String libelle;

	// liaisons
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "classe",cascade=CascadeType.ALL)
	private List<Prive> lPrives;

	public Classe() {
		super();
	}

	public Classe(String libelle) {
		super();
		this.libelle = libelle;
	}

	public Classe(int id, String libelle) {
		super();
		this.id = id;
		this.libelle = libelle;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public List<Prive> getlPrives() {
		return lPrives;
	}

	public void setlPrives(List<Prive> lPrives) {
		this.lPrives = lPrives;
	}

	@Override
	public String toString() {
		return "Classe [id=" + id + ", libelle=" + libelle + ", lPrives=" + lPrives + "]";
	}

}
