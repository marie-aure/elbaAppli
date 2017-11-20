package fr.elba.managedBean;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.elba.model.Classe;
import fr.elba.model.LiaisonDVCL;
import fr.elba.service.ILiaisonDVCLService;

	@ManagedBean(name = "LiaisonDVCLMB")
	@SessionScoped
	public class LiaisonDVCLManagedBean {

		// ++++++++++++++++++
		// ---- Services ----
		// ++++++++++++++++++

		@ManagedProperty("#{LiaisonDVCLService}")
		private ILiaisonDVCLService ldvclSer;
		
		public void setldvclSer(ILiaisonDVCLService ldvclSer) {
			this.ldvclSer = ldvclSer;
		}
		
		// +++++++++++++++++++
		// ---- Variables ----
		// +++++++++++++++++++

		private LiaisonDVCL liaisonDVCL;
		private List<LiaisonDVCL> lLiaisonDVCLs;

		// ++++++++++++++++++++++
		// ---- Constructeur ----
		// ++++++++++++++++++++++

		public LiaisonDVCLManagedBean() {
			super();
			this.liaisonDVCL = new LiaisonDVCL();
		}

		@PostConstruct
		public void init() {
			this.lLiaisonDVCLs = ldvclSer.getAll();
		}

		// +++++++++++++++++++++++
		// ---- Getter/Setter ----
		// +++++++++++++++++++++++

		public LiaisonDVCL getLiaisonDVCL() {
			return liaisonDVCL;
		}

		public void setLiaisonDVCL(LiaisonDVCL liaisonDVCL) {
			this.liaisonDVCL = liaisonDVCL;
		}

		public List<LiaisonDVCL> getlLiaisonDVCLs() {
			return lLiaisonDVCLs;
		}

		public void setlLiaisonDVCLs(List<LiaisonDVCL> lLiaisonDVCLs) {
			this.lLiaisonDVCLs = lLiaisonDVCLs;
		}

		// +++++++++++++++++
		// ---- Méthode ----
		// +++++++++++++++++
		
		public void create() {
			ldvclSer.create(this.liaisonDVCL);
			this.lLiaisonDVCLs = ldvclSer.getAll();
		}

	}
