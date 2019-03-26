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

@ManagedBean(name = "ModifierTraitsMB")
@ViewScoped
public class ModifierTraitsManagedBean {

	// ++++++++++++++++++
	// ---- Services ----
	// ++++++++++++++++++

	@ManagedProperty("#{SimService}")
	private ISimService siSer;

	@ManagedProperty("#{LiaisonSITRService}")
	private ILiaisonSITRService lsitrSer;

	@ManagedProperty("#{TraitService}")
	private ITraitService trSer;

	// @ManagedProperty("#{SouhaitService}")
	// private ISouhaitService soSer;
	//
	public void setTrSer(ITraitService trSer) {
		this.trSer = trSer;
	}

	public void setSiSer(ISimService siSer) {
		this.siSer = siSer;
	}

	public void setLsitrSer(ILiaisonSITRService lsitrSer) {
		this.lsitrSer = lsitrSer;
	}

	// public void setSoSer(ISouhaitService soSer) {
	// this.soSer = soSer;
	// }

	// +++++++++++++++++++
	// ---- Variables ----
	// +++++++++++++++++++

	private Sim sim;
	private LiaisonSITR lSITR;
	private LiaisonSITR lSITRParent1;
	private LiaisonSITR lSITRParent2;
	private String trait1;
	private String trait2;
	private String trait3;
	private String trait4;
	private String trait5;
	private List<Trait> lTraits;

	// ++++++++++++++++++++++
	// ---- Constructeur ----
	// ++++++++++++++++++++++

	public ModifierTraitsManagedBean() {
		super();
		this.lTraits = new ArrayList<>();
	}

	@PostConstruct
	public void init() {
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();
		this.sim = (Sim) sessionMap.get("detailSim");
		getLSITRBySim();
		this.lTraits = trSer.getAll();
		if (this.lSITR.getTrait1()!=null) this.trait1 = this.lSITR.getTrait1().getLibelle() + " - " + this.lSITR.getTrait1().getType();
		if (this.lSITR.getTrait2()!=null) this.trait2 = this.lSITR.getTrait2().getLibelle() + " - " + this.lSITR.getTrait2().getType();
		if (this.lSITR.getTrait3()!=null) this.trait3 = this.lSITR.getTrait3().getLibelle() + " - " + this.lSITR.getTrait3().getType();
		if (this.lSITR.getTrait4()!=null) this.trait4 = this.lSITR.getTrait4().getLibelle() + " - " + this.lSITR.getTrait4().getType();
		if (this.lSITR.getTrait5()!=null) this.trait5 = this.lSITR.getTrait5().getLibelle() + " - " + this.lSITR.getTrait5().getType();
		// this.lSouhaits = soSer.getAll();
		// if (this.parent1 != null) {
		// Genre genre;
		// if (this.parent1.getSexe().equals(Genre.HOMME)) {
		// genre = Genre.FEMME;
		// } else {
		// genre = Genre.HOMME;
		// }
		// if (this.parent1.getCouple() != null &&
		// this.parent1.getOrientation().equals(Orientation.HET)) {
		// this.parent2 = this.parent1.getCouple();
		// this.parent2Lib = this.parent2.getPrenom() + " " + this.parent2.getNom();
		// }
		// this.lParents = getListParents(genre);
		// this.enfant.setNom(this.parent1.getFamille().getNom());
		// }
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

	public LiaisonSITR getlSITR() {
		return lSITR;
	}

	public void setlSITR(LiaisonSITR lSITR) {
		this.lSITR = lSITR;
	}

	public LiaisonSITR getlSITRParent1() {
		return lSITRParent1;
	}

	public void setlSITRParent1(LiaisonSITR lSITRParent1) {
		this.lSITRParent1 = lSITRParent1;
	}

	public LiaisonSITR getlSITRParent2() {
		return lSITRParent2;
	}

	public void setlSITRParent2(LiaisonSITR lSITRParent2) {
		this.lSITRParent2 = lSITRParent2;
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

	public List<Trait> getlTraits() {
		return lTraits;
	}

	public void setlTraits(List<Trait> lTraits) {
		this.lTraits = lTraits;
	}

	// +++++++++++++++++
	// ---- Méthode ----
	// +++++++++++++++++

	public void getLSITRBySim() {
		this.lSITR = lsitrSer.getBySim(this.sim);
		this.lSITRParent1 = lsitrSer.getBySim(this.sim.getParent1());
		this.lSITRParent2 = lsitrSer.getBySim(this.sim.getParent2());
	}

	public void modifier() {
		System.out.println(this.trait1);
		System.out.println(this.trait2);
		System.out.println(this.trait3);
		System.out.println(this.trait4);
		System.out.println(this.trait5);
	}

}
