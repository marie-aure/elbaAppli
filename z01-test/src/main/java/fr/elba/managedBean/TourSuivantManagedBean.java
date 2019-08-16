package fr.elba.managedBean;

import java.io.IOException;
import java.util.ArrayList;
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

	@ManagedProperty("#{FamilleService}")
	private IFamilleService faSer;

	@ManagedProperty("#{PretService}")
	private IPretService prSer;

	@ManagedProperty("#{CompteService}")
	private ICompteService coSer;

	public void setPrSer(IPretService prSer) {
		this.prSer = prSer;
	}

	public void setCoSer(ICompteService coSer) {
		this.coSer = coSer;
	}

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
	private List<Pret> lPrets;
	private List<Compte> lComptes;

	// ++++++++++++++++++++++
	// ---- Constructeur ----
	// ++++++++++++++++++++++

	public TourSuivantManagedBean() {
		super();
		this.lPrets = new ArrayList<>();
		this.lComptes = new ArrayList<>();
	}

	@PostConstruct
	public void init() {
		this.enCours = tourEnCours();
		this.lPrets = getPrets();
		this.lComptes = getComptes();
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

	public List<Pret> getlPrets() {
		return lPrets;
	}

	public void setlPrets(List<Pret> lPrets) {
		this.lPrets = lPrets;
	}

	public List<Compte> getlComptes() {
		return lComptes;
	}

	public void setlComptes(List<Compte> lComptes) {
		this.lComptes = lComptes;
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

	public List<Pret> getPrets() {
		return prSer.getByFamily(this.enCours.getFamille());
	}

	public List<Compte> getComptes() {
		return coSer.getByFamily(this.enCours.getFamille());
	}

	public void goToPage2() throws IOException {
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		ec.redirect(ec.getRequestContextPath() + "/accueil/tourSuivant2.xhtml?faces-redirect=true");
	}

	public void goToPage3() throws IOException {
		if (this.argentIG > 0) {
			this.message = "";
			if (this.enCours.getFamille() != null) {
				this.enCours.getFamille().setArgentIG(argentIG);
			}
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
		if (this.enCours.getFamille() != null) {
			faSer.update(this.enCours.getFamille());
		}
		this.enCours.setNb(this.enCours.getNb() + 1);
		this.enCours.setSemaine(0);
		this.enCours.setEnCours(false);
		toSer.update(this.enCours);
		if (this.enCours.getFamille() != null) {
			// maj finances
			if (this.lPrets.size() > 0) {
				for (Pret pret : this.lPrets) {
					pret.setSomme(pret.getSomme() + pret.getInteret() - pret.getRembourse());
					pret.setInteret(pret.getSomme() * pret.getTaux() / 100);
					pret.setRembourse(0);
					pret.setRestant(pret.getSomme() + pret.getInteret() - pret.getRembourse());

					if (pret.getRestant() == 0) {
						pret.setFerme(true);
					}
					prSer.update(pret);
				}
			}

			if (this.lComptes.size() > 0) {
				for (Compte compte : this.lComptes) {
					compte.setMontant(
							compte.getMontant() + ((compte.getMontant() - compte.getRetrait()) * compte.getTaux() / 100)
									+ compte.getDepot() - compte.getRetrait());
					compte.setDepot(0);
					compte.setRetrait(0);

					coSer.update(compte);
				}
			}
		}
		// choix prochaine famille
		// si Y famille même classe avec nb inferieur,
		// sinon first famille de la classe suivante,
		// sinon starter.
		toSer.selectionSuivant(this.enCours);

		this.enCours = tourEnCours();
		this.argentIG = 0;
		this.message = "";
		this.lPrets = getPrets();
		this.lComptes = getComptes();

		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		ec.redirect(ec.getRequestContextPath() + "/accueil/accueil.xhtml?faces-redirect=true");
	}

}
