package fr.elba.managedBean;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import fr.elba.model.Communautaire;
import fr.elba.model.Prive;
import fr.elba.model.Terrain;
import fr.elba.service.ITerrainService;

@ManagedBean(name = "TerrainMB")
public class TerrainManagedBean {

	// ++++++++++++++++++
	// ---- Services ----
	// ++++++++++++++++++

	@ManagedProperty("#{TerrainService}")
	private ITerrainService teSer;

	@ManagedProperty("#{CommunautaireMB}")
	private CommunautaireManagedBean communautaireMB;
	
	@ManagedProperty("#{PriveMB}")
	private PriveManagedBean priveMB;
	
	public void setTeSer(ITerrainService teSer) {
		this.teSer = teSer;
	}

	public void setCommunautaireMB(CommunautaireManagedBean communautaireMB) {
		this.communautaireMB = communautaireMB;
	}

	public void setPriveMB(PriveManagedBean priveMB) {
		this.priveMB = priveMB;
	}

	// +++++++++++++++++++
	// ---- Variables ----
	// +++++++++++++++++++

	private Terrain terrain;
	private List<Terrain> lTerrains;

	// ++++++++++++++++++++++
	// ---- Constructeur ----
	// ++++++++++++++++++++++

	public TerrainManagedBean() {
		super();
		this.terrain = new Terrain();
	}

	@PostConstruct
	public void init() {
		this.lTerrains = teSer.getAll();
	}

	// +++++++++++++++++++++++
	// ---- Getter/Setter ----
	// +++++++++++++++++++++++

	public Terrain getTerrain() {
		return terrain;
	}

	public void setTerrain(Terrain terrain) {
		this.terrain = terrain;
	}

	public List<Terrain> getlTerrains() {
		return lTerrains;
	}

	public void setlTerrains(List<Terrain> lTerrains) {
		this.lTerrains = lTerrains;
	}

	// +++++++++++++++++
	// ---- M�thode ----
	// +++++++++++++++++

	public String toDetails(int id) {
		this.terrain = teSer.getById(id);
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();
		sessionMap.put("idTerrain", id);
		if (this.terrain instanceof Communautaire) {
			communautaireMB.details();
			return "detailsCommunautaire";
		} else if (this.terrain instanceof Prive) {
			priveMB.details();
			return "detailsPrive";
		} else {
			return null;
		}
	}
	
	public String toModifier(int id) {
		this.terrain = teSer.getById(id);
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();
		sessionMap.put("idTerrain", id);
		if (this.terrain instanceof Communautaire) {
			communautaireMB.modifier();
			return "modifierCommunautaire";
		} else if (this.terrain instanceof Prive) {
			priveMB.modifier();
			return "modifierPrive";
		} else {
			return null;
		}
	}
}
