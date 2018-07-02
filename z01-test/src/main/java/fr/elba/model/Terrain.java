package fr.elba.model;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "terrains")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "categorie")
@DiscriminatorValue("terrain")
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

	// liaisons
	@ManyToOne(/* cascade=CascadeType.ALL */)
	private Quartier quartier;

	@ManyToOne(/* cascade=CascadeType.ALL */)
	private Famille proprietaire;

	public Terrain() {
		super();
	}

	public Terrain(String libelle, String type, String adresse, String lieuDit, Boolean terrain, Boolean batiment,
			Quartier quartier, Famille proprietaire) {
		super();
		this.libelle = libelle;
		this.type = type;
		this.adresse = adresse;
		this.lieuDit = lieuDit;
		this.terrain = terrain;
		this.batiment = batiment;
		this.quartier = quartier;
		this.proprietaire = proprietaire;
	}

	public Terrain(int id, String libelle, String type, String adresse, String lieuDit, Boolean terrain,
			Boolean batiment, Quartier quartier, Famille proprietaire) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.type = type;
		this.adresse = adresse;
		this.lieuDit = lieuDit;
		this.terrain = terrain;
		this.batiment = batiment;
		this.quartier = quartier;
		this.proprietaire = proprietaire;
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

	@Override
	public String toString() {
		return "Terrain [id=" + id + ", " + (libelle != null ? "libelle=" + libelle + ", " : "")
				+ (type != null ? "type=" + type + ", " : "") + (adresse != null ? "adresse=" + adresse + ", " : "")
				+ (lieuDit != null ? "lieuDit=" + lieuDit + ", " : "")
				+ (terrain != null ? "terrain=" + terrain + ", " : "")
				+ (batiment != null ? "batiment=" + batiment + ", " : "")
				+ (quartier != null ? "quartier=" + quartier + ", " : "")
				+ (proprietaire != null ? "proprietaire=" + proprietaire : "") + "]";
	}

}
