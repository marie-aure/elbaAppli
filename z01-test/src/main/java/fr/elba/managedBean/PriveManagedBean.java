package fr.elba.managedBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import fr.elba.model.Classe;
import fr.elba.model.Communautaire;
import fr.elba.model.Famille;
import fr.elba.model.Prive;
import fr.elba.model.Quartier;
import fr.elba.model.RabbitHole;
import fr.elba.service.IClasseService;
import fr.elba.service.IFamilleService;
import fr.elba.service.IPriveService;
import fr.elba.service.IQuartierService;

@ManagedBean(name = "PriveMB")
@SessionScoped
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

	@ManagedProperty("#{FamilleService}")
	private IFamilleService faSer;

	public void setPrSer(IPriveService prSer) {
		this.prSer = prSer;
	}

	public void setQuSer(IQuartierService quSer) {
		this.quSer = quSer;
	}

	public void setClSer(IClasseService clSer) {
		this.clSer = clSer;
	}

	public void setFaSer(IFamilleService faSer) {
		this.faSer = faSer;
	}

	// +++++++++++++++++++
	// ---- Variables ----
	// +++++++++++++++++++

	private Prive prive;
	private List<Prive> lPrives;
	private String selectedQuartier;
	private String selectedClasse;
	private String selectedProprietaire;

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

	public String getSelectedProprietaire() {
		return selectedProprietaire;
	}

	public void setSelectedProprietaire(String selectedProprietaire) {
		this.selectedProprietaire = selectedProprietaire;
	}

	// +++++++++++++++++
	// ---- Méthode ----
	// +++++++++++++++++

	public void create() {
		Quartier quartier = quSer.getByName(this.selectedQuartier);
		this.prive.setQuartier(quartier);
		this.selectedQuartier = null;
		Classe classe = clSer.getByName(this.selectedClasse);
		this.prive.setClasse(classe);
		this.selectedClasse = null;
		this.prive.setTerrain(false);
		this.prive.setBatiment(false);
		prSer.create(this.prive);
	}

	public void details() {
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();
		int id = (int) sessionMap.get("idTerrain");
		this.prive = prSer.getById(id);
	}

	public void modifier() {
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();
		int id = (int) sessionMap.get("idTerrain");

		this.prive = prSer.getById(id);
		if (this.prive.getQuartier() != null) {
			this.selectedQuartier = this.prive.getQuartier().getLibelle();
		}
		if (this.prive.getProprietaire() != null) {
			this.selectedProprietaire = this.prive.getProprietaire().getNom();
		}
		if (this.prive.getClasse() != null) {
			this.selectedClasse = this.prive.getClasse().getLibelle();
		}
	}

	public void update() {

		Quartier quartier = quSer.getByName(this.selectedQuartier);
		this.prive.setQuartier(quartier);

		Famille proprietaire = faSer.getByName(this.selectedProprietaire);
		this.prive.setProprietaire(proprietaire);

		Classe classe = clSer.getByName(this.selectedClasse);
		this.prive.setClasse(classe);

		prSer.update(this.prive);

	}

	public void delete() {
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();
		int id = (int) sessionMap.get("idTerrain");
		this.prive = prSer.getById(id);
		this.prive.setQuartier(null);
		this.prive.setProprietaire(null);
		this.prive.setClasse(null);
		prSer.update(this.prive);
		prSer.delete(id);
		this.lPrives = prSer.getAll();
	}

}
