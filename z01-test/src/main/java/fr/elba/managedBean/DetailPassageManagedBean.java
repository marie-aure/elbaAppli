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

@ManagedBean(name = "DetailPassageMB")
@ViewScoped
public class DetailPassageManagedBean {

	// ++++++++++++++++++
	// ---- Services ----
	// ++++++++++++++++++

	@ManagedProperty("#{PassageService}")
	private IPassageService paSer;

	@ManagedProperty("#{ConditionService}")
	private IConditionService coSer;

	@ManagedProperty("#{ClasseService}")
	private IClasseService clSer;

	public void setClSer(IClasseService clSer) {
		this.clSer = clSer;
	}

	public void setCoSer(IConditionService coSer) {
		this.coSer = coSer;
	}

	public void setPaSer(IPassageService paSer) {
		this.paSer = paSer;
	}

	// +++++++++++++++++++
	// ---- Variables ----
	// +++++++++++++++++++

	private Passage passage;
	private List<Condition> lConditions;
	private List<String> lClasses;
	private Condition condition;
	private String libClasse;
	private Boolean confirmation;

	// ++++++++++++++++++++++
	// ---- Constructeur ----
	// ++++++++++++++++++++++

	public DetailPassageManagedBean() {
		super();
		this.passage = new Passage();
		this.condition = new Condition();
		this.lConditions = new ArrayList<>();
		this.lClasses = new ArrayList<>();
	}

	@PostConstruct
	public void init() {
		getPassageAffiche();
		getAllCondition();
		getAllClasse();
		this.confirmation = false;
	}

	// +++++++++++++++++++++++
	// ---- Getter/Setter ----
	// +++++++++++++++++++++++

	public Passage getPassage() {
		return passage;
	}

	public void setPassage(Passage passage) {
		this.passage = passage;
	}

	public Condition getCondition() {
		return condition;
	}

	public void setCondition(Condition condition) {
		this.condition = condition;
	}

	public List<String> getlClasses() {
		return lClasses;
	}

	public void setlClasses(List<String> lClasses) {
		this.lClasses = lClasses;
	}

	public String getLibClasse() {
		return libClasse;
	}

	public void setLibClasse(String libClasse) {
		this.libClasse = libClasse;
	}

	public Boolean getConfirmation() {
		return confirmation;
	}

	public void setConfirmation(Boolean confirmation) {
		this.confirmation = confirmation;
	}

	public List<Condition> getlConditions() {
		return lConditions;
	}

	public void setlConditions(List<Condition> lConditions) {
		this.lConditions = lConditions;
	}

	// +++++++++++++++++
	// ---- Méthode ----
	// +++++++++++++++++

	public void getPassageAffiche() {
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();
		this.passage = (Passage) sessionMap.get("passageEnCoursDetailPassage");
	}

	public void getAllCondition() {
		this.lConditions = coSer.getByPassage(this.passage);
	}

	public void getAllClasse() {
		List<Classe> liste = clSer.getAll();
		if (liste.size() > 0) {
			for (Classe classe : liste) {
				this.lClasses.add(classe.getLibelle());
			}
		}
	}

	public void toModifierCondition(int id) throws IOException {
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = ec.getSessionMap();
		Condition condition = coSer.getById(id);
		if (condition != null) {
			sessionMap.put("conditionEnCoursModifierCondition", condition);
			ec.redirect(ec.getRequestContextPath() + "/condition/modifierCondition.xhtml?faces-redirect=true");
		}
	}
	
	
	public void CreerCondition() {
		if (!this.libClasse.equals("")) {
			this.condition.setClasse(clSer.getByName(this.libClasse));
			this.condition.setPassage(this.passage);
			coSer.create(this.condition);
			getAllCondition();
		}
	}
	
	public void confirmationSuppression() {
		this.confirmation = true;
	}
	
	public void supprimerPassage() throws IOException {
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = ec.getSessionMap();
		
		getAllCondition();
		if(this.lConditions.size()>0) {
			for(Condition condition : this.lConditions) {
				coSer.delete(condition.getId());
			}
		}
		
		paSer.delete(this.passage.getId());
		sessionMap.put("passageEnCoursDetailPassage", new Passage());
		ec.redirect(ec.getRequestContextPath() + "/passage/passages.xhtml?faces-redirect=true");

	}
	
	public void annulerSuppression() {
		this.confirmation = false;
	}
}
