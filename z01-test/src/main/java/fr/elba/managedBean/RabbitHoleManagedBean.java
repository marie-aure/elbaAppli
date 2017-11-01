package fr.elba.managedBean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import fr.elba.model.RabbitHole;
import fr.elba.service.IRabbitHoleService;

@ManagedBean(name = "RabbitHoleMB")
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
		this.lLibelles = new ArrayList<>();
		for (RabbitHole rabLib : lRabbitHoles){
			this.lLibelles.add(rabLib.getLibelle());
		}
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
	// ---- Méthode ----
	// +++++++++++++++++

}
