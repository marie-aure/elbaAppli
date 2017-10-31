package fr.test.managedBean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.test.model.Quartier;
import fr.test.service.IQuartierService;

@ManagedBean(name = "QuartierMB")
@SessionScoped
public class QuartierManagedBean {

	// -----------------------
	// XXXXX - Service - XXXXX
	// -----------------------

	@ManagedProperty("#{QuartierService}")
	IQuartierService quSer;

	public void setQuSer(IQuartierService quSer) {
		this.quSer = quSer;
	}

	// -------------------------
	// XXXXX - Attributs - XXXXX
	// -------------------------

	private Quartier quartier;
	private List<Quartier> lQuartiers;
	private List<String> lLibelles;

	// -------------------------------
	// XXXXX - Getters/Setters - XXXXX
	// -------------------------------

	public Quartier getQuartier() {
		return quartier;
	}

	public void setQuartier(Quartier quartier) {
		this.quartier = quartier;
	}

	public List<Quartier> getlQuartiers() {
		return lQuartiers;
	}

	public void setlQuartiers(List<Quartier> lQuartiers) {
		this.lQuartiers = lQuartiers;
	}

	public List<String> getlLibelles() {
		return lLibelles;
	}

	public void setlLibelles(List<String> lLibelles) {
		this.lLibelles = lLibelles;
	}

	// ----------------------------
	// XXXXX - Constructeur - XXXXX
	// ----------------------------

	public QuartierManagedBean() {
		super();
		this.quartier = new Quartier();
	}

	@PostConstruct
	public void init() {
		this.lQuartiers = quSer.getAll();
		this.lLibelles = new ArrayList<>();
		for (Quartier qu : lQuartiers) {
			this.lLibelles.add(qu.getLibelle());
		}
	}

	// ------------------------
	// XXXXX - Méthodes - XXXXX
	// ------------------------

	public String getAll() {
		this.lQuartiers = quSer.getAll();
		this.lLibelles = new ArrayList<>();
		for (Quartier qu : lQuartiers) {
			this.lLibelles.add(qu.getLibelle());
		}
		return "listeQuartiers";
	}

	public String create() {
		quSer.create(this.quartier);
		this.lQuartiers = quSer.getAll();
		this.lLibelles = new ArrayList<>();
		for (Quartier qu : lQuartiers) {
			this.lLibelles.add(qu.getLibelle());
		}
		this.quartier = new Quartier();
		return "listeQuartiers";
	}

	public String toModifierQuartier(int id) {
		this.quartier = quSer.getById(id);
		return "modifierQuartier";
	}

	public String update() {
		quSer.update(this.quartier);
		this.lQuartiers = quSer.getAll();
		this.lLibelles = new ArrayList<>();
		for (Quartier qu : lQuartiers) {
			this.lLibelles.add(qu.getLibelle());
		}
		this.quartier = new Quartier();
		return "listeQuartiers";
	}

	public String delete(int id) {
		quSer.delete(id);
		this.lQuartiers = quSer.getAll();
		this.lLibelles = new ArrayList<>();
		for (Quartier qu : lQuartiers) {
			this.lLibelles.add(qu.getLibelle());
		}
		return "listeQuartiers";
	}
}
