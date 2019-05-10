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

import fr.elba.model.Devoir;
import fr.elba.model.LiaisonDVCL;
import fr.elba.service.IDevoirService;
import fr.elba.service.ILiaisonDVCLService;
import fr.elba.service.ILiaisonDVCLService;

@ManagedBean(name = "CreerLDVCLMB")
@ViewScoped
public class CreerLDVCLManagedBean {

	// ++++++++++++++++++
	// ---- Services ----
	// ++++++++++++++++++

	@ManagedProperty("#{DevoirService}")
	private IDevoirService dvSer;

	@ManagedProperty("#{LiaisonDVCLService}")
	private ILiaisonDVCLService ldvclSer;

	public void setDrSer(IDevoirService dvSer) {
		this.dvSer = dvSer;
	}

	public void setLdvclSer(ILiaisonDVCLService ldvclSer) {
		this.ldvclSer = ldvclSer;
	}

	// +++++++++++++++++++
	// ---- Variables ----
	// +++++++++++++++++++

	private Devoir devoir;
	private LiaisonDVCL lDvcl;
	private List<LiaisonDVCL> liste;
	private String message;

	// ++++++++++++++++++++++
	// ---- Constructeur ----
	// ++++++++++++++++++++++

	public CreerLDVCLManagedBean() {
		super();
		this.devoir = new Devoir();
		this.liste = new ArrayList<>();
		this.lDvcl = new LiaisonDVCL();
		this.message = "";
	}

	@PostConstruct
	public void init() {
		recupereDevoir();
		if (devoir != null){
		recupereListeDVCL();
		this.message = "";
		} else { this.message = "Pas de devoir en cours";}
	}

	// +++++++++++++++++++++++
	// ---- Getter/Setter ----
	// +++++++++++++++++++++++

	public Devoir getDevoir() {
		return devoir;
	}

	public LiaisonDVCL getlDvcl() {
		return lDvcl;
	}

	public void setlDvcl(LiaisonDVCL lDvcl) {
		this.lDvcl = lDvcl;
	}

	public List<LiaisonDVCL> getListe() {
		return liste;
	}

	public void setListe(List<LiaisonDVCL> liste) {
		this.liste = liste;
	}

	public void setDevoir(Devoir devoir) {
		this.devoir = devoir;
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

	public void recupereDevoir() {
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = ec.getSessionMap();
		this.devoir = (Devoir) sessionMap.get("devoirCreationLDVCL");
	}

	public void recupereListeDVCL() {
		this.liste = ldvclSer.getByDevoir(this.devoir);
	}

	
	

}
