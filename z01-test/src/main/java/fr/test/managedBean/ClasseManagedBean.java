package fr.test.managedBean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.test.model.Classe;
import fr.test.service.IClasseService;

@ManagedBean(name = "ClasseMB")
@SessionScoped
public class ClasseManagedBean {

	// -----------------------
	// XXXXX - Service - XXXXX
	// -----------------------

	@ManagedProperty("#{ClasseService}")
	IClasseService clSer;

	public void setclSer(IClasseService clSer) {
		this.clSer = clSer;
	}

	// -------------------------
	// XXXXX - Attributs - XXXXX
	// -------------------------

	private Classe classe;
	private List<Classe> lClasses;
	private List<String> lLibelles;

	// -------------------------------
	// XXXXX - Getters/Setters - XXXXX
	// -------------------------------

	

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}
	
	public List<Classe> getlClasses() {
		return lClasses;
	}

	public void setlClasses(List<Classe> lClasses) {
		this.lClasses = lClasses;
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

	public ClasseManagedBean() {
		super();
		this.classe = new Classe();
	}

	@PostConstruct
	public void init() {
		this.lClasses = clSer.getAll();
		this.lLibelles = new ArrayList<>();
		for (Classe qu : lClasses) {
			this.lLibelles.add(qu.getLibelle());
		}
	}

	// ------------------------
	// XXXXX - Méthodes - XXXXX
	// ------------------------

	public String getAll() {
		this.lClasses = clSer.getAll();
		this.lLibelles = new ArrayList<>();
		for (Classe qu : lClasses) {
			this.lLibelles.add(qu.getLibelle());
		}
		return "listeClasses";
	}

	public String create() {
		clSer.create(this.classe);
		this.lClasses = clSer.getAll();
		this.lLibelles = new ArrayList<>();
		for (Classe cl : lClasses) {
			this.lLibelles.add(cl.getLibelle());
		}
		this.classe = new Classe();
		return "listeClasses";
	}

	public String toModifierClasse(int id) {
		this.classe = clSer.getById(id);
		return "modifierClasse";
	}

	public String update() {
		clSer.update(this.classe);
		this.lClasses = clSer.getAll();
		this.lLibelles = new ArrayList<>();
		for (Classe cl : lClasses) {
			this.lLibelles.add(cl.getLibelle());
		}
		this.classe = new Classe();
		return "listeClasses";
	}

	public String delete(int id) {
		clSer.delete(id);
		this.lClasses = clSer.getAll();
		this.lLibelles = new ArrayList<>();
		for (Classe cl : lClasses) {
			this.lLibelles.add(cl.getLibelle());
		}
		return "listeClasses";
	}
}
