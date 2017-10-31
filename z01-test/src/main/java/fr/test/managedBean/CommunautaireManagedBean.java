package fr.test.managedBean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.springframework.jmx.export.annotation.ManagedAttribute;

import fr.test.model.Communautaire;
import fr.test.model.Famille;
import fr.test.model.Quartier;
import fr.test.model.RabbitHole;
import fr.test.model.Terrain;
import fr.test.service.ICommunautaireService;
import fr.test.service.IFamilleService;
import fr.test.service.IQuartierService;
import fr.test.service.IRabbitHoleService;
import fr.test.service.ITerrainService;

@ManagedBean(name = "CommunautaireMB")
@SessionScoped
public class CommunautaireManagedBean {

	// -----------------------
	// XXXXX - Service - XXXXX
	// -----------------------

	@ManagedProperty("#{CommunautaireService}")
	ICommunautaireService coSer;

	@ManagedProperty("#{RabbitHoleService}")
	IRabbitHoleService rhSer;

	@ManagedProperty("#{QuartierService}")
	IQuartierService quSer;

	@ManagedProperty("#{FamilleService}")
	IFamilleService faSer;

	public void setCoSer(ICommunautaireService coSer) {
		this.coSer = coSer;
	}

	public void setRhSer(IRabbitHoleService rhSer) {
		this.rhSer = rhSer;
	}

	public void setQuSer(IQuartierService quSer) {
		this.quSer = quSer;
	}

	public void setFaSer(IFamilleService faSer) {
		this.faSer = faSer;
	}

	// -------------------------
	// XXXXX - Attributs - XXXXX
	// -------------------------

	private Communautaire communautaire;
	private List<Communautaire> lCommunautaires;
	private List<String> selectedRabbitHoles;
	private String selectedQuartier;
	private String selectedProprietaire;

	// -------------------------------
	// XXXXX - Getters/Setters - XXXXX
	// -------------------------------

	public Communautaire getCommunautaire() {
		return communautaire;
	}

	public void setCommunautaire(Communautaire communautaire) {
		this.communautaire = communautaire;
	}

	public List<Communautaire> getlCommunautaires() {
		return lCommunautaires;
	}

	public void setlCommunautaires(List<Communautaire> lCommunautaires) {
		this.lCommunautaires = lCommunautaires;
	}

	public List<String> getSelectedRabbitHoles() {
		return selectedRabbitHoles;
	}

	public void setSelectedRabbitHoles(List<String> selectedRabbitHoles) {
		this.selectedRabbitHoles = selectedRabbitHoles;
	}

	public String getSelectedQuartier() {
		return selectedQuartier;
	}

	public void setSelectedQuartier(String selectedQuartier) {
		this.selectedQuartier = selectedQuartier;
	}

	public String getSelectedProprietaire() {
		return selectedProprietaire;
	}

	public void setSelectedProprietaire(String selectedProprietaire) {
		this.selectedProprietaire = selectedProprietaire;
	}

	// ----------------------------
	// XXXXX - Constructeur - XXXXX
	// ----------------------------

	public CommunautaireManagedBean() {
		super();
		this.communautaire = new Communautaire();
		this.selectedRabbitHoles = new ArrayList<>();
	}

	@PostConstruct
	public void init() {
		this.lCommunautaires = coSer.getAll();
	}

	// ------------------------
	// XXXXX - Méthodes - XXXXX
	// ------------------------

	public String getAll() {
		this.lCommunautaires = coSer.getAll();
		return "index";
	}

	public String create() {
		this.communautaire.setTerrain(false);
		this.communautaire.setBatiment(false);
		List<RabbitHole> lRabbitHoles = new ArrayList<>();
		for (String libelle : this.selectedRabbitHoles) {
			lRabbitHoles.add(rhSer.getByName(libelle));
		}
		this.communautaire.setlRabbitHoles(lRabbitHoles);
		this.selectedRabbitHoles = null;
		Quartier qu = quSer.getByName(this.selectedQuartier);
		this.communautaire.setQuartier(qu);
		this.selectedQuartier = null;
		coSer.create(this.communautaire);
		this.lCommunautaires = coSer.getAll();
		return "detailsCommunautaire";
	}

	public String delete(int id) {
		coSer.delete(id);
		this.lCommunautaires = coSer.getAll();
		return "index";
	}

	public String toModifierTerrainCommunautaire(int id) {
		this.communautaire.setId(id);
		return "modifierTerrainCommunautaire";
	}

	public String update() {
		List<RabbitHole> lRabbitHoles = new ArrayList<>();
		for (String libelle : this.selectedRabbitHoles) {
			lRabbitHoles.add(rhSer.getByName(libelle));
		}
		this.communautaire.setlRabbitHoles(lRabbitHoles);
		this.selectedRabbitHoles = null;
		Quartier qu = quSer.getByName(this.selectedQuartier);
		this.communautaire.setQuartier(qu);
		this.selectedQuartier = null;
		Famille fa = faSer.getByName(this.selectedProprietaire);
		this.communautaire.setProprietaire(fa);
		this.selectedProprietaire = null;
		coSer.update(this.communautaire);
		lCommunautaires = coSer.getAll();
		return "index";
	}
}
