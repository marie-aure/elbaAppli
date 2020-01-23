package fr.elba.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
	private int generation;
	private int argentIG;

	// liaisons
	@ManyToOne
	private Classe classe;

	@OneToOne
	private Prive residence;

	@OneToOne
	private Sim chef;

	@OneToMany(mappedBy = "proprietaire"/* ,cascade=CascadeType.ALL */)
//	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Terrain> lTerrains;

	@OneToMany(mappedBy = "famille"/* ,cascade=CascadeType.ALL */)
//	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Pret> lPrets;

	@OneToMany(mappedBy = "famille"/* ,cascade=CascadeType.ALL */)
//	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Compte> lComptes;

	@OneToMany(mappedBy = "famille")
//	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Sim> lSims;

	@OneToMany(mappedBy = "familleOrigine")
//	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Sim> lSimOrigines;

//	@OneToMany(mappedBy = "famille"/* , cascade=CascadeType.ALL */)
//	@LazyCollection(LazyCollectionOption.FALSE)
//	private List<LiaisonCOFA> lLiaisonCOFAs;

	public Famille() {
		super();
	}

	public Famille(String nom, int generation, int argentIG, Classe classe, Prive residence, Sim chef) {
		super();
		this.nom = nom;
		this.generation = generation;
		this.argentIG = argentIG;
		this.classe = classe;
		this.residence = residence;
		this.chef = chef;
	}

	public Famille(int id, String nom, int generation, int argentIG, Classe classe, Prive residence, Sim chef) {
		super();
		this.id = id;
		this.nom = nom;
		this.generation = generation;
		this.argentIG = argentIG;
		this.classe = classe;
		this.residence = residence;
		this.chef = chef;
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

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
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

	public List<Terrain> getlTerrains() {
		return lTerrains;
	}

	public void setlTerrains(List<Terrain> lTerrains) {
		this.lTerrains = lTerrains;
	}

	public List<Pret> getlPrets() {
		return lPrets;
	}

	public void setlPrets(List<Pret> lPrets) {
		this.lPrets = lPrets;
	}

	public List<Compte> getlComptes() {
		return lComptes;
	}

	public void setlComptes(List<Compte> lComptes) {
		this.lComptes = lComptes;
	}

	public List<Sim> getlSims() {
		return lSims;
	}

	public void setlSims(List<Sim> lSims) {
		this.lSims = lSims;
	}

	public List<Sim> getlSimOrigines() {
		return lSimOrigines;
	}

	public void setlSimOrigines(List<Sim> lSimOrigines) {
		this.lSimOrigines = lSimOrigines;
	}

//	public List<LiaisonCOFA> getlLiaisonCOFAs() {
//		return lLiaisonCOFAs;
//	}
//
//	public void setlLiaisonCOFAs(List<LiaisonCOFA> lLiaisonCOFAs) {
//		this.lLiaisonCOFAs = lLiaisonCOFAs;
//	}

	@Override
	public String toString() {
		return "Famille [id=" + id + ", " + (nom != null ? "nom=" + nom + ", " : "") + "generation=" + generation
				+ ", argentIG=" + argentIG + ", " + (classe != null ? "classe=" + classe + ", " : "")
				+ (residence != null ? "residence=" + residence + ", " : "") + (chef != null ? "chef=" + chef : "")
				+ "]";
	}

}
