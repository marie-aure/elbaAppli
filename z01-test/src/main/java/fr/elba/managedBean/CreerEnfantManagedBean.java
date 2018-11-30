package fr.elba.managedBean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
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
import fr.elba.model.Espece;
import fr.elba.model.Famille;
import fr.elba.model.Genre;
import fr.elba.model.LiaisonSITR;
import fr.elba.model.Orientation;
import fr.elba.model.Prive;
import fr.elba.model.Sim;
import fr.elba.model.Terrain;
import fr.elba.model.Trait;
import fr.elba.service.ILiaisonSITRService;
import fr.elba.service.ISimService;
import fr.elba.service.ITerrainService;
import fr.elba.service.ITraitService;

@ManagedBean(name = "CreerEnfantMB")
@ViewScoped
public class CreerEnfantManagedBean {

	// ++++++++++++++++++
	// ---- Services ----
	// ++++++++++++++++++

	@ManagedProperty("#{SimService}")
	private ISimService siSer;

	@ManagedProperty("#{LiaisonSITRService}")
	private ILiaisonSITRService lsitrSer;

	@ManagedProperty("#{TraitService}")
	private ITraitService trSer;

	public void setTrSer(ITraitService trSer) {
		this.trSer = trSer;
	}

	public void setLsitrSer(ILiaisonSITRService lsitrSer) {
		this.lsitrSer = lsitrSer;
	}

	public void setSiSer(ISimService siSer) {
		this.siSer = siSer;
	}

	// +++++++++++++++++++
	// ---- Variables ----
	// +++++++++++++++++++

	private Sim parent1;
	private Sim parent2;
	private String parent2Lib;
	private Integer parent2Id;
	private Map<String, Integer> lParents;
	private Sim enfant;
	private LiaisonSITR enfantTrait;
	private boolean afficherFormulaire;
	private boolean heritier = true;
	private boolean legitime = true;
	private LiaisonSITR parent1trait;
	private LiaisonSITR parent2trait;
	private List<Trait> lTraits;
	// private LiaisonSITR lsitr;

	// ++++++++++++++++++++++
	// ---- Constructeur ----
	// ++++++++++++++++++++++

	public CreerEnfantManagedBean() {
		super();
		this.lParents = new HashMap();
		this.enfant = new Sim();
		this.enfantTrait = new LiaisonSITR();
	}

	@PostConstruct
	public void init() {
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();
		this.parent1 = (Sim) sessionMap.get("CreerEnfant");
		this.afficherFormulaire = false;
		this.lTraits = trSer.getAll();
		if (this.parent1 != null) {
			String sexe;
			if (this.parent1.getSexe().equals("m")) {
				sexe = "f";
			} else {
				sexe = "m";
			}
			if (this.parent1.getCouple() != null && this.parent1.getOrientation().equals("Hétérosexuel")) {
				this.parent2 = this.parent1.getCouple();
				this.parent2Lib = this.parent2.getPrenom() + " " + this.parent2.getNom();
			}
			this.lParents = getListParents(sexe);
			this.enfant.setNom(this.parent1.getFamille().getNom());
		}
	}

	// +++++++++++++++++++++++
	// ---- Getter/Setter ----
	// +++++++++++++++++++++++

	public Sim getParent1() {
		return parent1;
	}

	public void setParent1(Sim parent1) {
		this.parent1 = parent1;
	}

	public Sim getParent2() {
		return parent2;
	}

	public void setParent2(Sim parent2) {
		this.parent2 = parent2;
	}

	public Map<String, Integer> getlParents() {
		return lParents;
	}

	public void setlParents(Map<String, Integer> lParents) {
		this.lParents = lParents;
	}

	public Sim getEnfant() {
		return enfant;
	}

	public void setEnfant(Sim enfant) {
		this.enfant = enfant;
	}

	public boolean isAfficherFormulaire() {
		return afficherFormulaire;
	}

	public void setAfficherFormulaire(boolean afficherFormulaire) {
		this.afficherFormulaire = afficherFormulaire;
	}

	public Integer getParent2Id() {
		return parent2Id;
	}

	public void setParent2Id(Integer parent2Id) {
		this.parent2Id = parent2Id;
	}

	public boolean isHeritier() {
		return heritier;
	}

	public void setHeritier(boolean heritier) {
		this.heritier = heritier;
	}

	public boolean isLegitime() {
		return legitime;
	}

	public void setLegitime(boolean legitime) {
		this.legitime = legitime;
	}

	public LiaisonSITR getParent1trait() {
		return parent1trait;
	}

	public void setParent1trait(LiaisonSITR parent1trait) {
		this.parent1trait = parent1trait;
	}

	public LiaisonSITR getParent2trait() {
		return parent2trait;
	}

	public void setParent2trait(LiaisonSITR parent2trait) {
		this.parent2trait = parent2trait;
	}

	public LiaisonSITR getEnfantTrait() {
		return enfantTrait;
	}

	public void setEnfantTrait(LiaisonSITR enfantTrait) {
		this.enfantTrait = enfantTrait;
	}

	public List<Trait> getlTraits() {
		return lTraits;
	}

	public void setlTraits(List<Trait> lTraits) {
		this.lTraits = lTraits;
	}

	public String getParent2Lib() {
		return parent2Lib;
	}

	public void setParent2Lib(String parent2Lib) {
		this.parent2Lib = parent2Lib;
	}

	// +++++++++++++++++
	// ---- Méthode ----
	// +++++++++++++++++

	public Map<String, Integer> getListParents(String sx) {
		return siSer.getListParents(sx);
	}

	public Espece[] getEspeceValues() {
		return Espece.values();
	}

	public Genre[] getGenreValues() {
		return Genre.values();
	}

	public Orientation[] getOrientationValues() {
		return Orientation.values();
	}

	public void selectionnerParent2() {
		if (this.parent2Id != null) {
			System.out.println(this.parent2Id);
			this.parent2 = siSer.getById(this.parent2Id);
			this.parent1trait = lsitrSer.getBySim(this.parent1);
			if (this.parent2 != null) {
				this.afficherFormulaire = true;
				this.parent2trait = lsitrSer.getBySim(this.parent2);
			}
		}
	}

	public void creerEnfant() {
		System.out.println("Création enfant");
		this.enfant.setParent1(this.parent1);
		this.enfant.setParent2(this.parent2);
		this.enfant.setMarie(false);
		this.enfant.setRealise(false);
		this.enfant.setMort(false);
		
	}

}
