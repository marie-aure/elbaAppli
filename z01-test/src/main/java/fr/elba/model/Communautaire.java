package fr.elba.model;

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

	// liaisons
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name="l_communautaire_rabbithole",joinColumns={@JoinColumn(name="id_terrain")}, inverseJoinColumns = {@JoinColumn(name="id_rabbithole")})
	private List<RabbitHole> lRabbitHoles;

	public Communautaire() {
		super();
	}

	public Communautaire(String libelle, String type, String adresse, String lieuDit, Boolean terrain, Boolean batiment,
			String fonction) {
		super(libelle, type, adresse, lieuDit, terrain, batiment);
		this.fonction = fonction;
	}

	public Communautaire(int id, String libelle, String type, String adresse, String lieuDit, Boolean terrain,
			Boolean batiment, String fonction) {
		super(id, libelle, type, adresse, lieuDit, terrain, batiment);
		this.fonction = fonction;
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

	@Override
	public String toString() {
		return "Communautaire [" + (fonction != null ? "fonction=" + fonction : "") + "]";
	}

}
