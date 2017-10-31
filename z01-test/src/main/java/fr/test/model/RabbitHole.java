package fr.test.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "rabbitholes")
public class RabbitHole {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String libelle;

	// Liaisons
		@ManyToMany(mappedBy="lRabbitHoles", fetch=FetchType.LAZY)
	private List<Communautaire> lCommunautaires;

	public RabbitHole() {
		super();
	}

	public RabbitHole(String libelle) {
		super();
		this.libelle = libelle;
	}

	public RabbitHole(int id, String libelle) {
		super();
		this.id = id;
		this.libelle = libelle;
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

	public List<Communautaire> getlCommunautaires() {
		return lCommunautaires;
	}

	public void setlCommunautaires(List<Communautaire> lCommunautaires) {
		this.lCommunautaires = lCommunautaires;
	}

	@Override
	public String toString() {
		return "RabbitHole [id=" + id + ", " + (libelle != null ? "libelle=" + libelle + ", " : "")
				+ (lCommunautaires != null ? "lCommunautaires=" + lCommunautaires : "") + "]";
	}

}
