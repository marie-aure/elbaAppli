package fr.elba.managedBean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.hibernate.bytecode.internal.javassist.FastClass;

import fr.elba.model.Communautaire;
import fr.elba.model.Famille;
import fr.elba.model.LiaisonSITR;
import fr.elba.model.Prive;
import fr.elba.model.Sim;
import fr.elba.model.Terrain;
import fr.elba.service.IFamilleService;
import fr.elba.service.ILiaisonSITRService;
import fr.elba.service.ISimService;
import fr.elba.service.ITerrainService;

@ManagedBean(name = "ChangerGenerationMB")
@ViewScoped
public class ChangerGenerationManagedBean {

	// ++++++++++++++++++
	// ---- Services ----
	// ++++++++++++++++++

	@ManagedProperty("#{SimService}")
	private ISimService siSer;

	@ManagedProperty("#{FamilleService}")
	private IFamilleService faSer;

	public void setSiSer(ISimService siSer) {
		this.siSer = siSer;
	}

	public void setFaSer(IFamilleService faSer) {
		this.faSer = faSer;
	}

	// +++++++++++++++++++
	// ---- Variables ----
	// +++++++++++++++++++

	private Famille famille;
	private List<Sim> lHeritiers;

	// ++++++++++++++++++++++
	// ---- Constructeur ----
	// ++++++++++++++++++++++

	public ChangerGenerationManagedBean() {
		super();
		this.famille = new Famille();
		this.lHeritiers = new ArrayList<>();
	}

	@PostConstruct
	public void init() {
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();
		this.famille = (Famille) sessionMap.get("familleChangerGeneration");
		if (this.famille != null) {
			this.lHeritiers = siSer.getHeritierByFamille(this.famille);
		}

	}

	// +++++++++++++++++++++++
	// ---- Getter/Setter ----
	// +++++++++++++++++++++++

	public List<Sim> getlHeritiers() {
		return lHeritiers;
	}

	public void setlHeritiers(List<Sim> lHeritiers) {
		this.lHeritiers = lHeritiers;
	}

	public void setFamille(Famille famille) {
		this.famille = famille;
	}

	public Famille getFamille() {
		return famille;
	}

	// +++++++++++++++++
	// ---- Méthode ----
	// +++++++++++++++++

	public void selectionner(Integer id) throws IOException {
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = ec.getSessionMap();
		Sim sim = siSer.getById(id);
		if (sim != null){
		this.famille.setChef(sim);
		this.famille.setGeneration(this.famille.getGeneration() + 1);
		faSer.update(this.famille);
		ec.redirect(ec.getRequestContextPath() + "/accueil/accueil.xhtml?faces-redirect=true");
		}
	}
}
