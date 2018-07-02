package fr.elba.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("prive")
public class Prive extends Terrain {

	private Boolean groupe;
	private Boolean preConstruit;

	// liaisons
	@ManyToOne()
	private Classe classe;

	@OneToOne(mappedBy = "residence")
	private Famille famille;

	public Prive() {
		super();
	}

	public Prive(String libelle, String type, String adresse, String lieuDit, Boolean terrain, Boolean batiment,
			Quartier quartier, Famille proprietaire, Boolean groupe, Boolean preConstruit, Classe classe) {
		super(libelle, type, adresse, lieuDit, terrain, batiment, quartier, proprietaire);
		this.groupe = groupe;
		this.preConstruit = preConstruit;
		this.classe = classe;
	}

	public Prive(int id, String libelle, String type, String adresse, String lieuDit, Boolean terrain, Boolean batiment,
			Quartier quartier, Famille proprietaire, Boolean groupe, Boolean preConstruit, Classe classe) {
		super(id, libelle, type, adresse, lieuDit, terrain, batiment, quartier, proprietaire);
		this.groupe = groupe;
		this.preConstruit = preConstruit;
		this.classe = classe;
	}

	public Boolean getGroupe() {
		return groupe;
	}

	public void setGroupe(Boolean groupe) {
		this.groupe = groupe;
	}

	public Boolean getPreConstruit() {
		return preConstruit;
	}

	public void setPreConstruit(Boolean preConstruit) {
		this.preConstruit = preConstruit;
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	public Famille getFamille() {
		return famille;
	}

	public void setFamille(Famille famille) {
		this.famille = famille;
	}

	@Override
	public String toString() {
		return "Prive [" + (groupe != null ? "groupe=" + groupe + ", " : "")
				+ (preConstruit != null ? "preConstruit=" + preConstruit + ", " : "")
				+ (classe != null ? "classe=" + classe : "") + "]";
	}

}
