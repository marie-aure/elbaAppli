package fr.elba.managedBean;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import fr.elba.model.Compte;
import fr.elba.model.Pret;
import fr.elba.model.Terrain;
import fr.elba.model.Tour;
import fr.elba.service.ICompteService;
import fr.elba.service.IPretService;
import fr.elba.service.ITerrainService;
import fr.elba.service.ITourService;

@ManagedBean(name = "AccueilMB")
@ViewScoped
public class AccueilManagedBean {

	// ++++++++++++++++++
	// ---- Services ----
	// ++++++++++++++++++

	@ManagedProperty("#{TourService}")
	private ITourService toSer;

	@ManagedProperty("#{TerrainService}")
	private ITerrainService teSer;

	@ManagedProperty("#{PretService}")
	private IPretService prSer;

	@ManagedProperty("#{CompteService}")
	private ICompteService coSer;

	public void setCoSer(ICompteService coSer) {
		this.coSer = coSer;
	}

	public void setPrSer(IPretService prSer) {
		this.prSer = prSer;
	}

	public void setTeSer(ITerrainService teSer) {
		this.teSer = teSer;
	}

	public void setToSer(ITourService toSer) {
		this.toSer = toSer;
	}

	// +++++++++++++++++++
	// ---- Variables ----
	// +++++++++++++++++++

	private Tour enCours;
	private Terrain residence;
	private List<Terrain> proprietes;
	private List<Compte> lComptes;
	private List<Pret> lPrets;

	// ++++++++++++++++++++++
	// ---- Constructeur ----
	// ++++++++++++++++++++++

	public AccueilManagedBean() {
		super();
	}

	@PostConstruct
	public void init() {
		this.enCours = tourEnCours();
		if (this.enCours.getFamille() != null) {
			this.residence = enCours.getFamille().getResidence();
			this.proprietes = getTerrains();
			this.lPrets = getPrets();
			this.lComptes = getComptes();
		}
	}

	// +++++++++++++++++++++++
	// ---- Getter/Setter ----
	// +++++++++++++++++++++++

	public Tour getEnCours() {
		return enCours;
	}

	public void setEnCours(Tour enCours) {
		this.enCours = enCours;
	}

	public Terrain getResidence() {
		return residence;
	}

	public void setResidence(Terrain residence) {
		this.residence = residence;
	}

	public List<Terrain> getProprietes() {
		return proprietes;
	}

	public void setProprietes(List<Terrain> proprietes) {
		this.proprietes = proprietes;
	}

	public List<Compte> getlComptes() {
		return lComptes;
	}

	public void setlComptes(List<Compte> lComptes) {
		this.lComptes = lComptes;
	}

	public List<Pret> getlPrets() {
		return lPrets;
	}

	public void setlPrets(List<Pret> lPrets) {
		this.lPrets = lPrets;
	}

	// +++++++++++++++++
	// ---- Méthode ----
	// +++++++++++++++++

	public Tour tourEnCours() {
		return toSer.getEnCours();
	}

	public List<Terrain> getTerrains() {
		return teSer.getByOwner(this.enCours.getFamille());
	}

	public List<Pret> getPrets() {
		return prSer.getByFamily(this.enCours.getFamille());
	}

	public List<Compte> getComptes() {
		return coSer.getByFamily(this.enCours.getFamille());
	}

	public void achatTerrain() throws IOException {
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = ec.getSessionMap();
		sessionMap.put("familleEnCoursAchatTerrain", this.enCours.getFamille());
		ec.redirect(ec.getRequestContextPath() + "/terrain/achatTerrain.xhtml?faces-redirect=true");
	}

	public void tourSuivant() {
		System.out.println("TOUR SUIVANT YEAH!!!");
	}

	public void choixResidence() throws IOException {
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = ec.getSessionMap();
		sessionMap.put("familleEnCoursAchatTerrain", this.enCours.getFamille());
		ec.redirect(ec.getRequestContextPath() + "/terrain/choisirResidence.xhtml?faces-redirect=true");
	}

}
