package fr.elba.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "familles")
public class Famille {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String nom;

	// liaisons
	@OneToMany(mappedBy = "proprietaire"/*,cascade=CascadeType.ALL*/)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Terrain> lTerrains;

	@ManyToOne
	private Classe classe;
	
	public Famille() {
		super();
	}

	public Famille(String nom,Classe classe) {
		super();
		this.nom = nom;
		this.classe = classe;
	}

	public Famille(int id, String nom, Classe classe) {
		super();
		this.id = id;
		this.nom = nom;
		this.classe = classe;
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
	
	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	@Override
	public String toString() {
		return "Famille [id=" + id + ", " + (nom != null ? "nom=" + nom + ", " : "")
				+ (lTerrains != null ? "lTerrains=" + lTerrains : "") + "]";
	}

}
