package fr.elba.managedBean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.elba.model.Classe;
import fr.elba.model.Devoir;
import fr.elba.model.Quartier;
import fr.elba.service.IDevoirService;

@ManagedBean(name = "DevoirMB")
@SessionScoped
public class DevoirManagedBean {

	// ++++++++++++++++++
	// ---- Services ----
	// ++++++++++++++++++

	@ManagedProperty("#{DevoirService}")
	private IDevoirService deSer;

	public void setDeSer(IDevoirService deSer) {
		this.deSer = deSer;
	}

	// +++++++++++++++++++
	// ---- Variables ----
	// +++++++++++++++++++

	private Devoir devoir;
	private List<Devoir> lDevoirs;

	// ++++++++++++++++++++++
	// ---- Constructeur ----
	// ++++++++++++++++++++++

	public DevoirManagedBean() {
		super();
		this.devoir = new Devoir();
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
		return "detailsDevoir";
	}
}
