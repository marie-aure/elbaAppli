package fr.elba.managedBean;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import fr.elba.model.Communautaire;
import fr.elba.model.Prive;
import fr.elba.model.Sim;
import fr.elba.model.Terrain;
import fr.elba.service.ISimService;
import fr.elba.service.ITerrainService;

@ManagedBean(name = "SimMB")
@SessionScoped
public class SimManagedBean {

	// ++++++++++++++++++
	// ---- Services ----
	// ++++++++++++++++++

	@ManagedProperty("#{SimService}")
	private ISimService siSer;

	@ManagedProperty("#{StarterMB}")
	private StarterManagedBean starterMB;

	public void setSiSer(ISimService siSer) {
		this.siSer = siSer;
	}

	public void setStarterMB(StarterManagedBean starterMB) {
		this.starterMB = starterMB;
	}

	// +++++++++++++++++++
	// ---- Variables ----
	// +++++++++++++++++++

	private Sim sim;
	private List<Sim> lSims;

	// ++++++++++++++++++++++
	// ---- Constructeur ----
	// ++++++++++++++++++++++

	public SimManagedBean() {
		super();
		this.sim = new Sim();
	}

	@PostConstruct
	public void init() {
//		this.lSims = siSer.getAll();
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

	public List<Sim> getlSims() { 
		return lSims;
	}

	public void setlSims(List<Sim> lSims) {
		this.lSims = lSims;
	}
	
	// +++++++++++++++++
	// ---- Méthode ----
	// +++++++++++++++++

	public void toGenerer() throws IOException {
		System.out.println("jemarche");
		ExternalContext ec = FacesContext.getCurrentInstance()
		        .getExternalContext();
	
		    ec.redirect(ec.getRequestContextPath()
		            + "/sim/genererStarter.xhtml?faces-redirect=true");
	}
	
	
}
