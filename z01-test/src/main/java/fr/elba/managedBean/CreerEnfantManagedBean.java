package fr.elba.managedBean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
import fr.elba.model.Souhait;
import fr.elba.model.Terrain;
import fr.elba.model.Trait;
import fr.elba.service.IFamilleService;
import fr.elba.service.ILiaisonSITRService;
import fr.elba.service.ISimService;
import fr.elba.service.ISouhaitService;
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

	@ManagedProperty("#{FamilleService}")
	private IFamilleService faSer;

	@ManagedProperty("#{SouhaitService}")
	private ISouhaitService soSer;

	public void setTrSer(ITraitService trSer) {
		this.trSer = trSer;
	}

	public void setLsitrSer(ILiaisonSITRService lsitrSer) {
		this.lsitrSer = lsitrSer;
	}

	public void setSiSer(ISimService siSer) {
		this.siSer = siSer;
	}

	public void setSoSer(ISouhaitService soSer) {
		this.soSer = soSer;
	}

	public void setFaSer(IFamilleService faSer) {
		this.faSer = faSer;
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
	private LiaisonSITR parent1trait;
	private LiaisonSITR parent2trait;
	private List<Trait> lTraits;
	private List<Souhait> lSouhaits;
	private String trait1;
	private String trait2;
	private String trait3;
	private String trait4;
	private String trait5;
	private String souhait;
	// private LiaisonSITR lsitr;

	// ++++++++++++++++++++++
	// ---- Constructeur ----
	// ++++++++++++++++++++++

	public CreerEnfantManagedBean() {
		super();
		this.lParents = new HashMap();
		this.enfant = new Sim();
		this.enfant.setLegitime(true);
		this.enfant.setHeritier(true);
		this.enfantTrait = new LiaisonSITR();
	}

	@PostConstruct
	public void init() {
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();
		this.parent1 = (Sim) sessionMap.get("CreerEnfant");
		this.afficherFormulaire = false;
		this.lTraits = trSer.getAll();
		this.lSouhaits = soSer.getAll();
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

	public List<Souhait> getlSouhaits() {
		return lSouhaits;
	}

	public void setlSouhaits(List<Souhait> lSouhaits) {
		this.lSouhaits = lSouhaits;
	}

	public String getTrait1() {
		return trait1;
	}

	public void setTrait1(String trait1) {
		this.trait1 = trait1;
	}

	public String getTrait2() {
		return trait2;
	}

	public void setTrait2(String trait2) {
		this.trait2 = trait2;
	}

	public String getTrait3() {
		return trait3;
	}

	public void setTrait3(String trait3) {
		this.trait3 = trait3;
	}

	public String getTrait4() {
		return trait4;
	}

	public void setTrait4(String trait4) {
		this.trait4 = trait4;
	}

	public String getTrait5() {
		return trait5;
	}

	public void setTrait5(String trait5) {
		this.trait5 = trait5;
	}

	public String getSouhait() {
		return souhait;
	}

	public void setSouhait(String souhait) {
		this.souhait = souhait;
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

	public void creerEnfant() throws IOException {
		System.out.println("Création enfant");
		this.enfant.setParent1(this.parent1);
		this.enfant.setParent2(this.parent2);
		this.enfant.setMarie(false);
		this.enfant.setRealise(false);
		this.enfant.setMort(false);
		if (this.enfant.isLegitime()) {
			this.enfant.setFamille(this.parent1.getFamille());
			this.enfant.setFamilleOrigine(this.parent1.getFamille());
		} else {
			Famille illegitime = faSer.getByName("Illégitime");
			this.enfant.setFamille(illegitime);
			this.enfant.setFamilleOrigine(illegitime);
		}
		this.enfant.setSouhait(soSer.getByName(this.souhait));
		siSer.create(this.enfant);
		heritageTrait();
		this.enfantTrait.setSim(this.enfant);
		lsitrSer.create(this.enfantTrait);
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = ec.getSessionMap();
		sessionMap.put("detailSim", this.enfant);
		ec.redirect(ec.getRequestContextPath() + "/sim/detailSim.xhtml?faces-redirect=true");
	}

	public void heritageTrait() {
		Set<Trait> lTraits = new HashSet<>();
		lTraits.add(this.parent1trait.getTrait1());
		lTraits.add(this.parent1trait.getTrait2());
		lTraits.add(this.parent1trait.getTrait3());
		lTraits.add(this.parent1trait.getTrait4());
		lTraits.add(this.parent1trait.getTrait5());
		lTraits.add(this.parent2trait.getTrait1());
		lTraits.add(this.parent2trait.getTrait2());
		lTraits.add(this.parent2trait.getTrait3());
		lTraits.add(this.parent2trait.getTrait4());
		lTraits.add(this.parent2trait.getTrait5());
		this.enfantTrait.setTrait1(trSer.getByName(this.trait1));
		if (lTraits.contains(this.enfantTrait.getTrait1())) {
			this.enfantTrait.setHeritage1(true);
		} else {
			this.enfantTrait.setHeritage1(false);
		}
		this.enfantTrait.setTrait1(trSer.getByName(this.trait2));
		if (lTraits.contains(this.enfantTrait.getTrait2())) {
			this.enfantTrait.setHeritage2(true);
		} else {
			this.enfantTrait.setHeritage2(false);
		}
		this.enfantTrait.setTrait1(trSer.getByName(this.trait3));
		if (lTraits.contains(this.enfantTrait.getTrait3())) {
			this.enfantTrait.setHeritage3(true);
		} else {
			this.enfantTrait.setHeritage3(false);
		}
		this.enfantTrait.setTrait1(trSer.getByName(this.trait4));
		if (lTraits.contains(this.enfantTrait.getTrait4())) {
			this.enfantTrait.setHeritage4(true);
		} else {
			this.enfantTrait.setHeritage4(false);
		}
		this.enfantTrait.setTrait1(trSer.getByName(this.trait5));
		if (lTraits.contains(this.enfantTrait.getTrait5())) {
			this.enfantTrait.setHeritage5(true);
		} else {
			this.enfantTrait.setHeritage5(false);
		}
	}

}
