package fr.elba.managedBean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.elba.model.Classe;
import fr.elba.model.Devoir;
import fr.elba.model.LiaisonDVCL;
import fr.elba.model.Quartier;
import fr.elba.service.IClasseService;
import fr.elba.service.IDevoirService;

@ManagedBean(name = "DevoirMB")
@SessionScoped
public class DevoirManagedBean {

	// ++++++++++++++++++
	// ---- Services ----
	// ++++++++++++++++++

	@ManagedProperty("#{DevoirService}")
	private IDevoirService deSer;

	@ManagedProperty("#{ClasseMB}")
	private ClasseManagedBean classeMB;

	@ManagedProperty("#{LiaisonDVCLMB}")
	private LiaisonDVCLManagedBean lDVCLMB;

	@ManagedProperty("#{ClasseService}")
	private IClasseService clSer;

	public void setDeSer(IDevoirService deSer) {
		this.deSer = deSer;
	}

	public void setClasseMB(ClasseManagedBean classeMB) {
		this.classeMB = classeMB;
	}

	public void setlDVCLMB(LiaisonDVCLManagedBean lDVCLMB) {
		this.lDVCLMB = lDVCLMB;
	}

	public void setClSer(IClasseService clSer) {
		this.clSer = clSer;
	}

	// +++++++++++++++++++
	// ---- Variables ----
	// +++++++++++++++++++

	private Devoir devoir;
	private List<Devoir> lDevoirs;
	private HashMap<Classe, LiaisonDVCL> liaisons;

	// ++++++++++++++++++++++
	// ---- Constructeur ----
	// ++++++++++++++++++++++

	public DevoirManagedBean() {
		super();
		this.devoir = new Devoir();
		this.liaisons = new HashMap<>();
	}

	@PostConstruct
	public void init() {
		this.lDevoirs = deSer.getAll();
	}

	// +++++++++++++++++++++++
	// ---- Getter/Setter ----
	// +++++++++++++++++++++++

	public Devoir getDevoir() {
		return devoir;
	}

	public void setDevoir(Devoir devoir) {
		this.devoir = devoir;
	}

	public List<Devoir> getlDevoirs() {
		return lDevoirs;
	}

	public void setlDevoirs(List<Devoir> lDevoirs) {
		this.lDevoirs = lDevoirs;
	}

	public HashMap<Classe, LiaisonDVCL> getLiaisons() {
		return liaisons;
	}

	public void setLiaisons(HashMap<Classe, LiaisonDVCL> liaisons) {
		this.liaisons = liaisons;
	}

	// +++++++++++++++++
	// ---- Méthode ----
	// +++++++++++++++++

	public String create() {
		deSer.create(this.devoir);
		this.lDevoirs = deSer.getAll();
		return "detailsDevoir";
	}

	public String toDetails(int id) {
		this.devoir = deSer.getById(id);
		updateLiaison();
		return "detailsDevoir";
	}

	public String toModifier(int id) {
		this.devoir = deSer.getById(id);
		return "modifierDevoir";
	}

	public String update() {
		deSer.update(this.devoir);
		this.lDevoirs = deSer.getAll();
		return "detailsDevoir";
	}

	public void updateLiaison() {
		this.liaisons = new HashMap<>();
		for (Classe classe : classeMB.getlClasses()) {
			this.liaisons.put(classe, null);
			for (LiaisonDVCL liaisonDVCL : this.devoir.getlLiaisonDVCLs()) {
				if (liaisonDVCL.getClasse().getId() == classe.getId()) {
					this.liaisons.put(classe, liaisonDVCL);
				}
			}

		}
	}

	public String toAjouterLiaisonDVCL(int id) {
		lDVCLMB.getLiaisonDVCL().setClasse(clSer.getById(id));
		lDVCLMB.getLiaisonDVCL().setDevoir(this.devoir);
		return "ajouterLiaisonDVCL";
	}
}
