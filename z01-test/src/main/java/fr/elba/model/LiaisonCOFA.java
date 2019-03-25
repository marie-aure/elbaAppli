package fr.elba.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "liaisoncofa")
public class LiaisonCOFA {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String progression;
	private long valeur;
	private String commentaire;
	private boolean valide;

	// liaisons
	@ManyToOne
	private Famille famille;

	@ManyToOne
	private Condition condition;

	public LiaisonCOFA() {
		super();
	}

	public LiaisonCOFA(String progression, long valeur, String commentaire, boolean valide, Famille famille,
			Condition condition) {
		super();
		this.progression = progression;
		this.valeur = valeur;
		this.commentaire = commentaire;
		this.valide = valide;
		this.famille = famille;
		this.condition = condition;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProgression() {
		return progression;
	}

	public void setProgression(String progression) {
		this.progression = progression;
	}

	public long getValeur() {
		return valeur;
	}

	public void setValeur(long valeur) {
		this.valeur = valeur;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public boolean isValide() {
		return valide;
	}

	public void setValide(boolean valide) {
		this.valide = valide;
	}

	public Famille getFamille() {
		return famille;
	}

	public void setFamille(Famille famille) {
		this.famille = famille;
	}

	public Condition getCondition() {
		return condition;
	}

	public void setCondition(Condition condition) {
		this.condition = condition;
	}

	@Override
	public String toString() {
		return "LiaisonCOFA [" + (progression != null ? "progression=" + progression + ", " : "") + "valeur=" + valeur
				+ ", " + (commentaire != null ? "commentaire=" + commentaire + ", " : "") + "valide=" + valide + ", "
				+ (famille != null ? "famille=" + famille + ", " : "")
				+ (condition != null ? "condition=" + condition : "") + "]";
	}

}
