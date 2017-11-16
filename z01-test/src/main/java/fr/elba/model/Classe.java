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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "classes")
public class Classe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String libelle;

	@Transient
	private int compte;
	
	// liaisons
	@ManyToOne
	private Quartier quartier;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "classe",cascade=CascadeType.ALL)
	private List<Prive> lPrives;
	
	@OneToMany(mappedBy="classe", cascade=CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Famille> lFamilles;
	
	@OneToMany(mappedBy="classe", cascade=CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<LiaisonDVCL> lLiaisonDVCLs;
	
	@OneToOne
	private Classe classeSup;

	@OneToOne(mappedBy="classeSup")
	private Classe classeInf;
	
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

	public Quartier getQuartier() {
		return quartier;
	}

	public void setQuartier(Quartier quartier) {
		this.quartier = quartier;
	}

	public List<Prive> getlPrives() {
		return lPrives;
	}

	public void setlPrives(List<Prive> lPrives) {
		this.lPrives = lPrives;
	}
	
	public Classe getClasseSup() {
		return classeSup;
	}

	public void setClasseSup(Classe classeSup) {
		this.classeSup = classeSup;
	}
	

	public int getCompte() {
		return compte;
	}

	public void setCompte(int compte) {
		this.compte = compte;
	}

	public List<Famille> getlFamilles() {
		return lFamilles;
	}

	public void setlFamilles(List<Famille> lFamilles) {
		this.lFamilles = lFamilles;
	}

	
	
	public Classe getClasseInf() {
		return classeInf;
	}

	public void setClasseInf(Classe classeInf) {
		this.classeInf = classeInf;
	}
	
	

	public List<LiaisonDVCL> getlLiaisonDVCLs() {
		return lLiaisonDVCLs;
	}

	public void setlLiaisonDVCLs(List<LiaisonDVCL> lLiaisonDVCLs) {
		this.lLiaisonDVCLs = lLiaisonDVCLs;
	}

	@Override
	public String toString() {
		return "Classe [id=" + id + ", " + (libelle != null ? "libelle=" + libelle + ", " : "")
				+ (quartier != null ? "quartier=" + quartier + ", " : "")
				+ (lPrives != null ? "lPrives=" + lPrives + ", " : "")
				+ (classeSup != null ? "classeSup=" + classeSup : "") + "]";
	}

	
}
