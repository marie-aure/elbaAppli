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
import fr.elba.model.Couple;
import fr.elba.model.LiaisonCOFA;
import fr.elba.model.Pret;
import fr.elba.model.Sim;
import fr.elba.model.Terrain;
import fr.elba.model.Tour;
import fr.elba.service.ICompteService;
import fr.elba.service.ICoupleService;
import fr.elba.service.ILiaisonCOFAService;
import fr.elba.service.IPretService;
import fr.elba.service.ISimService;
import fr.elba.service.ITerrainService;
import fr.elba.service.ITourService;

@ManagedBean(name = "CouplePlannerMB")
@ViewScoped
public class CouplePlannerManagedBean {

	// ++++++++++++++++++
	// ---- Services ----
	// ++++++++++++++++++

	@ManagedProperty("#{CoupleService}")
	private ICoupleService coSer;

	public void setCoSer(ICoupleService coSer) {
		this.coSer = coSer;
	}

	// +++++++++++++++++++
	// ---- Variables ----
	// +++++++++++++++++++

	private List<Couple> lCoupleExistants;

	// ++++++++++++++++++++++
	// ---- Constructeur ----
	// ++++++++++++++++++++++

	public CouplePlannerManagedBean() {
		super();
		this.lCoupleExistants = new ArrayList<Couple>();
	}

	@PostConstruct
	public void init() {

	}

	// +++++++++++++++++++++++
	// ---- Getter/Setter ----
	// +++++++++++++++++++++++

	public List<Couple> getlCoupleExistants() {
		return lCoupleExistants;
	}

	public void setlCoupleExistants(List<Couple> lCoupleExistants) {
		this.lCoupleExistants = lCoupleExistants;
	}

	// +++++++++++++++++
	// ---- Méthode ----
	// +++++++++++++++++

	public void chargerCoupleExistant() {
		coSer.getAllFiance();
	}

}
