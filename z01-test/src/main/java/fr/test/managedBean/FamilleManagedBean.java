package fr.test.managedBean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.test.model.Famille;
import fr.test.service.IFamilleService;

@ManagedBean(name = "FamilleMB")
@SessionScoped
public class FamilleManagedBean {

	// -----------------------
	// XXXXX - Service - XXXXX
	// -----------------------

	@ManagedProperty("#{FamilleService}")
	IFamilleService faSer;

	public void setFaSer(IFamilleService faSer) {
		this.faSer = faSer;
	}

	// -------------------------
	// XXXXX - Attributs - XXXXX
	// -------------------------

	private Famille famille;
	private List<Famille> lFamilles;
	private List<String> lNoms;

	// -------------------------------
	// XXXXX - Getters/Setters - XXXXX
	// -------------------------------

	public Famille getFamille() {
		return famille;
	}

	public void setFamille(Famille famille) {
		this.famille = famille;
	}
	
	public List<Famille> getlFamilles() {
		return lFamilles;
	}

	public void setlFamilles(List<Famille> lFamilles) {
		this.lFamilles = lFamilles;
	}

	public List<String> getlNoms() {
		return lNoms;
	}

	public void setlNoms(List<String> lNoms) {
		this.lNoms = lNoms;
	}

	// ----------------------------
	// XXXXX - Constructeur - XXXXX
	// ----------------------------

	public FamilleManagedBean() {
		super();
		this.famille = new Famille();
	}

	@PostConstruct
	public void init() {
		this.lFamilles = faSer.getAll();
		this.lNoms = new ArrayList<>();
		for (Famille fa : lFamilles) {
			this.lNoms.add(fa.getNom());
		}
	}

	// ------------------------
	// XXXXX - Méthodes - XXXXX
	// ------------------------

	public String getAll() {
		this.lFamilles = faSer.getAll();
		this.lNoms = new ArrayList<>();
		for (Famille fa : lFamilles) {
			this.lNoms.add(fa.getNom());
		}
		return "listeFamilles";
	}

	public String create() {
		faSer.create(this.famille);
		this.lFamilles = faSer.getAll();
		this.lNoms = new ArrayList<>();
		for (Famille fa : lFamilles) {
			this.lNoms.add(fa.getNom());
		}
		this.famille = new Famille();
		return "listeFamilles";
	}

	public String toModifierFamille(int id) {
		this.famille = faSer.getById(id);
		return "modifierFamille";
	}

	public String update() {
		faSer.update(this.famille);
		this.lFamilles = faSer.getAll();
		this.lNoms = new ArrayList<>();
		for (Famille fa : lFamilles) {
			this.lNoms.add(fa.getNom());
		}
		this.famille = new Famille();
		return "listeFamilles";
	}

	public String delete(int id) {
		faSer.delete(id);
		this.lFamilles = faSer.getAll();
		this.lNoms = new ArrayList<>();
		for (Famille fa : lFamilles) {
			this.lNoms.add(fa.getNom());
		}
		return "listeFamilles";
	}
}
