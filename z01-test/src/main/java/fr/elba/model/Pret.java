package fr.elba.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "prets")
public class Pret {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private long somme;
	private long rembourse;
	private long taux;
	private long interet;
	private long restant;
	private boolean ferme;

	// liaisons
	@ManyToOne
	private Famille famille;

	public Pret() {
		super();
	}

	public Pret(long somme, long rembourse, long taux, long interet, long restant, boolean ferme, Famille famille) {
		super();
		this.somme = somme;
		this.rembourse = rembourse;
		this.taux = taux;
		this.interet = interet;
		this.restant = restant;
		this.ferme = ferme;
		this.famille = famille;
	}

	public Pret(int id, long somme, long rembourse, long taux, long interet, long restant, boolean ferme,
			Famille famille) {
		super();
		this.id = id;
		this.somme = somme;
		this.rembourse = rembourse;
		this.taux = taux;
		this.interet = interet;
		this.restant = restant;
		this.ferme = ferme;
		this.famille = famille;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getSomme() {
		return somme;
	}

	public void setSomme(long somme) {
		this.somme = somme;
	}

	public long getRembourse() {
		return rembourse;
	}

	public void setRembourse(long rembourse) {
		this.rembourse = rembourse;
	}

	public long getTaux() {
		return taux;
	}

	public void setTaux(long taux) {
		this.taux = taux;
	}

	public long getInteret() {
		return interet;
	}

	public void setInteret(long interet) {
		this.interet = interet;
	}

	public long getRestant() {
		return restant;
	}

	public void setRestant(long restant) {
		this.restant = restant;
	}

	public boolean isFerme() {
		return ferme;
	}

	public void setFerme(boolean ferme) {
		this.ferme = ferme;
	}

	public Famille getFamille() {
		return famille;
	}

	public void setFamille(Famille famille) {
		this.famille = famille;
	}

	@Override
	public String toString() {
		return "Pret [id=" + id + ", somme=" + somme + ", rembourse=" + rembourse + ", taux=" + taux + ", interet="
				+ interet + ", restant=" + restant + ", ferme=" + ferme + ", "
				+ (famille != null ? "famille=" + famille : "") + "]";
	}
}
