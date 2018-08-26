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
@Table(name = "traits")
public class Trait {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String libelle;
	private String type;

	// liaisons
	@OneToMany(mappedBy = "trait1"/* , cascade=CascadeType.ALL */)
	@LazyCollection(LazyCollectionOption.TRUE)
	private List<LiaisonSITR> lLiaisonSITRs1;

	@OneToMany(mappedBy = "trait2"/* , cascade=CascadeType.ALL */)
	@LazyCollection(LazyCollectionOption.TRUE)
	private List<LiaisonSITR> lLiaisonSITRs2;

	@OneToMany(mappedBy = "trait3"/* , cascade=CascadeType.ALL */)
	@LazyCollection(LazyCollectionOption.TRUE)
	private List<LiaisonSITR> lLiaisonSITRs3;

	@OneToMany(mappedBy = "trait4"/* , cascade=CascadeType.ALL */)
	@LazyCollection(LazyCollectionOption.TRUE)
	private List<LiaisonSITR> lLiaisonSITRs4;

	@OneToMany(mappedBy = "trait5"/* , cascade=CascadeType.ALL */)
	@LazyCollection(LazyCollectionOption.TRUE)
	private List<LiaisonSITR> lLiaisonSITRs5;

	public Trait() {
		super();
	}

	public Trait(String libelle, String type) {
		super();
		this.libelle = libelle;
		this.type = type;
	}

	public Trait(int id, String libelle, String type) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.type = type;
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

	public List<LiaisonSITR> getlLiaisonSITRs1() {
		return lLiaisonSITRs1;
	}

	public void setlLiaisonSITRs1(List<LiaisonSITR> lLiaisonSITRs1) {
		this.lLiaisonSITRs1 = lLiaisonSITRs1;
	}

	public List<LiaisonSITR> getlLiaisonSITRs2() {
		return lLiaisonSITRs2;
	}

	public void setlLiaisonSITRs2(List<LiaisonSITR> lLiaisonSITRs2) {
		this.lLiaisonSITRs2 = lLiaisonSITRs2;
	}

	public List<LiaisonSITR> getlLiaisonSITRs3() {
		return lLiaisonSITRs3;
	}

	public void setlLiaisonSITRs3(List<LiaisonSITR> lLiaisonSITRs3) {
		this.lLiaisonSITRs3 = lLiaisonSITRs3;
	}

	public List<LiaisonSITR> getlLiaisonSITRs4() {
		return lLiaisonSITRs4;
	}

	public void setlLiaisonSITRs4(List<LiaisonSITR> lLiaisonSITRs4) {
		this.lLiaisonSITRs4 = lLiaisonSITRs4;
	}

	public List<LiaisonSITR> getlLiaisonSITRs5() {
		return lLiaisonSITRs5;
	}

	public void setlLiaisonSITRs5(List<LiaisonSITR> lLiaisonSITRs5) {
		this.lLiaisonSITRs5 = lLiaisonSITRs5;
	}

	@Override
	public String toString() {
		return "Trait [id=" + id + ", " + (libelle != null ? "libelle=" + libelle + ", " : "")
				+ (type != null ? "type=" + type : "") + "]";
	}

}
