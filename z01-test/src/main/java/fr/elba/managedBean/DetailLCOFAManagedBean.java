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

import fr.elba.model.Classe;
import fr.elba.model.Compte;
import fr.elba.model.Condition;
import fr.elba.model.LiaisonCOFA;
import fr.elba.model.Passage;
import fr.elba.model.Pret;
import fr.elba.model.Sim;
import fr.elba.model.Terrain;
import fr.elba.model.Tour;
import fr.elba.service.IClasseService;
import fr.elba.service.ICompteService;
import fr.elba.service.IConditionService;
import fr.elba.service.ILiaisonCOFAService;
import fr.elba.service.IPassageService;
import fr.elba.service.IPretService;
import fr.elba.service.ISimService;
import fr.elba.service.ITerrainService;
import fr.elba.service.ITourService;

@ManagedBean(name = "DetailLCOFAMB")
@ViewScoped
public class DetailLCOFAManagedBean {

	// ++++++++++++++++++
	// ---- Services ----
	// ++++++++++++++++++

	@ManagedProperty("#{LiaisonCOFAService}")
	private ILiaisonCOFAService lCOFASer;

	public void setlCOFASer(ILiaisonCOFAService lCOFASer) {
		this.lCOFASer = lCOFASer;
	}

	// +++++++++++++++++++
	// ---- Variables ----
	// +++++++++++++++++++

	private LiaisonCOFA lCOFA;

	// ++++++++++++++++++++++
	// ---- Constructeur ----
	// ++++++++++++++++++++++

	public DetailLCOFAManagedBean() {
		super();
	}

	@PostConstruct
	public void init() {
		getLCOFAAffiche();
	}

	// +++++++++++++++++++++++
	// ---- Getter/Setter ----
	// +++++++++++++++++++++++

	public LiaisonCOFA getlCOFA() {
		return lCOFA;
	}

	public void setlCOFA(LiaisonCOFA lCOFA) {
		this.lCOFA = lCOFA;
	}

	// +++++++++++++++++
	// ---- Méthode ----
	// +++++++++++++++++

	public void getLCOFAAffiche() {
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();
		this.lCOFA = (LiaisonCOFA) sessionMap.get("detailLCOFA");
	}

	public void updateLCOFA() throws IOException{
		lCOFASer.update(this.lCOFA);
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		ec.redirect(ec.getRequestContextPath() + "/accueil/accueil.xhtml?faces-redirect=true");
	}
	
}
