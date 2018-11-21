package fr.elba.managedBean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import fr.elba.model.Communautaire;
import fr.elba.model.Famille;
import fr.elba.model.LiaisonSITR;
import fr.elba.model.Prive;
import fr.elba.model.Sim;
import fr.elba.model.Terrain;
import fr.elba.service.ILiaisonSITRService;
import fr.elba.service.ISimService;
import fr.elba.service.ITerrainService;

@ManagedBean(name = "CreerEnfantMB")
@ViewScoped
public class CreerEnfantManagedBean {

	// ++++++++++++++++++
	// ---- Services ----
	// ++++++++++++++++++

	@ManagedProperty("#{SimService}")
	private ISimService siSer;

	// @ManagedProperty("#{LiaisonSITRService}")
	// private ILiaisonSITRService lsitrSer;
	//
	// public void setLsitrSer(ILiaisonSITRService lsitrSer) {
	// this.lsitrSer = lsitrSer;
	// }

	public void setSiSer(ISimService siSer) {
		this.siSer = siSer;
	}

	// +++++++++++++++++++
	// ---- Variables ----
	// +++++++++++++++++++

	private Sim parent1;
	private Sim parent2;
	private String parent2Lib;
	private Map<String, Sim> lParents;
	private Sim enfant;
	private boolean afficherFormulaire;
	// private LiaisonSITR lsitr;

	// ++++++++++++++++++++++
	// ---- Constructeur ----
	// ++++++++++++++++++++++

	public CreerEnfantManagedBean() {
		super();
		this.lParents = new HashMap();
		this.enfant = new Sim();
	}

	@PostConstruct
	public void init() {
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();
		this.parent1 = (Sim) sessionMap.get("CreerEnfant");
		this.afficherFormulaire = false;
		if (this.parent1 != null) {
			String sexe;
			if (this.parent1.getSexe().equals("m")) {
				sexe = "f";
			} else {
				sexe = "m";
			}
			if (this.parent1.getCouple() != null && this.parent1.getOrientation().equals("Hétérosexuel")){
				this.parent2 = this.parent1.getCouple();
				this.parent2Lib = this.parent2.getPrenom() + " " + this.parent2.getNom();
			}
			this.lParents = getListParents(sexe);
			System.out.println(this.lParents);
			System.out.println(this.parent2Lib);
		}
	}

	// +++++++++++++++++++++++
	// ---- Getter/Setter ----
	// +++++++++++++++++++++++

	public Sim getParent1() {
		return parent1;
	}

	public void setParent1(Sim parent1) {
		this.parent1 = parent1;
	}

	public Sim getParent2() {
		return parent2;
	}

	public void setParent2(Sim parent2) {
		this.parent2 = parent2;
	}

	public Map<String, Sim> getlParents() {
		return lParents;
	}

	public void setlParents(Map<String, Sim> lParents) {
		this.lParents = lParents;
	}

	public Sim getEnfant() {
		return enfant;
	}

	public void setEnfant(Sim enfant) {
		this.enfant = enfant;
	}

	public boolean isAfficherFormulaire() {
		return afficherFormulaire;
	}

	public void setAfficherFormulaire(boolean afficherFormulaire) {
		this.afficherFormulaire = afficherFormulaire;
	}

	public String getParent2Lib() {
		return parent2Lib;
	}

	public void setParent2Lib(String parent2Lib) {
		this.parent2Lib = parent2Lib;
	}

	// +++++++++++++++++
	// ---- Méthode ----
	// +++++++++++++++++

	public Map<String, Sim> getListParents(String sx) {
		return siSer.getListParents(sx);
	}
	
	public void selectionnerParent2() {
		if (this.lParents.size() > 0) {
			System.out.println(this.parent2Lib);
			this.parent2 = this.lParents.get(this.parent2Lib);
			System.out.println(this.parent2);
			if (this.parent2 != null) {
				this.afficherFormulaire = true;
			}
		} 
	}

}
