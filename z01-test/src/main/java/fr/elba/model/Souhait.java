package fr.elba.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "souhaits")
public class Souhait {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String libelle;

	// liaisons
	@OneToMany(mappedBy = "souhait")
	private List<Sim> lSims;

	public Souhait() {
		super();
	}

	public Souhait(String libelle) {
		super();
		this.libelle = libelle;
	}

	public Souhait(int id, String libelle) {
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

	public List<Sim> getlSims() {
		return lSims;
	}

	public void setlSims(List<Sim> lSims) {
		this.lSims = lSims;
	}

	@Override
	public String toString() {
		return "Souhait [id=" + id + ", " + (libelle != null ? "libelle=" + libelle : "") + "]";
	}

}
