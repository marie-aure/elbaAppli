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

import fr.elba.model.Compte;
import fr.elba.model.Pret;
import fr.elba.model.Terrain;
import fr.elba.model.Tour;
import fr.elba.service.ICompteService;
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

	public void setToSer(ITourService toSer) {
		this.toSer = toSer;
	}

	// +++++++++++++++++++
	// ---- Variables ----
	// +++++++++++++++++++

	private Tour enCours;

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
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		ec.redirect(ec.getRequestContextPath() + "/accueil/tourSuivant3.xhtml?faces-redirect=true");
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
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		ec.redirect(ec.getRequestContextPath() + "/accueil/tourSuivant2.xhtml?faces-redirect=true");
	}

}
