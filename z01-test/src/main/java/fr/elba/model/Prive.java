package fr.elba.model;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("prive")
public class Prive extends Terrain {

	private Boolean groupe;
	private Boolean preConstruit;

	// liaisons
	@ManyToOne()
	private Classe classe;

	public Prive() {
		super();
	}

	public Prive(String libelle, String type, String adresse, String lieuDit, Boolean terrain, Boolean batiment,
			Boolean groupe, Boolean preConstruit) {
		super(libelle, type, adresse, lieuDit, terrain, batiment);
		this.groupe = groupe;
		this.preConstruit = preConstruit;
	}

	public Prive(int id, String libelle, String type, String adresse, String lieuDit, Boolean terrain, Boolean batiment,
			Boolean groupe, Boolean preConstruit) {
		super(id, libelle, type, adresse, lieuDit, terrain, batiment);
		this.groupe = groupe;
		this.preConstruit = preConstruit;
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

	@Override
	public String toString() {
		return "Prive [" + (groupe != null ? "groupe=" + groupe + ", " : "")
				+ (preConstruit != null ? "preConstruit=" + preConstruit : "") + "]";
	}
}
