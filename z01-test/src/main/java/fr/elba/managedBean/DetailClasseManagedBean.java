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
import fr.elba.service.IFamilleService;
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

	@ManagedProperty("#{FamilleService}")
	private IFamilleService faSer;

	@ManagedProperty("#{ConditionService}")
	private IConditionService coSer;

	public void setClSer(IClasseService clSer) {
		this.clSer = clSer;
	}

	public void setCoSer(IConditionService coSer) {
		this.coSer = coSer;
	}

	public void setFaSer(IFamilleService faSer) {
		this.faSer = faSer;
	}

	// +++++++++++++++++++
	// ---- Variables ----
	// +++++++++++++++++++

	private Classe classe;
	private List<Famille> lFamilles;
	private List<Condition> lConditions;

	// ++++++++++++++++++++++
	// ---- Constructeur ----
	// ++++++++++++++++++++++

	public DetailClasseManagedBean() {
		super();
		this.classe = new Classe();
		this.lFamilles = new ArrayList<>();
		this.lConditions = new ArrayList<>();
	}

	@PostConstruct
	public void init() {
		getClasseAffiche();
		getAllFamille();
		getAllCondition();
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

	public List<Condition> getlConditions() {
		return lConditions;
	}

	public void setlConditions(List<Condition> lConditions) {
		this.lConditions = lConditions;
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

	public void getClasseAffiche() {
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();
		this.classe = (Classe) sessionMap.get("classeEnCoursDetailClasse");
	}

	public void getAllFamille() {
		this.lFamilles = faSer.getAll();
	}

	public void getAllCondition() {
		this.lConditions = coSer.getByClasse(this.classe);
	}

	public void toDetailFamille(int id) throws IOException {
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = ec.getSessionMap();
		Famille famille = faSer.getById(id);

		if (famille != null) {
			sessionMap.put("familleEnCoursDetailFamille", famille);
			ec.redirect(ec.getRequestContextPath() + "/famille/detailFamille.xhtml?faces-redirect=true");
		}

	}
	
	public void toDetailPassage(int id) throws IOException {
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = ec.getSessionMap();
		Passage passage = coSer.getById(id).getPassage();
			
		if (passage != null) {
			sessionMap.put("passageEnCoursDetailPassage", passage);
			ec.redirect(ec.getRequestContextPath() + "/passage/detailPassage.xhtml?faces-redirect=true");
		}

	}
}
