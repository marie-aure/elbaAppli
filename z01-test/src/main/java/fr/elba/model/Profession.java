package fr.elba.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "professions")
public class Profession {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String libelle;

	// liaisons
	@OneToMany(mappedBy = "profession"/* , cascade = CascadeType.ALL */)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Sim> lSims;

	public Profession() {
		super();
	}

	public Profession(String libelle) {
		super();
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

	public List<Sim> getlSims() {
		return lSims;
	}

	public void setlSims(List<Sim> lSims) {
		this.lSims = lSims;
	}

	@Override
	public String toString() {
		return "Profession [id=" + id + ", " + (libelle != null ? "libelle=" + libelle : "") + "]";
	}

}
