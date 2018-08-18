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
import fr.elba.model.Famille;
import fr.elba.model.Prive;
import fr.elba.model.Terrain;
import fr.elba.service.ICommunautaireService;
import fr.elba.service.IPriveService;
import fr.elba.service.ITerrainService;

@ManagedBean(name = "AchatTerrainMB")
@SessionScoped
public class AchatTerrainManagedBean {

	// ++++++++++++++++++
	// ---- Services ----
	// ++++++++++++++++++

	@ManagedProperty("#{TerrainService}")
	private ITerrainService teSer;

	@ManagedProperty("#{CommunautaireService}")
	private ICommunautaireService coSer;

	@ManagedProperty("#{PriveService}")
	private IPriveService prSer;

	public void setTeSer(ITerrainService teSer) {
		this.teSer = teSer;
	}

	public void setCoSer(ICommunautaireService coSer) {
		this.coSer = coSer;
	}

	public void setPrSer(IPriveService prSer) {
		this.prSer = prSer;
	}

	// +++++++++++++++++++
	// ---- Variables ----
	// +++++++++++++++++++
	private Famille famille;
	// private Terrain terrain;
	private List<Communautaire> lCommunautaires;
	private List<Prive> lPrives;

	// ++++++++++++++++++++++
	// ---- Constructeur ----
	// ++++++++++++++++++++++

	public AchatTerrainManagedBean() {
		super();
		// this.terrain = new Terrain();
	}

	@PostConstruct
	public void init() {
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();
		this.famille = (Famille) sessionMap.get("familleEnCoursAchatTerrain");
		this.lCommunautaires = coSer.getAVendre();
		this.lPrives = prSer.getAVendre();
	}

	// +++++++++++++++++++++++
	// ---- Getter/Setter ----
	// +++++++++++++++++++++++

	public Famille getFamille() {
		return famille;
	}

	public void setFamille(Famille famille) {
		this.famille = famille;
	}

	public List<Communautaire> getlCommunautaires() {
		return lCommunautaires;
	}

	public void setlCommunautaires(List<Communautaire> lCommunautaires) {
		this.lCommunautaires = lCommunautaires;
	}

	public List<Prive> getlPrives() {
		return lPrives;
	}

	public void setlPrives(List<Prive> lPrives) {
		this.lPrives = lPrives;
	}

	// public Terrain getTerrain() {
	// return terrain;
	// }
	//
	// public void setTerrain(Terrain terrain) {
	// this.terrain = terrain;
	// }

	// +++++++++++++++++
	// ---- Méthode ----
	// +++++++++++++++++

	public void acheter(int id) throws IOException {
		System.out.println(id);
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = ec.getSessionMap();
		Famille famille = (Famille) sessionMap.get("familleEnCoursAchatTerrain");

		Terrain terrain = teSer.getById(id);
		terrain.setProprietaire(famille);
		teSer.update(terrain);

		ec.redirect(ec.getRequestContextPath() + "/accueil/accueil.xhtml?faces-redirect=true");

	}

}
