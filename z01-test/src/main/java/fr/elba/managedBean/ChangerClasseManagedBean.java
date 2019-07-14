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

import org.springframework.jmx.export.annotation.ManagedAttribute;

import fr.elba.model.Condition;
import fr.elba.model.Famille;
import fr.elba.model.LiaisonCOFA;
import fr.elba.service.IConditionService;
import fr.elba.service.IFamilleService;
import fr.elba.service.ILiaisonCOFAService;

@ManagedBean(name = "ChangerClasseMB")
@ViewScoped
public class ChangerClasseManagedBean {

	// ++++++++++++++++++
	// ---- Services ----
	// ++++++++++++++++++

	@ManagedProperty("#{LiaisonCOFAService}")
	private ILiaisonCOFAService lcofaSer;

	@ManagedProperty("#{ConditionService}")
	private IConditionService cnSer;

	@ManagedProperty("#{FamilleService}")
	private IFamilleService faSer;

	public void setFaSer(IFamilleService faSer) {
		this.faSer = faSer;
	}

	public void setCnSer(IConditionService cnSer) {
		this.cnSer = cnSer;
	}

	public void setLcofaSer(ILiaisonCOFAService lcofaSer) {
		this.lcofaSer = lcofaSer;
	}

	// +++++++++++++++++++
	// ---- Variables ----
	// +++++++++++++++++++

	private Famille famille;
	private List<LiaisonCOFA> lLCOFA;
	private boolean valide;

	// ++++++++++++++++++++++
	// ---- Constructeur ----
	// ++++++++++++++++++++++

	public ChangerClasseManagedBean() {
		super();
		this.lLCOFA = new ArrayList<LiaisonCOFA>();
	}

	@PostConstruct
	public void init() {
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = ec.getSessionMap();
		this.famille = (Famille) sessionMap.get("familleChangerClasse");
		if (this.famille != null) {
			this.lLCOFA = lcofaSer.getByFamille(this.famille);
		}
	}

	// +++++++++++++++++++++++
	// ---- Getter/Setter ----
	// +++++++++++++++++++++++

	public Famille getFamille() {
		return famille;
	}

	public void setFamille(Famille famille) {
		this.famille = famille;
	}

	public List<LiaisonCOFA> getlLCOFA() {
		return lLCOFA;
	}

	public void setlLCOFA(List<LiaisonCOFA> lLCOFA) {
		this.lLCOFA = lLCOFA;
	}

	public boolean isValide() {
		return valide;
	}

	public void setValide(boolean valide) {
		this.valide = valide;
	}

	// +++++++++++++++++
	// ---- Méthode ----
	// +++++++++++++++++

	private boolean isListeValide() {
		if (lLCOFA.size() > 0) {
			boolean valide = true;
			for (LiaisonCOFA liaison : lLCOFA) {
				if (liaison.isValide() == true) {
					valide = false;
				}
			}
			return valide;
		} else {
			return false;
		}
	}

	public void valider() throws IOException {
		if (this.valide && this.famille.getClasse().getClasseSup() != null) {
			this.famille.setClasse(this.famille.getClasse().getClasseSup());
			for (LiaisonCOFA liaison : lLCOFA) {
				lcofaSer.delete(liaison.getId());
			}
			List<Condition> lConditions = new ArrayList<>();
			lConditions = cnSer.getByClasse(this.famille.getClasse());
			if (lConditions.size() > 0) {
				for (Condition condition : lConditions) {
					LiaisonCOFA liaisonCOFA = new LiaisonCOFA("", 0, "", false, famille, condition);
					lcofaSer.create(liaisonCOFA);
				}
			}
			faSer.update(this.famille);
			ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
			ec.redirect(ec.getRequestContextPath() + "/accueil/accueil.xhtml?faces-redirect=true");

		}
	}

	public void toDetailLCOFA(int id) throws IOException {
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = ec.getSessionMap();
		sessionMap.put("detailLCOFA", lcofaSer.getById(id));
		sessionMap.put("pagePrecedente", "/famille/changerClasse.xhtml?faces-redirect=true");
		ec.redirect(ec.getRequestContextPath() + "/passage/detailLCOFA.xhtml?faces-redirect=true");
	}
}
