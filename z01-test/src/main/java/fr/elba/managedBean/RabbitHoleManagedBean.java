package fr.elba.managedBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import fr.elba.model.RabbitHole;
import fr.elba.service.IRabbitHoleService;

@ManagedBean(name = "RabbitHoleMB")
@SessionScoped
public class RabbitHoleManagedBean {

	// ++++++++++++++++++
	// ---- Services ----
	// ++++++++++++++++++

	@ManagedProperty("#{RabbitHoleService}")
	private IRabbitHoleService rhSer;

	public void setRhSer(IRabbitHoleService rhSer) {
		this.rhSer = rhSer;
	}

	// +++++++++++++++++++
	// ---- Variables ----
	// +++++++++++++++++++

	private RabbitHole rabbitHole;
	private List<RabbitHole> lRabbitHoles;
	private List<String> lLibelles;

	
	// ++++++++++++++++++++++
	// ---- Constructeur ----
	// ++++++++++++++++++++++

	public RabbitHoleManagedBean() {
		super();
		this.rabbitHole = new RabbitHole();
	}

	@PostConstruct
	public void init() {
		this.lRabbitHoles = rhSer.getAll();
		updatelLibelles();
		compteAll();
	}

	// +++++++++++++++++++++++
	// ---- Getter/Setter ----
	// +++++++++++++++++++++++

	public RabbitHole getRabbitHole() {
		return rabbitHole;
	}

	public void setRabbitHole(RabbitHole RabbitHole) {
		this.rabbitHole = RabbitHole;
	}

	public List<RabbitHole> getlRabbitHoles() {
		return lRabbitHoles;
	}

	public void setlRabbitHoles(List<RabbitHole> lRabbitHoles) {
		this.lRabbitHoles = lRabbitHoles;
	}

	public List<String> getlLibelles() {
		return lLibelles;
	}

	public void setlLibelles(List<String> lLibelles) {
		this.lLibelles = lLibelles;
	}


	// +++++++++++++++++
	// ---- M�thode ----
	// +++++++++++++++++

	public void compteAll(){
		List<RabbitHole> lRH = new ArrayList<>();
		for (RabbitHole rh : this.lRabbitHoles) {
			rh.setCompte(rh.getlCommunautaire().size());
			lRH.add(rh);
		}
		this.lRabbitHoles = lRH;
	}
	
	public void updatelLibelles() {
		this.lLibelles = new ArrayList<>();
		for (RabbitHole rabLib : this.lRabbitHoles) {
			this.lLibelles.add(rabLib.getLibelle());
		}
	}
	
	public String create() {
		this.rabbitHole.setCompte(0);
		this.rabbitHole.setlCommunautaire(null);
		rhSer.create(this.rabbitHole);
		this.rabbitHole = new RabbitHole();
		this.lRabbitHoles = rhSer.getAll();
		compteAll();
		updatelLibelles();
		return "listeRabbitHoles?faces-redirect=true";
	}
	
	public String toModifier(int id) {
		this.rabbitHole = rhSer.getById(id);
		return "modifierRabbitHole?faces-redirect=true";
	}
	
	public String update() {
		rhSer.update(this.rabbitHole);
		this.lRabbitHoles = rhSer.getAll();
		compteAll();
		updatelLibelles();
		return "listeRabbitHoles?faces-redirect=true";
	}
	
	public String delete(int id) {
		rhSer.delete(id);
		this.lRabbitHoles = rhSer.getAll();
		compteAll();
		updatelLibelles();
		return "listeRabbitHoles?faces-redirect=true";
	}
	
	public String toListe() {
		this.lRabbitHoles = rhSer.getAll();
		compteAll();
		return "listeRabbitHoles?faces-redirect=true";
	}
}
