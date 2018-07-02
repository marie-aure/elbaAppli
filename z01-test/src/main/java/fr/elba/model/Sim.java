package fr.elba.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
	private boolean marie;
	private boolean realise;

	// liaisons
	@ManyToOne
	private Famille famille;

	@ManyToOne
	private Famille familleOrigine;

	@OneToOne
	private Sim couple;

	@OneToOne(mappedBy = "chef")
	private Famille cFamille;

	public Sim() {
		super();
	}

	public Sim(String prenom, String nom, String sexe, String espece, String orientation, boolean marie,
			boolean realise, Famille famille, Famille familleOrigine, Sim couple) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.sexe = sexe;
		this.espece = espece;
		this.orientation = orientation;
		this.marie = marie;
		this.realise = realise;
		this.famille = famille;
		this.familleOrigine = familleOrigine;
		this.couple = couple;
	}

	public Sim(int id, String prenom, String nom, String sexe, String espece, String orientation, boolean marie,
			boolean realise, Famille famille, Famille familleOrigine, Sim couple) {
		super();
		this.id = id;
		this.prenom = prenom;
		this.nom = nom;
		this.sexe = sexe;
		this.espece = espece;
		this.orientation = orientation;
		this.marie = marie;
		this.realise = realise;
		this.famille = famille;
		this.familleOrigine = familleOrigine;
		this.couple = couple;
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

	public boolean isMarie() {
		return marie;
	}

	public void setMarie(boolean marie) {
		this.marie = marie;
	}

	public boolean isRealise() {
		return realise;
	}

	public void setRealise(boolean realise) {
		this.realise = realise;
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

	public Sim getCouple() {
		return couple;
	}

	public void setCouple(Sim couple) {
		this.couple = couple;
	}

	public Famille getcFamille() {
		return cFamille;
	}

	public void setcFamille(Famille cFamille) {
		this.cFamille = cFamille;
	}

	@Override
	public String toString() {
		return "Sim [id=" + id + ", " + (prenom != null ? "prenom=" + prenom + ", " : "")
				+ (nom != null ? "nom=" + nom + ", " : "") + (sexe != null ? "sexe=" + sexe + ", " : "")
				+ (espece != null ? "espece=" + espece + ", " : "")
				+ (orientation != null ? "orientation=" + orientation + ", " : "") + "marie=" + marie + ", realise="
				+ realise + ", " + (famille != null ? "famille=" + famille + ", " : "")
				+ (familleOrigine != null ? "familleOrigine=" + familleOrigine + ", " : "")
				+ (couple != null ? "couple=" + couple : "") + "]";
	}

}
