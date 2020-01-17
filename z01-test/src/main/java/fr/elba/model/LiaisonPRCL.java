package fr.elba.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "liasonsprcl")
public class LiaisonPRCL {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	// liaisons
	@ManyToOne
	private Profession profession;

	@ManyToOne
	private Classe classe;

	public LiaisonPRCL() {
		super();
	}

	public LiaisonPRCL(Profession profession, Classe classe) {
		super();
		this.profession = profession;
		this.classe = classe;
	}

	public LiaisonPRCL(int id, Profession profession, Classe classe) {
		super();
		this.id = id;
		this.profession = profession;
		this.classe = classe;
	}

}
