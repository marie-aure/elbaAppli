package fr.elba.managedBean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import fr.elba.model.LiaisonSITR;
import fr.elba.model.Starter;
import fr.elba.service.ILiaisonSITRService;
import fr.elba.service.ISimService;
import fr.elba.service.IStarterService;

@ManagedBean(name = "LiaisonSITRMB")
@SessionScoped
public class LiaisonSITRManagedBean {

	// ++++++++++++++++++
	// ---- Services ----
	// ++++++++++++++++++

	@ManagedProperty("#{LiaisonSITRService}")
	private ILiaisonSITRService lsitrSer;

	@ManagedProperty("#{SimService}")
	private ISimService siSer;

	public void setLsitrSer(ILiaisonSITRService lsitrSer) {
		this.lsitrSer = lsitrSer;
	}

	public void setSiSer(ISimService siSer) {
		this.siSer = siSer;
	}

	// +++++++++++++++++++
	// ---- Variables ----
	// +++++++++++++++++++

	private List<LiaisonSITR> lStarters;
	private LiaisonSITR starter;
	private int numero;
	private int groupe;

	// ++++++++++++++++++++++
	// ---- Constructeur ----
	// ++++++++++++++++++++++

	public LiaisonSITRManagedBean() {
		super();
	}

	@PostConstruct
	public void init() {
		this.lStarters = new ArrayList<>();
	}

	// +++++++++++++++++++++++
	// ---- Getter/Setter ----
	// +++++++++++++++++++++++

	public List<LiaisonSITR> getlStarters() {
		return lStarters;
	}

	public void setlStarters(List<LiaisonSITR> lStarters) {
		this.lStarters = lStarters;
	}

	public LiaisonSITR getStarter() {
		return starter;
	}

	public void setStarter(LiaisonSITR starter) {
		this.starter = starter;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getGroupe() {
		return groupe;
	}

	public void setGroupe(int groupe) {
		this.groupe = groupe;
	}

	// +++++++++++++++++
	// ---- Méthode ----
	// +++++++++++++++++

	public void creerGroupe(List<LiaisonSITR> starters, int groupe) throws IOException {
		this.lStarters = starters;
		this.groupe = groupe;
		this.numero = 0;
		creerStarter();
	}

	private void creerStarter() throws IOException {
		if (this.lStarters.size() > this.numero) {
			this.starter = this.lStarters.get(this.numero);
			ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
			ec.redirect(ec.getRequestContextPath() + "/sim/creerStarter.xhtml?faces-redirect=true");
		}
	}

	public void updateStarter() {
		System.out.println(this.starter.getSim().getNom());
		System.out.println(this.starter.getSim().getPrenom());
		siSer.update( this.starter.getSim());
		this.lStarters = lsitrSer.chargerGroupe(this.groupe);
	}

	public void suivant() throws IOException {
		this.numero++;
		if (this.lStarters.size() > this.numero && this.numero >= 0) {
			this.starter = this.lStarters.get(this.numero);
			ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
			ec.redirect(ec.getRequestContextPath() + "/sim/creerStarter.xhtml?faces-redirect=true");
		}
	}

	public void precedent() throws IOException {
		this.numero--;
		if (this.lStarters.size() > this.numero && this.numero >= 0) {
			this.starter = this.lStarters.get(this.numero);
			ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
			ec.redirect(ec.getRequestContextPath() + "/sim/creerStarter.xhtml?faces-redirect=true");
		}
	}

}
