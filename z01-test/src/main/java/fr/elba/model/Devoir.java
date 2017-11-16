package fr.elba.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "devoirs")
public class Devoir {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String categorie;
	private String libelle;
	private String precisions;
	private String commentaire;

	// liaisons
	@OneToMany(mappedBy = "devoir", cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<LiaisonDVCL> lLiaisonDVCLs;

	public Devoir() {
		super();
	}

	public Devoir(String categorie, String libelle, String precisions, String commentaire) {
		super();
		this.categorie = categorie;
		this.libelle = libelle;
		this.precisions = precisions;
		this.commentaire = commentaire;
	}

	public Devoir(int id, String categorie, String libelle, String precisions, String commentaire) {
		super();
		this.id = id;
		this.categorie = categorie;
		this.libelle = libelle;
		this.precisions = precisions;
		this.commentaire = commentaire;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getPrecisions() {
		return precisions;
	}

	public void setPrecisions(String precisions) {
		this.precisions = precisions;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public List<LiaisonDVCL> getlLiaisonDVCLs() {
		return lLiaisonDVCLs;
	}

	public void setlLiaisonDVCLs(List<LiaisonDVCL> lLiaisonDVCLs) {
		this.lLiaisonDVCLs = lLiaisonDVCLs;
	}

	@Override
	public String toString() {
		return "Devoir [id=" + id + ", " + (categorie != null ? "categorie=" + categorie + ", " : "")
				+ (libelle != null ? "libelle=" + libelle + ", " : "")
				+ (precisions != null ? "precisions=" + precisions + ", " : "")
				+ (commentaire != null ? "commentaire=" + commentaire : "") + "]";
	}

}
