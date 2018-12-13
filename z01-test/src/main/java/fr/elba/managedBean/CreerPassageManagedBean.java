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

import fr.elba.model.Compte;
import fr.elba.model.Passage;
import fr.elba.model.Pret;
import fr.elba.model.Sim;
import fr.elba.model.Terrain;
import fr.elba.model.Tour;
import fr.elba.service.ICompteService;
import fr.elba.service.IPassageService;
import fr.elba.service.IPretService;
import fr.elba.service.ISimService;
import fr.elba.service.ITerrainService;
import fr.elba.service.ITourService;

@ManagedBean(name = "CreerPassageMB")
@ViewScoped
public class CreerPassageManagedBean {

	// ++++++++++++++++++
	// ---- Services ----
	// ++++++++++++++++++

	@ManagedProperty("#{PassageService}")
	private IPassageService paSer;

	public void setPaSer(IPassageService paSer) {
		this.paSer = paSer;
	}

	// +++++++++++++++++++
	// ---- Variables ----
	// +++++++++++++++++++

	private Passage passage;
	private List<String> lCategories;

	// ++++++++++++++++++++++
	// ---- Constructeur ----
	// ++++++++++++++++++++++

	public CreerPassageManagedBean() {
		super();
		this.passage = new Passage();
		this.lCategories = new ArrayList<>();
	}

	@PostConstruct
	public void init() {
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

	public List<String> getlCategories() {
		return lCategories;
	}

	public void setlCategories(List<String> lCategories) {
		this.lCategories = lCategories;
	}

	
	// +++++++++++++++++
	// ---- Méthode ----
	// +++++++++++++++++

	public void getAllCategorie() {
		this.lCategories = paSer.getAllCategorie();
	}

//	public void toDetailPassage(int id) throws IOException {
//		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
//		Map<String, Object> sessionMap = ec.getSessionMap();
//		this.passage = paSer.getById(id);
//		if (this.passage != null) {
//			sessionMap.put("passageEnCoursDetailPassage", this.passage);
//			ec.redirect(ec.getRequestContextPath() + "/passage/detailPassage.xhtml?faces-redirect=true");
//		}
//	}
//
//	public void toCreerPassage() throws IOException {
//		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
//		ec.redirect(ec.getRequestContextPath() + "/passage/creerPassage.xhtml?faces-redirect=true");
//	}
}
