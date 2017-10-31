package fr.test.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sims")
public class Sim {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String prenom;
	private String nom;
	private String sexe;
	private String espece;
	private String orientation;
	private String statut;
	private Boolean marie;
	private Boolean realise;
	
	// liaison
	@OneToOne(mappedBy = "chef")
	private Famille cheffamille;

	@ManyToOne(cascade = CascadeType.ALL)
	private Famille famille;

	@ManyToOne(cascade = CascadeType.ALL)
	private Famille familleOrigine;

	@OneToOne
	private Sim conjoint;
	
	public Sim() {
		super();
	}

	public Sim(String prenom, String nom, String sexe, String espece, String orientation, String statut, Boolean marie,
			Boolean realise, Famille cheffamille, Famille famille, Famille familleOrigine) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.sexe = sexe;
		this.espece = espece;
		this.orientation = orientation;
		this.statut = statut;
		this.marie = marie;
		this.realise = realise;
		this.cheffamille = cheffamille;
		this.famille = famille;
		this.familleOrigine = familleOrigine;
	}

	public Sim(int id, String prenom, String nom, String sexe, String espece, String orientation, String statut,
			Boolean marie, Boolean realise, Famille cheffamille, Famille famille, Famille familleOrigine) {
		super();
		this.id = id;
		this.prenom = prenom;
		this.nom = nom;
		this.sexe = sexe;
		this.espece = espece;
		this.orientation = orientation;
		this.statut = statut;
		this.marie = marie;
		this.realise = realise;
		this.cheffamille = cheffamille;
		this.famille = famille;
		this.familleOrigine = familleOrigine;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getEspece() {
		return espece;
	}

	public void setEspece(String espece) {
		this.espece = espece;
	}

	public String getOrientation() {
		return orientation;
	}

	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public Boolean getMarie() {
		return marie;
	}

	public void setMarie(Boolean marie) {
		this.marie = marie;
	}

	public Boolean getRealise() {
		return realise;
	}

	public void setRealise(Boolean realise) {
		this.realise = realise;
	}

	public Famille getCheffamille() {
		return cheffamille;
	}

	public void setCheffamille(Famille cheffamille) {
		this.cheffamille = cheffamille;
	}

	public Famille getFamille() {
		return famille;
	}

	public void setFamille(Famille famille) {
		this.famille = famille;
	}

	public Famille getFamilleOrigine() {
		return familleOrigine;
	}

	public void setFamilleOrigine(Famille familleOrigine) {
		this.familleOrigine = familleOrigine;
	}

	public Sim getConjoint() {
		return conjoint;
	}

	public void setConjoint(Sim conjoint) {
		this.conjoint = conjoint;
	}

	@Override
	public String toString() {
		return "Sim [id=" + id + ", " + (prenom != null ? "prenom=" + prenom + ", " : "")
				+ (nom != null ? "nom=" + nom + ", " : "") + (sexe != null ? "sexe=" + sexe + ", " : "")
				+ (espece != null ? "espece=" + espece + ", " : "")
				+ (orientation != null ? "orientation=" + orientation + ", " : "")
				+ (statut != null ? "statut=" + statut + ", " : "") + (marie != null ? "marie=" + marie + ", " : "")
				+ (realise != null ? "realise=" + realise + ", " : "")
				+ (cheffamille != null ? "cheffamille=" + cheffamille + ", " : "")
				+ (famille != null ? "famille=" + famille + ", " : "")
				+ (familleOrigine != null ? "familleOrigine=" + familleOrigine + ", " : "")
				+ (conjoint != null ? "conjoint=" + conjoint : "") + "]";
	}


	
}
