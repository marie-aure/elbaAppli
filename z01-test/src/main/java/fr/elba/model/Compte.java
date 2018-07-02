package fr.elba.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "comptes")
public class Compte {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private long montant;
	private long taux;
	private int depot;
	private int retrait;
	
	// liaisons
	@ManyToOne
	private Famille famille;

	public Compte() {
		super();
	}

	public Compte(long montant, long taux, int depot, int retrait, Famille famille) {
		super();
		this.montant = montant;
		this.taux = taux;
		this.depot = depot;
		this.retrait = retrait;
		this.famille = famille;
	}

	public Compte(int id, long montant, long taux, int depot, int retrait, Famille famille) {
		super();
		this.id = id;
		this.montant = montant;
		this.taux = taux;
		this.depot = depot;
		this.retrait = retrait;
		this.famille = famille;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getMontant() {
		return montant;
	}

	public void setMontant(long montant) {
		this.montant = montant;
	}

	public long getTaux() {
		return taux;
	}

	public void setTaux(long taux) {
		this.taux = taux;
	}

	public int getDepot() {
		return depot;
	}

	public void setDepot(int depot) {
		this.depot = depot;
	}

	public int getRetrait() {
		return retrait;
	}

	public void setRetrait(int retrait) {
		this.retrait = retrait;
	}

	public Famille getFamille() {
		return famille;
	}

	public void setFamille(Famille famille) {
		this.famille = famille;
	}

	@Override
	public String toString() {
		return "Compte [id=" + id + ", montant=" + montant + ", taux=" + taux + ", depot=" + depot + ", retrait="
				+ retrait + ", " + (famille != null ? "famille=" + famille : "") + "]";
	}
	
}
