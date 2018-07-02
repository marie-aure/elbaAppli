package fr.elba.managedBean;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import fr.elba.dao.impl.LiaisonSITRDaoImpl;
import fr.elba.model.LiaisonSITR;
import fr.elba.model.Starter;
import fr.elba.service.IStarterService;

@ManagedBean(name = "StarterMB")
@SessionScoped
public class StarterManagedBean {

	// ++++++++++++++++++
	// ---- Services ----
	// ++++++++++++++++++

	@ManagedProperty("#{StarterService}")
	private IStarterService stSer;

	public void setStSer(IStarterService stSer) {
		this.stSer = stSer;
	}

	// +++++++++++++++++++
	// ---- Variables ----
	// +++++++++++++++++++

	private Starter starter;
	private List<Starter> lStarters;
	private int taille;
	private int numero;
	private List<Integer> lNumeros;

	// ++++++++++++++++++++++
	// ---- Constructeur ----
	// ++++++++++++++++++++++

	public StarterManagedBean() {
		super();
		this.starter = new Starter();
	}

	@PostConstruct
	public void init() {
		this.lNumeros = stSer.getGroupes();
	}

	// +++++++++++++++++++++++
	// ---- Getter/Setter ----
	// +++++++++++++++++++++++

	public Starter getStarter() {
		return starter;
	}

	public void setStarter(Starter starter) {
		this.starter = starter;
	}

	public List<Starter> getlStarters() {
		return lStarters;
	}

	public void setlStarters(List<Starter> lStarters) {
		this.lStarters = lStarters;
	}

	public int getTaille() {
		return taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}
	
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public List<Integer> getlNumeros() {
		return lNumeros;
	}

	public void setlNumeros(List<Integer> lNumeros) {
		this.lNumeros = lNumeros;
	}
	
	// +++++++++++++++++
	// ---- Méthode ----
	// +++++++++++++++++

	public void generateStarters() throws IOException {

		stSer.generate(this.taille);

		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		ec.redirect(ec.getRequestContextPath() + "/sim/voirGroupesStarter.xhtml?faces-redirect=true");

	}
	
	public void chargerGroupe() throws IOException {
		this.lStarters = stSer.chargerGroupe(this.numero);
		System.out.println("greaaaato");
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		ec.redirect(ec.getRequestContextPath() + "/sim/voirGroupesStarter.xhtml?faces-redirect=true");

	}

}
