package fr.elba.managedBean;

import java.io.IOException;
import java.util.ArrayList;
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

	private List<Devoir> lDevoirs;
	private Devoir devoir;
	private String message;

	// ++++++++++++++++++++++
	// ---- Constructeur ----
	// ++++++++++++++++++++++

	public SyntheseDevoirsManagedBean() {
		super();
		this.lDevoirs = new ArrayList();
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

	public List<Devoir> getlDevoirs() {
		return lDevoirs;
	}

	public void setlDevoirs(List<Devoir> lDevoirs) {
		this.lDevoirs = lDevoirs;
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
		this.lDevoirs = new ArrayList<>();
		this.lDevoirs = dvSer.getAll();
	}

	public void toDetailDevoir(int id) throws IOException {
		this.devoir = dvSer.getById(id);
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = ec.getSessionMap();
		sessionMap.put("detailDevoir", this.devoir);
		ec.redirect(ec.getRequestContextPath() + "/devoir/detailDevoir.xhtml?faces-redirect=true");
	}

	public void creerDroit() throws IOException {
		if (!this.devoir.getCategorie().equals("") && !this.devoir.getLibelle().equals("")
				&& !this.devoir.getPrecisions().equals("") && !this.devoir.getCommentaire().equals("")) {
			dvSer.create(this.devoir);
			this.message = "";
		} else {
			this.message = "Tous les champs doivent être remplis";
		}
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext(); 
		Map<String, Object> sessionMap = ec.getSessionMap();
		sessionMap.put("detailDevoir", this.devoir);
		ec.redirect(ec.getRequestContextPath() + "/devoir/detailDevoir.xhtml?faces-redirect=true");

	}
	
}
