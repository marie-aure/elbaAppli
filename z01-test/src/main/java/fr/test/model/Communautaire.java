package fr.test.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
@DiscriminatorValue("communautaire")
public class Communautaire extends Terrain {

	private String fonction;

	// Liaisons
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "l_communautaires_rabbitholes", joinColumns = {
			@JoinColumn(name = "id_communautaires") }, inverseJoinColumns = { @JoinColumn(name = "id_rabbitholes") })
	private List<RabbitHole> lRabbitHoles;

	public Communautaire() {
		super();
	}

	public Communautaire(String libelle, String type, String adresse, String lieuDit, Boolean terrain, Boolean batiment,
			String fonction, List<RabbitHole> lRabbitHoles) {
		super(libelle, type, adresse, lieuDit, terrain, batiment);
		this.fonction = fonction;
		this.lRabbitHoles = lRabbitHoles;
	}

	public Communautaire(int id, String libelle, String type, String adresse, String lieuDit, Boolean terrain,
			Boolean batiment, String fonction, List<RabbitHole> lRabbitHoles) {
		super(id, libelle, type, adresse, lieuDit, terrain, batiment);
		this.fonction = fonction;
		this.lRabbitHoles = lRabbitHoles;
	}

	public String getFonction() {
		return fonction;
	}

	public void setFonction(String fonction) {
		this.fonction = fonction;
	}

	public List<RabbitHole> getlRabbitHoles() {
		return lRabbitHoles;
	}

	public void setlRabbitHoles(List<RabbitHole> lRabbitHoles) {
		this.lRabbitHoles = lRabbitHoles;
	}

}
