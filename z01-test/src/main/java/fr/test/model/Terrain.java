package fr.test.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Loader;

@Entity
@Table(name = "terrains")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "categorie")
@DiscriminatorValue(value = "terrain")
public class Terrain {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String libelle;
	private String type;
	private String adresse;
	private String lieuDit;
	private Boolean terrain;
	private Boolean batiment;

	// Liaisons
	@ManyToOne
	private Quartier quartier;
	
	@ManyToOne
	private Famille proprietaire;
	
	public Terrain() {
		super();
	}

	public Terrain(String libelle, String type, String adresse, String lieuDit, Boolean terrain, Boolean batiment) {
		super();
		this.libelle = libelle;
		this.type = type;
		this.adresse = adresse;
		this.lieuDit = lieuDit;
		this.terrain = terrain;
		this.batiment = batiment;
	}

	public Terrain(int id, String libelle, String type, String adresse, String lieuDit, Boolean terrain,
			Boolean batiment) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.type = type;
		this.adresse = adresse;
		this.lieuDit = lieuDit;
		this.terrain = terrain;
		this.batiment = batiment;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getLieuDit() {
		return lieuDit;
	}

	public void setLieuDit(String lieuDit) {
		this.lieuDit = lieuDit;
	}

	public Boolean getTerrain() {
		return terrain;
	}

	public void setTerrain(Boolean terrain) {
		this.terrain = terrain;
	}

	public Boolean getBatiment() {
		return batiment;
	}

	public void setBatiment(Boolean batiment) {
		this.batiment = batiment;
	}

	public Quartier getQuartier() {
		return quartier;
	}

	public void setQuartier(Quartier quartier) {
		this.quartier = quartier;
	}

	public Famille getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(Famille proprietaire) {
		this.proprietaire = proprietaire;
	}


}
