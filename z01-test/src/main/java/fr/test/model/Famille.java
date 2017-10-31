package fr.test.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "familles")
public class Famille {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String nom;
	private int generation;
	private int argentIG;

	//liaison 
	@OneToMany(mappedBy="proprietaire", fetch=FetchType.LAZY)
	private List<Terrain> lTerrains;
	
	@OneToOne
	private Prive residence;
	
	@OneToOne
	private Sim chef;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="famille")
	private List<Sim> lMembres;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="familleOrigine")
	private List<Sim> lMembreOrigines;
	
	public Famille() {
		super();
	}

	public Famille(String nom, int generation, int argentIG) {
		super();
		this.nom = nom;
		this.generation = generation;
		this.argentIG = argentIG;
	}

	public Famille(int id, String nom, int generation, int argentIG) {
		super();
		this.id = id;
		this.nom = nom;
		this.generation = generation;
		this.argentIG = argentIG;
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

	public int getGeneration() {
		return generation;
	}

	public void setGeneration(int generation) {
		this.generation = generation;
	}

	public int getArgentIG() {
		return argentIG;
	}

	public void setArgentIG(int argentIG) {
		this.argentIG = argentIG;
	}

	public List<Terrain> getlTerrains() {
		return lTerrains;
	}

	public void setlTerrains(List<Terrain> lTerrains) {
		this.lTerrains = lTerrains;
	}

	
	public Prive getResidence() {
		return residence;
	}

	public void setResidence(Prive residence) {
		this.residence = residence;
	}

	public Sim getChef() {
		return chef;
	}

	public void setChef(Sim chef) {
		this.chef = chef;
	}

	public List<Sim> getlMembres() {
		return lMembres;
	}

	public void setlMembres(List<Sim> lMembres) {
		this.lMembres = lMembres;
	}

	public List<Sim> getlMembreOrigines() {
		return lMembreOrigines;
	}

	public void setlMembreOrigines(List<Sim> lMembreOrigines) {
		this.lMembreOrigines = lMembreOrigines;
	}

	@Override
	public String toString() {
		return "Famille [id=" + id + ", " + (nom != null ? "nom=" + nom + ", " : "") + "generation=" + generation
				+ ", argentIG=" + argentIG + ", " + (lTerrains != null ? "lTerrains=" + lTerrains + ", " : "")
				+ (residence != null ? "residence=" + residence + ", " : "")
				+ (chef != null ? "chef=" + chef + ", " : "") + (lMembres != null ? "lMembres=" + lMembres + ", " : "")
				+ (lMembreOrigines != null ? "lMembreOrigines=" + lMembreOrigines : "") + "]";
	}



}
