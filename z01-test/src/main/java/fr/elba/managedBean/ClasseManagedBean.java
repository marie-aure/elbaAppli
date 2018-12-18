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

import antlr.CSharpCodeGenerator;
import fr.elba.model.Classe;
import fr.elba.model.Quartier;
import fr.elba.service.IClasseService;
import fr.elba.service.IQuartierService;

@ManagedBean(name = "ClasseMB")
@ViewScoped
public class ClasseManagedBean {

	// ++++++++++++++++++
	// ---- Services ----
	// ++++++++++++++++++

	@ManagedProperty("#{ClasseService}")
	private IClasseService clSer;

	public void setClSer(IClasseService clSer) {
		this.clSer = clSer;
	}


	// +++++++++++++++++++
	// ---- Variables ----
	// +++++++++++++++++++

	private List<Classe> lClasses;

	// ++++++++++++++++++++++
	// ---- Constructeur ----
	// ++++++++++++++++++++++

	public ClasseManagedBean() {
		super();
		this.lClasses = new ArrayList<>();
	}

	@PostConstruct
	public void init() {
		this.lClasses = clSer.getAll();
	}

	// +++++++++++++++++++++++
	// ---- Getter/Setter ----
	// +++++++++++++++++++++++

	public List<Classe> getlClasses() {
		return lClasses;
	}

	public void setlClasses(List<Classe> lClasses) {
		this.lClasses = lClasses;
	}


	// +++++++++++++++++
	// ---- Méthode ----
	// +++++++++++++++++

public void toDetailClasse(int id) throws IOException {
	ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
	Map<String, Object> sessionMap = ec.getSessionMap();
	Classe classe = clSer.getById(id);
	sessionMap.put("classeEnCoursDetailClasse", classe);
	ec.redirect(ec.getRequestContextPath() + "/accueil/detailClasse.xhtml?faces-redirect=true");
}
	
}
