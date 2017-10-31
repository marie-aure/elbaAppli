package fr.test.managedBean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.test.model.RabbitHole;
import fr.test.service.IRabbitHoleService;

@ManagedBean(name = "RabbitHoleMB")
@SessionScoped
public class RabbitHoleManagedBean {

	// -----------------------
	// XXXXX - Service - XXXXX
	// -----------------------

	@ManagedProperty("#{RabbitHoleService}")
	IRabbitHoleService rhSer;

	public void setRhSer(IRabbitHoleService rhSer) {
		this.rhSer = rhSer;
	}

	// -------------------------
	// XXXXX - Attributs - XXXXX
	// -------------------------

	private RabbitHole rabbitHole;
	private List<RabbitHole> lRabbitHoles;
	private List<String> lLibelles; 
	
	// -------------------------------
	// XXXXX - Getters/Setters - XXXXX
	// -------------------------------

	public RabbitHole getRabbitHole() {
		return rabbitHole;
	}

	public void setRabbitHole(RabbitHole rabbitHole) {
		this.rabbitHole = rabbitHole;
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
	
	// ----------------------------
	// XXXXX - Constructeur - XXXXX
	// ----------------------------

	public RabbitHoleManagedBean() {
		super();
		this.rabbitHole = new RabbitHole();
	}

	@PostConstruct
	public void init() {
		this.lRabbitHoles = rhSer.getAll();
		this.lLibelles = new ArrayList<>();
		for (RabbitHole rh : lRabbitHoles) {
			this.lLibelles.add(rh.getLibelle());
		}
	}

	// ------------------------
	// XXXXX - Méthodes - XXXXX
	// ------------------------

	public String getAll() {
		this.lRabbitHoles = rhSer.getAll();
		this.lLibelles = new ArrayList<>();
		for (RabbitHole rh : lRabbitHoles) {
			this.lLibelles.add(rh.getLibelle());
		}
		return "listeRabbitHoles";
	}

	public String create() {
		rhSer.create(this.rabbitHole);
		this.lRabbitHoles = rhSer.getAll();
		this.lLibelles = new ArrayList<>();
		for (RabbitHole rh : lRabbitHoles) {
			this.lLibelles.add(rh.getLibelle());
		}
		this.rabbitHole = new RabbitHole();
		return "listeRabbitHoles";
	}

	public String toModifierRabbitHole(int id) {
		this.rabbitHole = rhSer.getById(id);
		return "modifierRabbitHole";
	}

	public String update() {
		rhSer.update(this.rabbitHole);
		this.lRabbitHoles = rhSer.getAll();
		this.lLibelles = new ArrayList<>();
		for (RabbitHole rh : lRabbitHoles) {
			this.lLibelles.add(rh.getLibelle());
		}
		this.rabbitHole = new RabbitHole();
		return "listeRabbitHoles";
	}

	public String delete(int id) {
		rhSer.delete(id);
		this.lRabbitHoles = rhSer.getAll();
		this.lLibelles = new ArrayList<>();
		for (RabbitHole rh : lRabbitHoles) {
			this.lLibelles.add(rh.getLibelle());
		}
		return "listeRabbitHoles";
	}
}
