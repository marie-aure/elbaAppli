package fr.elba.managedBean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import fr.elba.model.Classe;
import fr.elba.service.IClasseService;

@ManagedBean(name = "ClasseMB")
public class ClasseManagedBean {

	// ++++++++++++++++++
	// ---- Services ----
	// ++++++++++++++++++

	@ManagedProperty("#{ClasseService}")
	private IClasseService clSer;

	public void setClSer(IClasseService clSer) {
		this.clSer = clSer;
	}

	// +++++++++++++++++++
	// ---- Variables ----
	// +++++++++++++++++++

	private Classe classe;
	private List<Classe> lClasses;
	private List<String> lLibelles;

	// ++++++++++++++++++++++
	// ---- Constructeur ----
	// ++++++++++++++++++++++

	public ClasseManagedBean() {
		super();
		this.classe = new Classe();
	}

	@PostConstruct
	public void init() {
		this.lClasses = clSer.getAll();
		this.lLibelles = new ArrayList<>();
		for (Classe claLib : this.lClasses){
			this.lLibelles.add(claLib.getLibelle());
		}
	}

	// +++++++++++++++++++++++
	// ---- Getter/Setter ----
	// +++++++++++++++++++++++

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe Classe) {
		this.classe = Classe;
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

	// +++++++++++++++++
	// ---- Méthode ----
	// +++++++++++++++++

}
