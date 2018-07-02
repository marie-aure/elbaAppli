package fr.elba.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "conditions")
public class Condition {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private long valeurMin;
	private long valeurMax;

	// liaisons
	@ManyToOne
	private Classe classe;

	@ManyToOne
	private Passage passage;

	@OneToMany(mappedBy = "condition"/* , cascade=CascadeType.ALL */)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<LiaisonCOFA> lLiaisonCOFAs;

	public Condition() {
		super();
	}

	public Condition(long valeurMin, long valeurMax, Classe classe, Passage passage) {
		super();
		this.valeurMin = valeurMin;
		this.valeurMax = valeurMax;
		this.classe = classe;
		this.passage = passage;
	}

	public Condition(int id, long valeurMin, long valeurMax, Classe classe, Passage passage) {
		super();
		this.id = id;
		this.valeurMin = valeurMin;
		this.valeurMax = valeurMax;
		this.classe = classe;
		this.passage = passage;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getValeurMin() {
		return valeurMin;
	}

	public void setValeurMin(long valeurMin) {
		this.valeurMin = valeurMin;
	}

	public long getValeurMax() {
		return valeurMax;
	}

	public void setValeurMax(long valeurMax) {
		this.valeurMax = valeurMax;
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	public Passage getPassage() {
		return passage;
	}

	public void setPassage(Passage passage) {
		this.passage = passage;
	}

	public List<LiaisonCOFA> getlLiaisonCOFAs() {
		return lLiaisonCOFAs;
	}

	public void setlLiaisonCOFAs(List<LiaisonCOFA> lLiaisonCOFAs) {
		this.lLiaisonCOFAs = lLiaisonCOFAs;
	}

	@Override
	public String toString() {
		return "Condition [id=" + id + ", valeurMin=" + valeurMin + ", valeurMax=" + valeurMax + ", "
				+ (classe != null ? "classe=" + classe + ", " : "") + (passage != null ? "passage=" + passage : "")
				+ "]";
	}
	
}
