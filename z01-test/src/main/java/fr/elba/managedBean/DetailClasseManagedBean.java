package fr.elba.managedBean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import fr.elba.dao.IClasseDao;
import fr.elba.dao.IConditionDao;
import fr.elba.model.Classe;
import fr.elba.model.Compte;
import fr.elba.model.Condition;
import fr.elba.model.Famille;
import fr.elba.model.Passage;
import fr.elba.model.Pret;
import fr.elba.model.Sim;
import fr.elba.model.Terrain;
import fr.elba.model.Tour;
import fr.elba.service.IClasseService;
import fr.elba.service.ICompteService;
import fr.elba.service.IConditionService;
import fr.elba.service.IPassageService;
import fr.elba.service.IPretService;
import fr.elba.service.ISimService;
import fr.elba.service.ITerrainService;
import fr.elba.service.ITourService;

@ManagedBean(name = "DetailClasseMB")
@ViewScoped
public class DetailClasseManagedBean {

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
	private List<Famille> lFamilles;

	// ++++++++++++++++++++++
	// ---- Constructeur ----
	// ++++++++++++++++++++++

	public DetailClasseManagedBean() {
		super();
		this.classe = new Classe();
		this.lFamilles = new ArrayList<>();
	}

	@PostConstruct
	public void init() {
		
	}

	// +++++++++++++++++++++++
	// ---- Getter/Setter ----
	// +++++++++++++++++++++++

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	public List<Famille> getlFamilles() {
		return lFamilles;
	}

	public void setlFamilles(List<Famille> lFamilles) {
		this.lFamilles = lFamilles;
	}

	// +++++++++++++++++
	// ---- Méthode ----
	// +++++++++++++++++

}
