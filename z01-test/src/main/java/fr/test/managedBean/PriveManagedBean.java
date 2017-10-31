package fr.test.managedBean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.test.model.Classe;
import fr.test.model.Communautaire;
import fr.test.model.Famille;
import fr.test.model.Prive;
import fr.test.model.Quartier;
import fr.test.model.Terrain;
import fr.test.service.IClasseService;
import fr.test.service.ICommunautaireService;
import fr.test.service.IFamilleService;
import fr.test.service.IPriveService;
import fr.test.service.IQuartierService;
import fr.test.service.ITerrainService;

@ManagedBean(name = "PriveMB")
@SessionScoped
public class PriveManagedBean {

	// -----------------------
	// XXXXX - Service - XXXXX
	// -----------------------

	@ManagedProperty("#{PriveService}")
	IPriveService prSer;

	@ManagedProperty("#{QuartierService}")
	IQuartierService quSer;

	@ManagedProperty("#{ClasseService}")
	IClasseService clSer;

	@ManagedProperty("#{FamilleService}")
	IFamilleService faSer;

	public void setPrSer(IPriveService prSer) {
		this.prSer = prSer;
	}

	public void setQuSer(IQuartierService quSer) {
		this.quSer = quSer;
	}

	public void setClSer(IClasseService clSer) {
		this.clSer = clSer;
	}

	public void setFaSer(IFamilleService faSer) {
		this.faSer = faSer;
	}

	// -------------------------
	// XXXXX - Attributs - XXXXX
	// -------------------------

	private Prive prive;
	private List<Prive> lPrives;
	private String selectedQuartier;
	private String selectedClasse;
	private String selectedProprietaire;

	// -------------------------------
	// XXXXX - Getters/Setters - XXXXX
	// -------------------------------

	public Prive getPrive() {
		return prive;
	}

	public void setPrive(Prive prive) {
		this.prive = prive;
	}

	public List<Prive> getlPrives() {
		return lPrives;
	}

	public void setlPrives(List<Prive> lPrives) {
		this.lPrives = lPrives;
	}

	public String getSelectedQuartier() {
		return selectedQuartier;
	}

	public void setSelectedQuartier(String selectedQuartier) {
		this.selectedQuartier = selectedQuartier;
	}

	public String getSelectedClasse() {
		return selectedClasse;
	}

	public void setSelectedClasse(String selectedClasse) {
		this.selectedClasse = selectedClasse;
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

	public PriveManagedBean() {
		super();
		this.prive = new Prive();
	}

	@PostConstruct
	public void init() {
		this.lPrives = prSer.getAll();
	}

	// ------------------------
	// XXXXX - Méthodes - XXXXX
	// ------------------------

	public String getAll() {
		this.lPrives = prSer.getAll();
		return "index";
	}

	public String create() {
		this.prive.setTerrain(false);
		this.prive.setBatiment(false);
		Quartier qu = quSer.getByName(selectedQuartier);
		this.prive.setQuartier(qu);
		this.selectedQuartier = null;
		Classe cl = clSer.getByName(this.selectedClasse);
		this.prive.setClasse(cl);
		this.selectedClasse = null;
		prSer.create(this.prive);
		this.lPrives = prSer.getAll();
		return "detailsPrive";
	}

	public String delete(int id) {
		prSer.delete(id);
		this.lPrives = prSer.getAll();
		return "index";
	}

	public String toModifierTerrainPrive(int id) {
		this.prive.setId(id);
		return "modifierTerrainPrive";
	}

	public String update() {
		Quartier qu = quSer.getByName(selectedQuartier);
		this.prive.setQuartier(qu);
		this.selectedQuartier = null;
		Classe cl = clSer.getByName(this.selectedClasse);
		this.prive.setClasse(cl);
		this.selectedClasse = null;
		Famille fa = faSer.getByName(this.selectedProprietaire);
		this.prive.setProprietaire(fa);
		this.selectedProprietaire = null;
		prSer.update(this.prive);
		lPrives = prSer.getAll();
		return "index";
	}
}
