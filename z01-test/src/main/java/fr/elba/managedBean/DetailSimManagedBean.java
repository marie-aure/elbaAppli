package fr.elba.managedBean;

import java.io.IOException;
import java.util.ArrayList;
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

@ManagedBean(name = "DetailSimMB")
@ViewScoped
public class DetailSimManagedBean {

	// ++++++++++++++++++
	// ---- Services ----
	// ++++++++++++++++++

	@ManagedProperty("#{SimService}")
	private ISimService siSer;

	@ManagedProperty("#{LiaisonSITRService}")
	private ILiaisonSITRService lsitrSer;

	public void setLsitrSer(ILiaisonSITRService lsitrSer) {
		this.lsitrSer = lsitrSer;
	}

	public void setSiSer(ISimService siSer) {
		this.siSer = siSer;
	}

	// +++++++++++++++++++
	// ---- Variables ----
	// +++++++++++++++++++

	private Sim sim;
	private LiaisonSITR lsitr;
	private List<Sim> enfants;

	// ++++++++++++++++++++++
	// ---- Constructeur ----
	// ++++++++++++++++++++++

	public DetailSimManagedBean() {
		super();
		this.sim = new Sim();
		this.enfants = new ArrayList<>();
	}

	@PostConstruct
	public void init() {
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();
		this.sim = (Sim) sessionMap.get("detailSim");
		if (this.sim != null) {
			this.lsitr = lsitrSer.getBySim(this.sim);
			this.enfants = getListEnfants();
		}

	}

	// +++++++++++++++++++++++
	// ---- Getter/Setter ----
	// +++++++++++++++++++++++

	public Sim getSim() {
		return sim;
	}

	public void setSim(Sim sim) {
		this.sim = sim;
	}

	public LiaisonSITR getLsitr() {
		return lsitr;
	}

	public void setLsitr(LiaisonSITR lsitr) {
		this.lsitr = lsitr;
	}

	public List<Sim> getEnfants() {
		return enfants;
	}

	public void setEnfants(List<Sim> enfants) {
		this.enfants = enfants;
	}

	// +++++++++++++++++
	// ---- Méthode ----
	// +++++++++++++++++

	private List<Sim> getListEnfants() {
		return siSer.getListEnfants(this.sim);
	}
	
	public void toDetailSim(int id) throws IOException {
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = ec.getSessionMap();
		sessionMap.put("detailSim", siSer.getById(id));
		ec.redirect(ec.getRequestContextPath() + "/sim/detailSim.xhtml?faces-redirect=true");
	}
	
	public void marierSim() throws IOException {
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = ec.getSessionMap();
		if (this.sim.getCouple() != null){
			this.sim.setMarie(true);
			Sim epoux = this.sim.getCouple();
			siSer.update(this.sim);
			siSer.update(epoux);
			ec.redirect(ec.getRequestContextPath() + "/sim/detailSim.xhtml?faces-redirect=true");
		}
	}

	public void toCreateChild() throws IOException {
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = ec.getSessionMap();
		sessionMap.put("CreerEnfant", this.sim);
		ec.redirect(ec.getRequestContextPath() + "/sim/creerEnfant.xhtml?faces-redirect=true");
	}
	
	public void toUpdateTraits() throws IOException {
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		ec.redirect(ec.getRequestContextPath() + "/sim/modifierTraits.xhtml?faces-redirect=true");

	}
	
}
