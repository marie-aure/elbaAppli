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
	
	@OneToOne
	private Classe classeSup;
		
	@OneToOne(mappedBy="classeSup")
	private Classe classeInf;
	
	@OneToMany(mappedBy="classe"/*, cascade=CascadeType.ALL*/)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Condition> lConditions;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "classe"/*,cascade=CascadeType.ALL*/)
	private List<Prive> lPrives;
	
	@OneToMany(mappedBy="classe"/*, cascade=CascadeType.ALL*/)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Famille> lFamilles;
	
	@OneToMany(mappedBy="classe"/*, cascade=CascadeType.ALL*/)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<LiaisonDVCL> lLiaisonDVCLs;
	
	@OneToMany(mappedBy="classe"/*, cascade=CascadeType.ALL*/)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<LiaisonDRCL> lLiaisonDRCLs;
	
	@OneToMany(mappedBy="classe"/*, cascade=CascadeType.ALL*/)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<LiaisonPRCL> lLiaisonPRCLs;
	
	public Classe() {
		super();
	}
	
	public Classe(String libelle, int compte, Quartier quartier, Classe classeSup,  Classe classeInf) {
		super();
		this.libelle = libelle;
		this.compte = compte;
		this.quartier = quartier;
		this.classeSup = classeSup;

		this.classeInf = classeInf;
	}

	public Classe(int id, String libelle, int compte, Quartier quartier, Classe classeSup, Classe classeInf) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.compte = compte;
		this.quartier = quartier;
		this.classeSup = classeSup;
		this.classeInf = classeInf;
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

	public int getCompte() {
		return compte;
	}

	public void setCompte(int compte) {
		this.compte = compte;
	}

	public Quartier getQuartier() {
		return quartier;
	}

	public void setQuartier(Quartier quartier) {
		this.quartier = quartier;
	}

	public Classe getClasseSup() {
		return classeSup;
	}

	public void setClasseSup(Classe classeSup) {
		this.classeSup = classeSup;
	}



	public Classe getClasseInf() {
		return classeInf;
	}

	public void setClasseInf(Classe classeInf) {
		this.classeInf = classeInf;
	}

	public List<Condition> getlConditions() {
		return lConditions;
	}

	public void setlConditions(List<Condition> lConditions) {
		this.lConditions = lConditions;
	}

	public List<Prive> getlPrives() {
		return lPrives;
	}

	public void setlPrives(List<Prive> lPrives) {
		this.lPrives = lPrives;
	}

	public List<Famille> getlFamilles() {
		return lFamilles;
	}

	public void setlFamilles(List<Famille> lFamilles) {
		this.lFamilles = lFamilles;
	}

	public List<LiaisonDVCL> getlLiaisonDVCLs() {
		return lLiaisonDVCLs;
	}

	public void setlLiaisonDVCLs(List<LiaisonDVCL> lLiaisonDVCLs) {
		this.lLiaisonDVCLs = lLiaisonDVCLs;
	}

	public List<LiaisonDRCL> getlLiaisonDRCLs() {
		return lLiaisonDRCLs;
	}

	public void setlLiaisonDRCLs(List<LiaisonDRCL> lLiaisonDRCLs) {
		this.lLiaisonDRCLs = lLiaisonDRCLs;
	}

	public List<LiaisonPRCL> getlLiaisonPRCLs() {
		return lLiaisonPRCLs;
	}

	public void setlLiaisonPRCLs(List<LiaisonPRCL> lLiaisonPRCLs) {
		this.lLiaisonPRCLs = lLiaisonPRCLs;
	}

	@Override
	public String toString() {
		return "Classe [id=" + id + ", " + (libelle != null ? "libelle=" + libelle + ", " : "") + "compte=" + compte
				+ ", " + (quartier != null ? "quartier=" + quartier + ", " : "")
				+ (classeSup != null ? "classeSup=" + classeSup + ", " : "")
				+ (classeInf != null ? "classeInf=" + classeInf : "")
				+ "]";
	}


}
