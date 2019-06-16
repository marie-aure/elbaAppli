package fr.elba.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sims")
@DiscriminatorValue("sim")
public class Sim {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String prenom;
	private String nom;
	private Genre sexe;
	private Espece espece;
	private Orientation orientation;
	private boolean marie;
	private boolean realise;
	private boolean mort;
	private boolean legitime;
	private boolean heritier;
	private boolean adulte;
	
	// liaisons
	@ManyToOne
	private Famille famille;

	@ManyToOne
	private Famille familleOrigine;

	@OneToOne
	private Sim couple;

	@ManyToOne
	private Sim parent1;

	@ManyToOne
	private Sim parent2;

	@OneToOne(mappedBy = "chef")
	private Famille cFamille;

	@ManyToOne
	private Souhait souhait;

	public Sim() {
		super();
	}

	public Sim(String prenom, String nom, Genre sexe, Espece espece, Orientation orientation, boolean marie,
			boolean mort, boolean adulte, boolean realise, Famille famille, Famille familleOrigine, Sim couple, Sim parent1,
			Sim parent2) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.sexe = sexe;
		this.espece = espece;
		this.orientation = orientation;
		this.marie = marie;
		this.mort = mort;
		this.adulte = adulte;
		this.realise = realise;
		this.famille = famille;
		this.familleOrigine = familleOrigine;
		this.couple = couple;
		this.parent1 = parent1;
		this.parent2 = parent2;
	}

	public Sim(int id, String prenom, String nom, Genre sexe, Espece espece, Orientation orientation, boolean marie,
			boolean mort, boolean adulte, boolean realise, Famille famille, Famille familleOrigine, Sim couple, Sim parent1,
			Sim parent2) {
		super();
		this.id = id;
		this.prenom = prenom;
		this.nom = nom;
		this.sexe = sexe;
		this.espece = espece;
		this.orientation = orientation;
		this.marie = marie;
		this.mort = mort;
		this.adulte = adulte;
		this.realise = realise;
		this.famille = famille;
		this.familleOrigine = familleOrigine;
		this.couple = couple;
		this.parent1 = parent1;
		this.parent2 = parent2;
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

	public Genre getSexe() {
		return sexe;
	}

	public void setSexe(Genre sexe) {
		this.sexe = sexe;
	}

	public Espece getEspece() {
		return espece;
	}

	public void setEspece(Espece espece) {
		this.espece = espece;
	}

	public Orientation getOrientation() {
		return orientation;
	}

	public void setOrientation(Orientation orientation) {
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

	public Sim getParent1() {
		return parent1;
	}

	public void setParent1(Sim parent1) {
		this.parent1 = parent1;
	}

	public Sim getParent2() {
		return parent2;
	}

	public void setParent2(Sim parent2) {
		this.parent2 = parent2;
	}

	public Famille getcFamille() {
		return cFamille;
	}

	public void setcFamille(Famille cFamille) {
		this.cFamille = cFamille;
	}

	public boolean isMort() {
		return mort;
	}

	public void setMort(boolean mort) {
		this.mort = mort;
	}

	public boolean isLegitime() {
		return legitime;
	}

	public void setLegitime(boolean legitime) {
		this.legitime = legitime;
	}

	public boolean isHeritier() {
		return heritier;
	}

	public void setHeritier(boolean heritier) {
		this.heritier = heritier;
	}

	public Souhait getSouhait() {
		return souhait;
	}

	public void setSouhait(Souhait souhait) {
		this.souhait = souhait;
	}

	public boolean isAdulte() {
		return adulte;
	}

	public void setAdulte(boolean adulte) {
		this.adulte = adulte;
	}

}
