package fr.test.managedBean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.test.model.Terrain;
import fr.test.service.ITerrainService;

@ManagedBean(name = "TerrainMB")
@SessionScoped
public class TerrainManagedBean {

	// -----------------------
	// XXXXX - Service - XXXXX
	// -----------------------

	@ManagedProperty("#{TerrainService}")
	ITerrainService teSer;

	public void setTeSer(ITerrainService teSer) {
		this.teSer = teSer;
	}

	// -------------------------
	// XXXXX - Attributs - XXXXX
	// -------------------------

	private Terrain terrain;
	private List<Terrain> lTerrains;

	// -------------------------------
	// XXXXX - Getters/Setters - XXXXX
	// -------------------------------

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

	// ----------------------------
	// XXXXX - Constructeur - XXXXX
	// ----------------------------

	public TerrainManagedBean() {
		super();
		this.terrain = new Terrain();
	}

	@PostConstruct
	public void init() {
		this.lTerrains = teSer.getAll();
	}

	// ------------------------
	// XXXXX - Méthodes - XXXXX
	// ------------------------

	public String getAll() {
		this.lTerrains = teSer.getAll();
		return "index";
	}

	public String terrainUpdate(int id) {
		this.terrain = teSer.getById(id);
		if (this.terrain.getTerrain()) {
			this.terrain.setTerrain(false);
		} else {
			this.terrain.setTerrain(true);
		}
		teSer.update(this.terrain);
		this.lTerrains = teSer.getAll();
		return "avancementTerrain";
	}

	public String batimentUpdate(int id) {
		this.terrain = teSer.getById(id);
		if (this.terrain.getBatiment()) {
			this.terrain.setBatiment(false);
		} else {
			this.terrain.setBatiment(true);
		}
		teSer.update(this.terrain);
		this.lTerrains = teSer.getAll();
		return "avancementTerrain";
	}
}
