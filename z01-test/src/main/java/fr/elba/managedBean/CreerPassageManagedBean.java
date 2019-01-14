package fr.elba.managedBean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import fr.elba.model.Passage;
import fr.elba.service.IPassageService;

@ManagedBean(name = "CreerPassageMB")
@ViewScoped
public class CreerPassageManagedBean {

	// ++++++++++++++++++
	// ---- Services ----
	// ++++++++++++++++++

	@ManagedProperty("#{PassageService}")
	private IPassageService paSer;

	public void setPaSer(IPassageService paSer) {
		this.paSer = paSer;
	}

	// +++++++++++++++++++
	// ---- Variables ----
	// +++++++++++++++++++

	private String message = "";
	private Passage passage;
	private List<String> lCategories;
	private String categorie = "";

	// ++++++++++++++++++++++
	// ---- Constructeur ----
	// ++++++++++++++++++++++

	public CreerPassageManagedBean() {
		super();
		this.passage = new Passage();
		this.lCategories = new ArrayList<>();
	}

	@PostConstruct
	public void init() {
		getAllCategorie();
	}

	// +++++++++++++++++++++++
	// ---- Getter/Setter ----
	// +++++++++++++++++++++++

	public Passage getPassage() {
		return passage;
	}

	public void setPassage(Passage passage) {
		this.passage = passage;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public List<String> getlCategories() {
		return lCategories;
	}

	public void setlCategories(List<String> lCategories) {
		this.lCategories = lCategories;
	}

	// +++++++++++++++++
	// ---- Méthode ----
	// +++++++++++++++++

	public void getAllCategorie() {
		this.lCategories = paSer.getAllCategorie();
	}

	public void creerPassage() throws IOException {
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = ec.getSessionMap();

		if ((!this.categorie.equals("") || this.passage.getCategorie().length() > 0)
				&& this.passage.getLibelle().length() > 0 && this.passage.getPrecisions().length() > 0
				&& this.passage.getCommentaire().length() > 0) {
			if (!this.categorie.equals("")) {
				this.passage.setCategorie(this.categorie);
			}
			paSer.create(this.passage);
			sessionMap.put("passageEnCoursDetailPassage", this.passage);
			ec.redirect(ec.getRequestContextPath() + "/passage/detailPassage.xhtml?faces-redirect=true");

		} else {
			this.message = "Tous les champs doivent être remplis";
		}

	}
}