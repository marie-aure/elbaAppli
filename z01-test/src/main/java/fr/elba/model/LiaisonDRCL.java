package fr.elba.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "liasonsdrcl")
public class LiaisonDRCL {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private Double valeurMin;
	private Double valeurMax;

	// liaisons
	@ManyToOne
	private Droit droit;

	@ManyToOne
	private Classe classe;

	public LiaisonDRCL() {
		super();
	}

	public LiaisonDRCL(Double valeurMin, Double valeurMax, Droit droit, Classe classe) {
		super();
		this.valeurMin = valeurMin;
		this.valeurMax = valeurMax;
		this.droit = droit;
		this.classe = classe;
	}

	public LiaisonDRCL(int id, Double valeurMin, Double valeurMax, Droit droit, Classe classe) {
		super();
		this.id = id;
		this.valeurMin = valeurMin;
		this.valeurMax = valeurMax;
		this.droit = droit;
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

	public Droit getDroit() {
		return droit;
	}

	public void setDroit(Droit droit) {
		this.droit = droit;
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
				+ (droit != null ? "droit=" + droit + ", " : "") + (classe != null ? "classe=" + classe : "") + "]";
	}

}
