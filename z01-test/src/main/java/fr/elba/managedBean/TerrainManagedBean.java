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
import fr.elba.model.Terrain;
import fr.elba.service.ITerrainService;

@ManagedBean(name = "TerrainMB")
@SessionScoped
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
	// ---- Méthode ----
	// +++++++++++++++++

	public void toAjouter() throws IOException {
		communautaireMB.setCommunautaire(new Communautaire());
		priveMB.setPrive(new Prive());
		ExternalContext ec = FacesContext.getCurrentInstance()
		        .getExternalContext();
	
		    ec.redirect(ec.getRequestContextPath()
		            + "/terrain/ajouterTerrain.xhtml?faces-redirect=true");
	}
	
	public String createCommunautaire() {
		communautaireMB.create();
		this.lTerrains = teSer.getAll();
		communautaireMB.setCommunautaire(new Communautaire());
		return "detailsCommunautaire?faces-redirect=true";
	}
	
	public String createPrive() {
		priveMB.create();
		this.lTerrains = teSer.getAll();
		priveMB.setPrive(new Prive());
		return "detailsPrive?faces-redirect=true";
	}
	
	public String toDetails(int id) {
		this.terrain = teSer.getById(id);
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();
		sessionMap.put("idTerrain", id);
		if (this.terrain instanceof Communautaire) {
			communautaireMB.details();
			return "detailsCommunautaire?faces-redirect=true";
		} else if (this.terrain instanceof Prive) {
			priveMB.details();
			return "detailsPrive?faces-redirect=true";
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
			return "modifierCommunautaire?faces-redirect=true";
		} else if (this.terrain instanceof Prive) {
			priveMB.modifier();
			return "modifierPrive?faces-redirect=true";
		} else {
			return null;
		}
	}

	public String updateCommunautaire() {
		communautaireMB.update();
		this.lTerrains = teSer.getAll();
		return "detailsCommunautaire?faces-redirect=true";
	}
	
	public String updatePrive() {
		priveMB.update();
		this.lTerrains = teSer.getAll();
		return "detailsPrive?faces-redirect=true";
	}
	
	public String updateTerrainCommunautaire() {
		communautaireMB.updateTerrain();
		this.lTerrains = teSer.getAll();
		return "detailsCommunautaire?faces-redirect=true";
	}
	
	public String updateTerrainPrive() {
		priveMB.updateTerrain();
		this.lTerrains = teSer.getAll();
		return "detailsPrive?faces-redirect=true";
	}
	
	public String updateBatimentCommunautaire() {
		communautaireMB.updateBatiment();
		this.lTerrains = teSer.getAll();
		return "detailsCommunautaire?faces-redirect=true";
	}
	
	public String updateBatimentPrive() {
		priveMB.updateBatiment();
		this.lTerrains = teSer.getAll();
		return "detailsPrive?faces-redirect=true";
	}

	public String toDelete(int id) {
		this.terrain = teSer.getById(id);
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();
		sessionMap.put("idTerrain", id);
		if (this.terrain instanceof Communautaire) {
			communautaireMB.delete();
		} else if (this.terrain instanceof Prive) {
			priveMB.delete();
		}
		this.lTerrains = teSer.getAll();
		return "listeTerrains?faces-redirect=true";
	}
}
