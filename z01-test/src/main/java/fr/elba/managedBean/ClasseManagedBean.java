package fr.elba.managedBean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import antlr.CSharpCodeGenerator;
import fr.elba.model.Classe;
import fr.elba.model.Quartier;
import fr.elba.service.IClasseService;
import fr.elba.service.IQuartierService;

@ManagedBean(name = "ClasseMB")
@SessionScoped
public class ClasseManagedBean {

	// ++++++++++++++++++
	// ---- Services ----
	// ++++++++++++++++++

	@ManagedProperty("#{ClasseService}")
	private IClasseService clSer;

	@ManagedProperty("#{QuartierService}")
	private IQuartierService quSer;

	public void setClSer(IClasseService clSer) {
		this.clSer = clSer;
	}

	public void setQuSer(IQuartierService quSer) {
		this.quSer = quSer;
	}

	// +++++++++++++++++++
	// ---- Variables ----
	// +++++++++++++++++++

	private Classe classe;
	private List<Classe> lClasses;
	private List<String> lLibelles;
	private String selectedQuartier;
	private String selectedClasseSup;

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
		updatelLibelle();
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

	public String getSelectedQuartier() {
		return selectedQuartier;
	}

	public void setSelectedQuartier(String selectedQuartier) {
		this.selectedQuartier = selectedQuartier;
	}

	public String getSelectedClasseSup() {
		return selectedClasseSup;
	}

	public void setSelectedClasseSup(String selectedClasseSup) {
		this.selectedClasseSup = selectedClasseSup;
	}

	// +++++++++++++++++
	// ---- Méthode ----
	// +++++++++++++++++

	public void compteAll() {
		List<Classe> lCl = new ArrayList<>();
		for (Classe cla : lClasses) {
			cla.setCompte(cla.getlFamilles().size());
			lCl.add(cla);
		}
		this.lClasses = lCl;
	}

	public String toAjouter() {
		this.classe = new Classe();
		return "ajouterClasse";
	}

	public void updatelLibelle() {
		this.lLibelles = new ArrayList<>();
		for (Classe claLib : this.lClasses) {
			this.lLibelles.add(claLib.getLibelle());
		}
	}

	public String toListe() {
		compteAll();
		return "listeClasses";
	}

	public String create() {
		Quartier quartier = quSer.getByName(this.selectedQuartier);
		this.classe.setQuartier(quartier);
		this.selectedQuartier = null;
		Classe clasSup = clSer.getByName(selectedClasseSup);
		this.classe.setClasseSup(clasSup);
		this.selectedClasseSup = null;
		clSer.create(this.classe);
		this.lClasses = clSer.getAll();
		updatelLibelle();
		return "detailsClasse";
	}

	public String toDetails(int id) {
		this.classe = clSer.getById(id);
		return "detailsClasse";
	}

	public String toModifier(int id) {
		this.classe = clSer.getById(id);

		if (this.classe.getQuartier() != null) {
			this.selectedQuartier = this.classe.getQuartier().getLibelle();
		} else {
			this.selectedQuartier = null;
		}

		if (this.classe.getClasseSup() != null) {
			this.selectedClasseSup = this.classe.getClasseSup().getLibelle();
		} else {
			this.selectedClasseSup = null;
		}
		return "modifierClasse";
	}

	public String update() {
		Quartier quartier = quSer.getByName(this.selectedQuartier);
		this.classe.setQuartier(quartier);
		this.selectedQuartier = null;
		Classe clasSup = clSer.getByName(selectedClasseSup);
		this.classe.setClasseSup(clasSup);
		this.selectedClasseSup = null;
		clSer.update(this.classe);
		this.lClasses = clSer.getAll();
		updatelLibelle();
		return "detailsClasse";
	}

	public String delete(int id) {
		this.classe = clSer.getById(id);
		this.classe.setClasseSup(null);
		this.classe.setClasseInf(null);
		this.classe.setlFamilles(null);
		this.classe.setlPrives(null);
		this.classe.setQuartier(null);
		clSer.update(this.classe);
		clSer.delete(id);
		this.lClasses = clSer.getAll();
		updatelLibelle();

		return "listeClasses";

	}
}
