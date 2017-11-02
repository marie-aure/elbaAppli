package fr.elba.managedBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import com.sun.faces.context.SessionMap;

import fr.elba.model.Communautaire;
import fr.elba.model.Famille;
import fr.elba.model.Quartier;
import fr.elba.model.RabbitHole;
import fr.elba.service.ICommunautaireService;
import fr.elba.service.IFamilleService;
import fr.elba.service.IQuartierService;
import fr.elba.service.IRabbitHoleService;

@ManagedBean(name = "CommunautaireMB")
public class CommunautaireManagedBean {

	// ++++++++++++++++++
	// ---- Services ----
	// ++++++++++++++++++

	@ManagedProperty("#{CommunautaireService}")
	private ICommunautaireService coSer;

	@ManagedProperty("#{QuartierService}")
	private IQuartierService quSer;

	@ManagedProperty("#{RabbitHoleService}")
	private IRabbitHoleService rhSer;

	@ManagedProperty("#{FamilleService}")
	private IFamilleService faSer;

	public void setCoSer(ICommunautaireService coSer) {
		this.coSer = coSer;
	}

	public void setQuSer(IQuartierService quSer) {
		this.quSer = quSer;
	}

	public void setRhSer(IRabbitHoleService rhSer) {
		this.rhSer = rhSer;
	}

	public void setFaSer(IFamilleService faSer) {
		this.faSer = faSer;
	}

	// +++++++++++++++++++
	// ---- Variables ----
	// +++++++++++++++++++

	private Communautaire communautaire;
	private List<Communautaire> lCommunautaires;
	private String selectedQuartier;
	private List<String> selectedRabbitHoles;
	private String selectedProprietaire;

	// ++++++++++++++++++++++
	// ---- Constructeur ----
	// ++++++++++++++++++++++

	public CommunautaireManagedBean() {
		super();
		this.communautaire = new Communautaire();
		this.selectedRabbitHoles = new ArrayList<>();
	}

	@PostConstruct
	public void init() {
		this.lCommunautaires = coSer.getAll();
	}

	// +++++++++++++++++++++++
	// ---- Getter/Setter ----
	// +++++++++++++++++++++++

	public Communautaire getCommunautaire() {
		return communautaire;
	}

	public void setCommunautaire(Communautaire communautaire) {
		this.communautaire = communautaire;
	}

	public List<Communautaire> getlCommunautaires() {
		return lCommunautaires;
	}

	public void setlCommunautaires(List<Communautaire> lCommunautaires) {
		this.lCommunautaires = lCommunautaires;
	}

	public String getSelectedQuartier() {
		return selectedQuartier;
	}

	public void setSelectedQuartier(String selectedQuartier) {
		this.selectedQuartier = selectedQuartier;
	}

	public List<String> getSelectedRabbitHoles() {
		return selectedRabbitHoles;
	}

	public void setSelectedRabbitHoles(List<String> selectedRabbitHoles) {
		this.selectedRabbitHoles = selectedRabbitHoles;
	}

	public String getSelectedProprietaire() {
		return selectedProprietaire;
	}

	public void setSelectedProprietaire(String selectedProprietaire) {
		this.selectedProprietaire = selectedProprietaire;
	}

	// +++++++++++++++++
	// ---- M�thode ----
	// +++++++++++++++++

	public String create() {
		Quartier quartier = quSer.getByName(this.selectedQuartier);
		this.communautaire.setQuartier(quartier);
		this.selectedQuartier = null;
		List<RabbitHole> lRabbitHoles = new ArrayList<>();
		for (String name : selectedRabbitHoles) {
			RabbitHole rabbitHole = rhSer.getByName(name);
			lRabbitHoles.add(rabbitHole);
		}
		this.communautaire.setlRabbitHoles(lRabbitHoles);
		this.selectedRabbitHoles = null;
		this.communautaire.setTerrain(false);
		this.communautaire.setBatiment(false);
		coSer.create(this.communautaire);
		this.communautaire = new Communautaire();
		return "detailsCommunautaire";
	}

	public void details() {
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();
		int id = (int) sessionMap.get("idTerrain");
		this.communautaire = coSer.getById(id);
	}

	public void modifier() {
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();
		int id = (int) sessionMap.get("idTerrain");
		this.communautaire = coSer.getById(id);
		if (this.communautaire.getlRabbitHoles().size() > 0) {
			for (RabbitHole rabbitHole : this.communautaire.getlRabbitHoles()) {
				this.selectedRabbitHoles.add(rabbitHole.getLibelle());
			}
		}
		if (this.communautaire.getQuartier() != null) {
			this.selectedQuartier = this.communautaire.getQuartier().getLibelle();
		}
		if (this.communautaire.getProprietaire() != null) {
			this.selectedProprietaire = this.communautaire.getProprietaire().getNom();
		}
	}

	public String update() {
		Quartier quartier = quSer.getByName(this.selectedQuartier);
		this.communautaire.setQuartier(quartier);

		Famille proprietaire = faSer.getByName(this.selectedProprietaire);
		this.communautaire.setProprietaire(proprietaire);

		List<RabbitHole> lRabbitHoles = new ArrayList<>();
		for (String name : selectedRabbitHoles) {
			RabbitHole rabbitHole = rhSer.getByName(name);
			lRabbitHoles.add(rabbitHole);
		}
		this.communautaire.setlRabbitHoles(lRabbitHoles);

		coSer.update(this.communautaire);
		this.communautaire = new Communautaire();
		return "detailsCommunautaire";
	}

}
