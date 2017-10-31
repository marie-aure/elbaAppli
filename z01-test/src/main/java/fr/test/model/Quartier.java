package fr.test.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "quartiers")
public class Quartier {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String libelle;

	// Liaisons
	@OneToMany(mappedBy = "quartier", fetch = FetchType.LAZY)
	private List<Terrain> ltTerrains;

	@OneToMany(mappedBy = "quartier", fetch = FetchType.LAZY)
	private List<Classe> lClasses;

	public Quartier() {
		super();
	}

	public Quartier(String libelle) {
		super();
		this.libelle = libelle;
	}

	public Quartier(int id, String libelle) {
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

	public List<Terrain> getLtTerrains() {
		return ltTerrains;
	}

	public void setLtTerrains(List<Terrain> ltTerrains) {
		this.ltTerrains = ltTerrains;
	}

	public List<Classe> getlClasses() {
		return lClasses;
	}

	public void setlClasses(List<Classe> lClasses) {
		this.lClasses = lClasses;
	}

	@Override
	public String toString() {
		return "Quartier [id=" + id + ", " + (libelle != null ? "libelle=" + libelle + ", " : "")
				+ (ltTerrains != null ? "ltTerrains=" + ltTerrains + ", " : "")
				+ (lClasses != null ? "lClasses=" + lClasses : "") + "]";
	}

}
