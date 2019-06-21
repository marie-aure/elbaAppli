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

@ManagedBean(name = "SelectionHeritierMB")
@ViewScoped
public class SelectionHeritierManagedBean {

	// ++++++++++++++++++
	// ---- Services ----
	// ++++++++++++++++++

	@ManagedProperty("#{SimService}")
	private ISimService siSer;

	public void setSiSer(ISimService siSer) {
		this.siSer = siSer;
	}

	// +++++++++++++++++++
	// ---- Variables ----
	// +++++++++++++++++++

	private Sim sim;
	private List<Sim> famille;

	// ++++++++++++++++++++++
	// ---- Constructeur ----
	// ++++++++++++++++++++++

	public SelectionHeritierManagedBean() {
		super();
		this.sim = new Sim();
		this.famille = new ArrayList<>();
	}

	@PostConstruct
	public void init() {
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();
		this.sim = (Sim) sessionMap.get("detailSim");
		if (this.sim != null) {
			this.famille = siSer.getHeritierPossibleByFamille(this.sim.getFamille());
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

	public List<Sim> getFamille() {
		return famille;
	}

	public void setFamille(List<Sim> famille) {
		this.famille = famille;
	}

	// +++++++++++++++++
	// ---- Méthode ----
	// +++++++++++++++++

	private void selectionner(int id) throws IOException {
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = ec.getSessionMap();

		Sim heritier = siSer.getById(id);
		if (heritier != null) {
			heritier.setHeritier(true);
			siSer.update(heritier);
			ec.redirect(ec.getRequestContextPath() + "/sim/detailSim.xhtml?faces-redirect=true");	
		}
		
	}

}
