package fr.elba.managedBean;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import fr.elba.model.Compte;
import fr.elba.model.Famille;
import fr.elba.model.Pret;
import fr.elba.model.Prive;
import fr.elba.model.Terrain;
import fr.elba.model.Tour;
import fr.elba.service.ICompteService;
import fr.elba.service.IFamilleService;
import fr.elba.service.IPretService;
import fr.elba.service.IPriveService;
import fr.elba.service.ITerrainService;
import fr.elba.service.ITourService;

@ManagedBean(name = "ChoixResidenceMB")
@ViewScoped
public class ChoixResidenceManagedBean {

	// ++++++++++++++++++
	// ---- Services ----
	// ++++++++++++++++++

	@ManagedProperty("#{PriveService}")
	private IPriveService prSer;

	@ManagedProperty("#{FamilleService}")
	private IFamilleService faSer;

	public void setPrSer(IPriveService prSer) {
		this.prSer = prSer;
	}

	public void setFaSer(IFamilleService faSer) {
		this.faSer = faSer;
	}

	// +++++++++++++++++++
	// ---- Variables ----
	// +++++++++++++++++++

	private List<Prive> proprietes;

	// ++++++++++++++++++++++
	// ---- Constructeur ----
	// ++++++++++++++++++++++

	public ChoixResidenceManagedBean() {
		super();
	}

	@PostConstruct
	public void init() {
		this.proprietes = getPrives();
		System.out.println("Hey!");
		System.out.println(this.proprietes.size());
	}

	// +++++++++++++++++++++++
	// ---- Getter/Setter ----
	// +++++++++++++++++++++++

	public List<Prive> getProprietes() {
		return proprietes;
	}

	public void setProprietes(List<Prive> proprietes) {
		this.proprietes = proprietes;
	}

	// +++++++++++++++++
	// ---- Méthode ----
	// +++++++++++++++++

	public List<Prive> getPrives() {
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = ec.getSessionMap();
		Famille famille = (Famille) sessionMap.get("familleEnCoursAchatTerrain");
		return prSer.getByOwner(famille);
	}

	public void choisir(int id) throws IOException {
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = ec.getSessionMap();
		Famille famille = (Famille) sessionMap.get("familleEnCoursAchatTerrain");
		Prive prive = prSer.getById(id);
		famille.setResidence(prive);
		faSer.update(famille);
		ec.redirect(ec.getRequestContextPath() + "/accueil/accueil.xhtml?faces-redirect=true");

	}

}
