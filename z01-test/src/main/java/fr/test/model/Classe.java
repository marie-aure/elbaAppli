package fr.test.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "classes")
public class Classe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String libelle;

	// liaison
	@OneToMany(mappedBy = "classe", fetch = FetchType.LAZY)
	private List<Prive> lPrives;

	@ManyToOne
	private Quartier quartier;

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

	public Quartier getQuartier() {
		return quartier;
	}

	public void setQuartier(Quartier quartier) {
		this.quartier = quartier;
	}

	@Override
	public String toString() {
		return "Classe [id=" + id + ", " + (libelle != null ? "libelle=" + libelle + ", " : "")
				+ (lPrives != null ? "lPrives=" + lPrives + ", " : "")
				+ (quartier != null ? "quartier=" + quartier : "") + "]";
	}

}
