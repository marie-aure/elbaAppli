package fr.elba.managedBean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.elba.model.Famille;
import fr.elba.service.IFamilleService;

@ManagedBean(name = "FamilleMB")
@SessionScoped
public class FamilleManagedBean {

	// ++++++++++++++++++
	// ---- Services ----
	// ++++++++++++++++++

	@ManagedProperty("#{FamilleService}")
	private IFamilleService faSer;

	public void setFaSer(IFamilleService faSer) {
		this.faSer = faSer;
	}

	// +++++++++++++++++++
	// ---- Variables ----
	// +++++++++++++++++++

	private Famille famille;
	private List<Famille> lFamilles;
	private List<String> lNoms;

	// ++++++++++++++++++++++
	// ---- Constructeur ----
	// ++++++++++++++++++++++

	public FamilleManagedBean() {
		super();
		this.famille = new Famille();
	}

	@PostConstruct
	public void init() {
		this.lFamilles = faSer.getAll();
		this.lNoms = new ArrayList<>();
		for (Famille famNom : lFamilles) {
			this.lNoms.add(famNom.getNom());
		}
	}

	// +++++++++++++++++++++++
	// ---- Getter/Setter ----
	// +++++++++++++++++++++++

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

	// +++++++++++++++++
	// ---- Méthode ----
	// +++++++++++++++++

	public String voirFamille(int id) {
		this.famille = faSer.getById(id);
		return "detailsFamille";
	}
	
}
