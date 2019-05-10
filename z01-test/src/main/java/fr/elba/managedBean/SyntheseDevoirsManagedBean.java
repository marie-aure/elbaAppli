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

import fr.elba.model.Devoir;
import fr.elba.model.LiaisonDVCL;
import fr.elba.service.IDevoirService;
import fr.elba.service.ILiaisonDVCLService;

@ManagedBean(name = "SyntheseDevoirsMB")
@ViewScoped
public class SyntheseDevoirsManagedBean {

	// ++++++++++++++++++
	// ---- Services ----
	// ++++++++++++++++++

	@ManagedProperty("#{DevoirService}")
	private IDevoirService dvSer;

	@ManagedProperty("#{LiaisonDVCLService}")
	private ILiaisonDVCLService ldvclSer;

	public void setDvSer(IDevoirService dvSer) {
		this.dvSer = dvSer;
	}

	public void setLdvclSer(ILiaisonDVCLService ldvclSer) {
		this.ldvclSer = ldvclSer;
	}

	// +++++++++++++++++++
	// ---- Variables ----
	// +++++++++++++++++++

	private Map<Devoir, List<LiaisonDVCL>> mDevoirs;
	private Devoir devoir;
	private String message;

	// ++++++++++++++++++++++
	// ---- Constructeur ----
	// ++++++++++++++++++++++

	public SyntheseDevoirsManagedBean() {
		super();
		this.mDevoirs = new HashMap<>();
		this.devoir = new Devoir();
		this.message = "";
	}

	@PostConstruct
	public void init() {
		getAllDevoirs();
	}

	// +++++++++++++++++++++++
	// ---- Getter/Setter ----
	// +++++++++++++++++++++++

	public Map<Devoir, List<LiaisonDVCL>> getmDevoirs() {
		return mDevoirs;
	}

	public void setmDevoirs(Map<Devoir, List<LiaisonDVCL>> mDevoirs) {
		this.mDevoirs = mDevoirs;
	}

	public Devoir getDevoir() {
		return devoir;
	}

	public void setDevoir(Devoir devoir) {
		this.devoir = devoir;
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

	public void getAllDevoirs() {
		this.mDevoirs = new HashMap<>();
		List<Devoir> lDevoirs = dvSer.getAll();
		if (lDevoirs.size() > 0) {
			for (Devoir devoir : lDevoirs) {
				List<LiaisonDVCL> lLDVCLs = ldvclSer.getByDevoir(devoir);
				mDevoirs.put(devoir, lLDVCLs);
			}
		}
	}

	public void creerDevoir() throws IOException {
		if (!this.devoir.getCategorie().equals("") && !this.devoir.getLibelle().equals("")
				&& !this.devoir.getPrecisions().equals("") && !this.devoir.getCommentaire().equals("")) {
			dvSer.create(this.devoir);
			this.message = "";
			ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
			ec.redirect(ec.getRequestContextPath() + "/devoir/syntheseDevoirs.xhtml?faces-redirect=true");
		} else {
			this.message = "Tous les champs doivent être remplis";
		}
	}

	public void creerLiaisonDVCL(int id) throws IOException {
		Devoir devoirCreation = dvSer.getById(id);

		if (devoirCreation != null) {
			ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
			Map<String, Object> sessionMap = ec.getSessionMap();
			sessionMap.put("devoirCreationLDVCL",devoirCreation);
			ec.redirect(ec.getRequestContextPath() + "/devoir/creerLiaisonDVCL.xhtml?faces-redirect=true");
		}
	}

}
