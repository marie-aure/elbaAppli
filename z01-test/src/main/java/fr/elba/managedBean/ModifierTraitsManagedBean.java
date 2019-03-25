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
	private String[] selectedTraits;
	private List<Trait> lTraits;

	// ++++++++++++++++++++++
	// ---- Constructeur ----
	// ++++++++++++++++++++++

	public ModifierTraitsManagedBean() {
		super();
		this.selectedTraits = new ArrayList<>();
		this.lTraits = new ArrayList<>();
	}

	@PostConstruct
	public void init() {
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();
		this.sim = (Sim) sessionMap.get("detailSim");
		getLSITRBySim();
		this.lTraits = trSer.getAll();
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

	public String[] getSelectedTraits() {
		return selectedTraits;
	}

	public void setSelectedTraits(String[] selectedTraits) {
		this.selectedTraits = selectedTraits;
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

}
