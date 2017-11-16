package fr.elba.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "liasonsdvcl")
public class LiaisonDVCL {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private Double valeurMin;
	private Double valeurMax;

	// liaisons
	@ManyToOne
	private Devoir devoir;

	@ManyToOne
	private Classe classe;

	public LiaisonDVCL() {
		super();
	}

	public LiaisonDVCL(Double valeurMin, Double valeurMax, Devoir devoir, Classe classe) {
		super();
		this.valeurMin = valeurMin;
		this.valeurMax = valeurMax;
		this.devoir = devoir;
		this.classe = classe;
	}

	public LiaisonDVCL(int id, Double valeurMin, Double valeurMax, Devoir devoir, Classe classe) {
		super();
		this.id = id;
		this.valeurMin = valeurMin;
		this.valeurMax = valeurMax;
		this.devoir = devoir;
		this.classe = classe;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Double getValeurMin() {
		return valeurMin;
	}

	public void setValeurMin(Double valeurMin) {
		this.valeurMin = valeurMin;
	}

	public Double getValeurMax() {
		return valeurMax;
	}

	public void setValeurMax(Double valeurMax) {
		this.valeurMax = valeurMax;
	}

	public Devoir getDevoir() {
		return devoir;
	}

	public void setDevoir(Devoir devoir) {
		this.devoir = devoir;
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	@Override
	public String toString() {
		return "LiaisonDVCL [id=" + id + ", " + (valeurMin != null ? "valeurMin=" + valeurMin + ", " : "")
				+ (valeurMax != null ? "valeurMax=" + valeurMax + ", " : "")
				+ (devoir != null ? "devoir=" + devoir + ", " : "") + (classe != null ? "classe=" + classe : "") + "]";
	}

}
