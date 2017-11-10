package fr.elba.managedBean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.elba.model.Quartier;
import fr.elba.service.IQuartierService;

@ManagedBean(name = "QuartierMB")
@SessionScoped
public class QuartierManagedBean {

	// ++++++++++++++++++
	// ---- Services ----
	// ++++++++++++++++++

	@ManagedProperty("#{QuartierService}")
	private IQuartierService quSer;

	public void setQuSer(IQuartierService quSer) {
		this.quSer = quSer;
	}

	// +++++++++++++++++++
	// ---- Variables ----
	// +++++++++++++++++++

	private Quartier quartier;
	private List<Quartier> lQuartiers;
	private List<String> lLibelles;

	// ++++++++++++++++++++++
	// ---- Constructeur ----
	// ++++++++++++++++++++++

	public QuartierManagedBean() {
		super();
		this.quartier = new Quartier();
	}

	@PostConstruct
	public void init() {
		this.lQuartiers = quSer.getAll();
		updateLibelle();
	}

	// +++++++++++++++++++++++
	// ---- Getter/Setter ----
	// +++++++++++++++++++++++

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

	// +++++++++++++++++
	// ---- Méthode ----
	// +++++++++++++++++

	public void updateLibelle() {
		this.lLibelles = new ArrayList<>();
		for (Quartier quaLib : lQuartiers) {
			this.lLibelles.add(quaLib.getLibelle());
		}
	}
	
	public String create() {
		quSer.create(this.quartier);
		this.quartier = new Quartier();
		this.lQuartiers = quSer.getAll();
		updateLibelle();
		return "listeQuartiers";
	}
	
	public String toModifier(int id) {
		this.quartier = quSer.getById(id);
		return "modifierQuartier";
	}
	
	public String update() {
		quSer.update(this.quartier);
		this.lQuartiers = quSer.getAll();
		updateLibelle();
		return "listeQuartiers";
	}
	
	public String delete(int id) {
		quSer.delete(id);
		this.lQuartiers = quSer.getAll();
		updateLibelle();
		return "listeQuartiers";
	}
}
