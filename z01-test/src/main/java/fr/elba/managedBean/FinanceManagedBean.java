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
import fr.elba.model.Famille;
import fr.elba.model.Pret;
import fr.elba.model.Terrain;
import fr.elba.model.Tour;
import fr.elba.service.ICompteService;
import fr.elba.service.IPretService;
import fr.elba.service.ITerrainService;
import fr.elba.service.ITourService;

@ManagedBean(name = "FinanceMB")
@ViewScoped
public class FinanceManagedBean {

	// ++++++++++++++++++
	// ---- Services ----
	// ++++++++++++++++++

	// @ManagedProperty("#{TourService}")
	// private ITourService toSer;
	//
	// @ManagedProperty("#{TerrainService}")
	// private ITerrainService teSer;
	//
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

	// public void setTeSer(ITerrainService teSer) {
	// this.teSer = teSer;
	// }
	//
	// public void setToSer(ITourService toSer) {
	// this.toSer = toSer;
	// }

	// +++++++++++++++++++
	// ---- Variables ----
	// +++++++++++++++++++

	private Famille famille;
	private List<Compte> lComptes;
	private List<Pret> lPrets;
	private long solde;
	public String message;

	// ++++++++++++++++++++++
	// ---- Constructeur ----
	// ++++++++++++++++++++++

	public FinanceManagedBean() {
		super();
	}

	@PostConstruct
	public void init() {
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();
		this.famille = (Famille) sessionMap.get("familleEnCoursAchatTerrain");
		this.lPrets = getPrets();
		this.lComptes = getComptes();
	}

	// +++++++++++++++++++++++
	// ---- Getter/Setter ----
	// +++++++++++++++++++++++

	public Famille getFamille() {
		return famille;
	}

	public void setFamille(Famille famille) {
		this.famille = famille;
	}

	public long getSolde() {
		return solde;
	}

	public void setSolde(long solde) {
		this.solde = solde;
	}

	// public Tour getEnCours() {
	// return enCours;
	// }
	//
	// public void setEnCours(Tour enCours) {
	// this.enCours = enCours;
	// }
	//
	// public Terrain getResidence() {
	// return residence;
	// }
	//
	// public void setResidence(Terrain residence) {
	// this.residence = residence;
	// }
	//
	// public List<Terrain> getProprietes() {
	// return proprietes;
	// }
	//
	// public void setProprietes(List<Terrain> proprietes) {
	// this.proprietes = proprietes;
	// }
	//
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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	// +++++++++++++++++
	// ---- Méthode ----
	// +++++++++++++++++

	// public Tour tourEnCours() {
	// return toSer.getEnCours();
	// }
	//
	// public List<Terrain> getTerrains() {
	// return teSer.getByOwner(this.enCours.getFamille());
	// }
	//
	public List<Pret> getPrets() {
		return prSer.getByFamily(this.famille);
	}

	public List<Compte> getComptes() {
		return coSer.getByFamily(this.famille);
	}

	public void ouvrirPret() {
		if ((this.famille.getClasse().getLibelle().equals("Pauvre") && this.lPrets.size() < 1 && this.solde < 8000)
				|| (this.famille.getClasse().getLibelle().equals("Modeste") && this.lPrets.size() < 3 && this.solde < 20000)
				|| (this.famille.getClasse().getLibelle().equals("Aisée") && this.lPrets.size() < 5 && this.solde < 50000)
				|| (this.famille.getClasse().getLibelle().equals("Riche") && this.lPrets.size() < 10 && this.solde < 200000)
				|| (this.famille.getClasse().getLibelle().equals("Noblesse"))) {

			Pret pret = new Pret(this.solde, 0, 5, 0, 0, false, this.famille);
			pret.setInteret(Math.round(this.solde * 0.05));
			pret.setRestant(pret.getSomme() + pret.getInteret());
			prSer.create(pret);
			this.lPrets = getPrets();
			this.message = "";
		} else {
			this.message = "Impossible de créer le prêt";
		}
		this.solde = 0;
	}

	public void ouvrirCompte() {
		if ((this.famille.getClasse().getLibelle().equals("Pauvre") && this.lPrets.size() < 1 && this.solde < 8000)
				|| (this.famille.getClasse().getLibelle().equals("Modeste") && this.lPrets.size() < 3 && this.solde < 20000)
				|| (this.famille.getClasse().getLibelle().equals("Aisée") && this.lPrets.size() < 5 && this.solde < 50000)
				|| (this.famille.getClasse().getLibelle().equals("Riche") && this.lPrets.size() < 10 && this.solde < 200000)
				|| (this.famille.getClasse().getLibelle().equals("Noblesse"))) {
			Compte compte = new Compte(this.solde, 5, 0, 0, this.famille);
			coSer.create(compte);
			this.lComptes = getComptes();
			this.message = "";
		}else {
			this.message = "Impossible de créer le compte";
		}
		this.solde = 0;
	}

	public void fermerPret(int id) {
		Pret pret = prSer.getById(id);
		
		if (pret.getRestant()>0 && (pret.getRestant() - pret.getRembourse())>0 ){
			this.message = "Impossible de fermer le pret : non remboursé";
		} else {
			this.message = "";
			pret.setFerme(true);
			prSer.update(pret);
			this.lPrets = getPrets();
		}
	}

	public void fermerCompte(int id) {
		Compte compte = coSer.getById(id);
		if (compte.getMontant()>0){
			this.message = "Impossible de fermer le compte : non vide";
		} else {
			this.message = "";
			coSer.delete(id);
			this.lComptes = getComptes();
		}

	}
	
	public void remboursement(int id){
		Pret pret = prSer.getById(id);		
		pret.setRembourse(Math.min(pret.getRembourse() + this.solde, pret.getRestant()));
		prSer.update(pret);
		
		this.lPrets = getPrets();
		
		this.solde = 0;
		
		
	}

	public void depot(int id){
		Compte compte = coSer.getById(id);
		compte.setDepot(this.solde+compte.getDepot());
		coSer.update(compte);
		this.lComptes = getComptes();
		this.solde = 0;
	}
	
	public void retrait(int id){
		Compte compte = coSer.getById(id);
		compte.setRetrait(this.solde+compte.getRetrait());
		coSer.update(compte);
		this.lComptes = getComptes();
		this.solde = 0;
	}
	
}
