package fr.elba.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "familles")
public class Famille {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String nom;

	// liaisons
	@OneToMany(mappedBy = "proprietaire")
	private List<Terrain> lTerrains;

	public Famille() {
		super();
	}

	public Famille(String nom) {
		super();
		this.nom = nom;
	}

	public Famille(int id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Terrain> getlTerrains() {
		return lTerrains;
	}

	public void setlTerrains(List<Terrain> lTerrains) {
		this.lTerrains = lTerrains;
	}

	@Override
	public String toString() {
		return "Famille [id=" + id + ", " + (nom != null ? "nom=" + nom + ", " : "")
				+ (lTerrains != null ? "lTerrains=" + lTerrains : "") + "]";
	}

}
