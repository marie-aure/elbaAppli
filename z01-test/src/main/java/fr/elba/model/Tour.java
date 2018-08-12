package fr.elba.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "tour")
public class Tour {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	
	private Boolean enCours;
	private int nb;
	
	// liaisons
	@OneToOne
	private Famille famille;
	
	@ManyToOne
	private Classe classe;
	
	public Tour() {
		super();
	}

	public Tour(Boolean enCours, int nb, Famille famille, Classe classe) {
		super();
		this.enCours = enCours;
		this.nb = nb;
		this.famille = famille;
		this.classe = classe;
	}

	public Tour(int id, Boolean enCours, int nb, Famille famille, Classe classe) {
		super();
		this.id = id;
		this.enCours = enCours;
		this.nb = nb;
		this.famille = famille;
		this.classe = classe;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Boolean getEnCours() {
		return enCours;
	}

	public void setEnCours(Boolean enCours) {
		this.enCours = enCours;
	}

	public int getNb() {
		return nb;
	}

	public void setNb(int nb) {
		this.nb = nb;
	}

	public Famille getFamille() {
		return famille;
	}

	public void setFamille(Famille famille) {
		this.famille = famille;
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	@Override
	public String toString() {
		return "Tour [id=" + id + ", enCours=" + enCours + ", nb=" + nb + ", famille=" + famille + ", classe=" + classe
				+ "]";
	}
	
	

}
