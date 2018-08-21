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

import fr.elba.dao.IFamilleDao;
import fr.elba.model.Compte;
import fr.elba.model.Pret;
import fr.elba.model.Terrain;
import fr.elba.model.Tour;
import fr.elba.service.ICompteService;
import fr.elba.service.IFamilleService;
import fr.elba.service.IPretService;
import fr.elba.service.ITerrainService;
import fr.elba.service.ITourService;

@ManagedBean(name = "TourSuivantMB")
@SessionScoped
public class TourSuivantManagedBean {

	// ++++++++++++++++++
	// ---- Services ----
	// ++++++++++++++++++

	@ManagedProperty("#{TourService}")
	private ITourService toSer;

	@ManagedProperty("#{FamilleProperty}")
	private IFamilleService faSer;

	public void setFaSer(IFamilleService faSer) {
		this.faSer = faSer;
	}

	public void setToSer(ITourService toSer) {
		this.toSer = toSer;
	}

	// +++++++++++++++++++
	// ---- Variables ----
	// +++++++++++++++++++

	private Tour enCours;
	private int argentIG;
	private String message;

	// ++++++++++++++++++++++
	// ---- Constructeur ----
	// ++++++++++++++++++++++

	public TourSuivantManagedBean() {
		super();
	}

	@PostConstruct
	public void init() {
		this.enCours = tourEnCours();
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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getArgentIG() {
		return argentIG;
	}

	public void setArgentIG(int argentIG) {
		this.argentIG = argentIG;
	}

	// +++++++++++++++++
	// ---- Méthode ----
	// +++++++++++++++++

	public Tour tourEnCours() {
		return toSer.getEnCours();
	}

	public void goToPage2() throws IOException {
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		ec.redirect(ec.getRequestContextPath() + "/accueil/tourSuivant2.xhtml?faces-redirect=true");
	}

	public void goToPage3() throws IOException {
		if (this.argentIG > 0) {
			this.message = "";
			this.enCours.getFamille().setArgentIG(argentIG);
			ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
			ec.redirect(ec.getRequestContextPath() + "/accueil/tourSuivant3.xhtml?faces-redirect=true");
		} else {
			this.message = "Remplir l'argent IG";
		}
	}

	public void goToPage4() throws IOException {
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		ec.redirect(ec.getRequestContextPath() + "/accueil/tourSuivant4.xhtml?faces-redirect=true");
	}

	public void goToPage5() throws IOException {
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		ec.redirect(ec.getRequestContextPath() + "/accueil/tourSuivant5.xhtml?faces-redirect=true");
	}

	public void confirmer() throws IOException {
		System.out.println("Confirmation");
		faSer.update(this.enCours.getFamille());
		this.enCours.setNb(this.enCours.getNb() + 1);
		this.enCours.setEnCours(false);
		toSer.update(this.enCours);
		
		// choix prochaine famille 
		// si Y famille même classe avec nb inferieur,
		// sinon first famille de la classe suivante, 
		// sinon starter.
		toSer.selectionSuivant(this.enCours);
		
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		ec.redirect(ec.getRequestContextPath() + "/accueil/tourSuivant2.xhtml?faces-redirect=true");
	}

}
