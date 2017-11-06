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
@Table(name = "quartiers")
public class Quartier {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String libelle;

	// liaisons
	@OneToMany(mappedBy = "quartier",cascade=CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Terrain> lTerrains;

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

	public List<Terrain> getlTerrains() {
		return lTerrains;
	}

	public void setlTerrains(List<Terrain> lTerrains) {
		this.lTerrains = lTerrains;
	}

	@Override
	public String toString() {
		return "Quartier [id=" + id + ", " + (libelle != null ? "libelle=" + libelle + ", " : "")
				+ (lTerrains != null ? "lTerrains=" + lTerrains : "") + "]";
	}

}
