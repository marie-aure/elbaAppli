package fr.elba.managedBean;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import fr.elba.model.Droit;
import fr.elba.model.LiaisonDRCL;
import fr.elba.service.IDroitService;
import fr.elba.service.ILiaisonDRCLService;

@ManagedBean(name = "SyntheseDroitsMB")
@SessionScoped
public class SyntheseDroitsManagedBean {

	// ++++++++++++++++++
	// ---- Services ----
	// ++++++++++++++++++

	@ManagedProperty("#{DroitService}")
	private IDroitService drSer;

	@ManagedProperty("#{LiaisonDRCLService}")
	private ILiaisonDRCLService ldrclSer;

	public void setDrSer(IDroitService drSer) {
		this.drSer = drSer;
	}

	public void setLdrclSer(ILiaisonDRCLService ldrclSer) {
		this.ldrclSer = ldrclSer;
	}

	// +++++++++++++++++++
	// ---- Variables ----
	// +++++++++++++++++++

	private Map<Droit, List<LiaisonDRCL>> mDroits;
	private Droit droit;
	private String message;

	// ++++++++++++++++++++++
	// ---- Constructeur ----
	// ++++++++++++++++++++++

	public SyntheseDroitsManagedBean() {
		super();
		this.mDroits = new HashMap<>();
		this.droit = new Droit();
		this.message = "";
	}

	@PostConstruct
	public void init() {
		getAllDroits();
	}

	// +++++++++++++++++++++++
	// ---- Getter/Setter ----
	// +++++++++++++++++++++++

	public Map<Droit, List<LiaisonDRCL>> getmDroits() {
		return mDroits;
	}

	public void setmDroits(Map<Droit, List<LiaisonDRCL>> mDroits) {
		this.mDroits = mDroits;
	}

	public Droit getDroit() {
		return droit;
	}

	public void setDroit(Droit droit) {
		this.droit = droit;
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

	public void getAllDroits() {
		this.mDroits = new HashMap<>();
		List<Droit> lDroits = drSer.getAll();
		if (lDroits.size() > 0) {
			for (Droit droit : lDroits) {
				List<LiaisonDRCL> lLDRCLs = ldrclSer.getByDroit(droit);
				mDroits.put(droit, lLDRCLs);
			}
		}
	}

	public void creerDroit() {
		if (!this.droit.getCategorie().equals("") && !this.droit.getLibelle().equals("")
				&& !this.droit.getPrecisions().equals("") && !this.droit.getCommentaire().equals("")) {
			drSer.create(this.droit);
			this.message = "";
			this.droit = new Droit();
		} else {
			this.message = "Tous les champs doivent être remplis";
		}
		getAllDroits();
	}

	public void creerLiaisonDRCL(int id) throws IOException {
		Droit droitCreation = drSer.getById(id);

		if (droitCreation != null) {
			ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
			Map<String, Object> sessionMap = ec.getSessionMap();
			sessionMap.put("droitCreationLDRCl",droitCreation);
			ec.redirect(ec.getRequestContextPath() + "/droit/creerLiaisonDRCL.xhtml?faces-redirect=true");
		}
	}

}
