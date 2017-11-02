package fr.elba.managedBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import fr.elba.model.Classe;
import fr.elba.model.Communautaire;
import fr.elba.model.Prive;
import fr.elba.model.Quartier;
import fr.elba.model.RabbitHole;
import fr.elba.service.IClasseService;
import fr.elba.service.IPriveService;
import fr.elba.service.IQuartierService;

@ManagedBean(name = "PriveMB")
public class PriveManagedBean {

	// ++++++++++++++++++
	// ---- Services ----
	// ++++++++++++++++++

	@ManagedProperty("#{PriveService}")
	private IPriveService prSer;

	@ManagedProperty("#{QuartierService}")
	private IQuartierService quSer;

	@ManagedProperty("#{ClasseService}")
	private IClasseService clSer;

	public void setPrSer(IPriveService prSer) {
		this.prSer = prSer;
	}

	public void setQuSer(IQuartierService quSer) {
		this.quSer = quSer;
	}

	public void setClSer(IClasseService clSer) {
		this.clSer = clSer;
	}

	// +++++++++++++++++++
	// ---- Variables ----
	// +++++++++++++++++++

	private Prive prive;
	private List<Prive> lPrives;
	private String selectedQuartier;
	private String selectedClasse;

	// ++++++++++++++++++++++
	// ---- Constructeur ----
	// ++++++++++++++++++++++

	public PriveManagedBean() {
		super();
		this.prive = new Prive();
	}

	@PostConstruct
	public void init() {
		this.lPrives = prSer.getAll();
	}

	// +++++++++++++++++++++++
	// ---- Getter/Setter ----
	// +++++++++++++++++++++++

	public Prive getPrive() {
		return prive;
	}

	public void setPrive(Prive prive) {
		this.prive = prive;
	}

	public List<Prive> getlPrives() {
		return lPrives;
	}

	public void setlPrives(List<Prive> lPrives) {
		this.lPrives = lPrives;
	}

	public String getSelectedQuartier() {
		return selectedQuartier;
	}

	public void setSelectedQuartier(String selectedQuartier) {
		this.selectedQuartier = selectedQuartier;
	}

	public String getSelectedClasse() {
		return selectedClasse;
	}

	public void setSelectedClasse(String selectedClasse) {
		this.selectedClasse = selectedClasse;
	}

	// +++++++++++++++++
	// ---- Méthode ----
	// +++++++++++++++++

	public String create() {
		Quartier quartier = quSer.getByName(this.selectedQuartier);
		this.prive.setQuartier(quartier);
		this.selectedQuartier = null;
		Classe classe = clSer.getByName(this.selectedClasse);
		this.prive.setClasse(classe);
		this.selectedClasse = null;
		this.prive.setTerrain(false);
		this.prive.setBatiment(false);
		prSer.create(this.prive);
		this.prive = new Prive();
		return "detailsPrive";
	}

	public void details(){
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();
		int id = (int) sessionMap.get("idTerrain");
		this.prive = prSer.getById(id);
	}

	public void modifier(){
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();
		int id = (int) sessionMap.get("idTerrain");
		this.prive = prSer.getById(id);
	}
	
}
