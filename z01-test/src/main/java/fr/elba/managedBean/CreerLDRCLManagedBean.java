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

import fr.elba.model.Droit;
import fr.elba.model.LiaisonDRCL;
import fr.elba.service.IDroitService;
import fr.elba.service.ILiaisonDRCLService;

@ManagedBean(name = "CreerLDRCLMB")
@ViewScoped
public class CreerLDRCLManagedBean {

	// ++++++++++++++++++
	// ---- Services ----
	// ++++++++++++++++++

	@ManagedProperty("#{DroitService}")
	private IDroitService drSer;

	@ManagedProperty("#{LiaisonDRCLService}")
	private ILiaisonDRCLService ldrclSer;

	public void setDrSer(IDroitService drSer) {
		this.drSer = drSer;
	}

	public void setLdrclSer(ILiaisonDRCLService ldrclSer) {
		this.ldrclSer = ldrclSer;
	}

	// +++++++++++++++++++
	// ---- Variables ----
	// +++++++++++++++++++

	private Droit droit;
	private LiaisonDRCL lDrcl;
	private List<LiaisonDRCL> liste;
	private String message;

	// ++++++++++++++++++++++
	// ---- Constructeur ----
	// ++++++++++++++++++++++

	public CreerLDRCLManagedBean() {
		super();
		this.droit = new Droit();
		this.liste = new ArrayList<>();
		this.lDrcl = new LiaisonDRCL();
		this.message = "";
	}

	@PostConstruct
	public void init() {
		recupereDroit();
		if (droit != null){
		recupereListeDRCL();
		this.message = "";
		} else { this.message = "Pas de droit en cours";}
	}

	// +++++++++++++++++++++++
	// ---- Getter/Setter ----
	// +++++++++++++++++++++++

	public Droit getDroit() {
		return droit;
	}

	public LiaisonDRCL getlDrcl() {
		return lDrcl;
	}

	public void setlDrcl(LiaisonDRCL lDrcl) {
		this.lDrcl = lDrcl;
	}

	public List<LiaisonDRCL> getListe() {
		return liste;
	}

	public void setListe(List<LiaisonDRCL> liste) {
		this.liste = liste;
	}

	public void setDroit(Droit droit) {
		this.droit = droit;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	// +++++++++++++++++
	// ---- Méthode ----
	// +++++++++++++++++

	public void recupereDroit() {
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = ec.getSessionMap();
		this.droit = (Droit) sessionMap.get("droitCreationLDRCl");
	}

	public void recupereListeDRCL() {
		this.liste = ldrclSer.getByDroit(this.droit);
	}

	
	

}
