package fr.elba.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysql.fabric.xmlrpc.base.Array;

import fr.elba.dao.IStarterDao;
import fr.elba.dao.ITraitDao;
import fr.elba.model.Couple;
import fr.elba.model.LiaisonSITR;
import fr.elba.model.Souhait;
import fr.elba.model.Starter;
import fr.elba.model.Trait;
import fr.elba.service.ILiaisonSITRService;
import fr.elba.service.ISouhaitService;
import fr.elba.service.IStarterService;
import fr.elba.service.ITraitService;

@Service("StarterService")
public class StarterServiceImpl implements IStarterService {

	@Autowired
	private IStarterDao stDao;

	@Autowired
	private ISouhaitService soSer;

	@Autowired
	private ITraitService trSer;

	@Autowired
	private ILiaisonSITRService lsitrSer;

	public void setStDao(IStarterDao stDao) {
		this.stDao = stDao;
	}

	public void setSoSer(ISouhaitService soSer) {
		this.soSer = soSer;
	}

	public void setTrSer(ITraitService trSer) {
		this.trSer = trSer;
	}

	public void setLsitrSer(ILiaisonSITRService lsitrSer) {
		this.lsitrSer = lsitrSer;
	}

	@Override
	public List<Starter> getAll() {
		return stDao.getAll();
	}

	@Override
	public Starter getById(int id) {
		return stDao.getById(id);
	}

	@Override
	public void create(Starter starter) {
		stDao.create(starter);
	}

	@Override
	public void update(Starter starter) {
		stDao.update(starter);
	}

	@Override
	public void delete(int id) {
		stDao.delete(id);
	}

	@Override
	public void generate(int taille) {
		List<LiaisonSITR> lLiaisonSITRs = creerSims(taille);

		List<LiaisonSITR> hh = new ArrayList<>();
		List<LiaisonSITR> ff = new ArrayList<>();
		List<LiaisonSITR> h = new ArrayList<>();
		List<LiaisonSITR> f = new ArrayList<>();

		for (int i = 0; i < taille; i++) {
			Starter starter = (Starter) lLiaisonSITRs.get(i).getSim();
			if (starter.getSexe() == "F" && starter.getOrientation() == "Hétérosexuel") {
				f.add(lLiaisonSITRs.get(i));
			} else if (starter.getSexe() == "F" && starter.getOrientation() == "Homosexuel") {
				ff.add(lLiaisonSITRs.get(i));
			} else if (starter.getSexe() == "M" && starter.getOrientation() == "Hétérosexuel") {
				h.add(lLiaisonSITRs.get(i));
			} else if (starter.getSexe() == "M" && starter.getOrientation() == "Homosexuel") {
				hh.add(lLiaisonSITRs.get(i));
			} else {
				System.out.println("Problème du troisième type !");
			}
		}

		System.out.println("hh " + hh.size() + " ff " + ff.size() + " h" + h.size() + " f " + f.size());

		// créer tab HH
		int[][] tabHH = new int[hh.size() - 1][hh.size() - 1];

		for (int i = 0; i < hh.size() - 1; i++) {
			for (int j = i + 1; j < hh.size(); j++) {
				tabHH[i][j - 1] = score(hh.get(i), hh.get(j));
			}
		}

		// créer tab FF
		int[][] tabFF = new int[ff.size() - 1][ff.size() - 1];

		for (int i = 0; i < ff.size() - 1; i++) {
			for (int j = i + 1; j < ff.size(); j++) {
				tabFF[i][j - 1] = score(ff.get(i), ff.get(j));
			}
		}

		// créer tab HF
		int[][] tabHF = new int[h.size()][f.size()];

		for (int i = 0; i < h.size(); i++) {
			for (int j = 0; j < f.size(); j++) {
				tabHF[i][j] = score(h.get(i), f.get(j));
			}
		}

		// Sélectionner couples HH
		List<Couple> lCouples = new ArrayList<>();
		boolean cond = true;
		while (cond) {
			int max = 0;
			int ligne = 0;
			int col = 0;
			cond = false;

			for (int i = 0; i < hh.size() - 1; i++) {
				for (int j = i + 1; j < hh.size(); j++) {
					if (tabHH[i][j - 1] >= 10 && tabHH[i][j - 1] > max) {
						max = tabHH[i][j - 1];
						ligne = i;
						col = j;
						cond = true;
					}
				}
			}

			if (cond) {
				Couple couple = new Couple(hh.get(ligne), hh.get(col), max);
				lCouples.add(couple);

				System.out.println("ligne " + ligne + " col " + col);

				for (int i = 0; i < hh.size() - 1; i++) {
					tabHH[i][col - 1] = 0;
					if (ligne > 0) {
						tabHH[i][ligne - 1] = 0;
					}
				}

				for (int j = 0; j < hh.size() - 1; j++) {
					tabHH[ligne][j] = 0;
					if (col < hh.size() - 1) {
						tabHH[col][j] = 0;
					}
				}

				System.out.println("stopwatch");
			}
		}

		// Sélectionner couples FF
		cond = true;
		while (cond) {
			int max = 0;
			int ligne = 0;
			int col = 0;
			cond = false;

			for (int i = 0; i < ff.size() - 1; i++) {
				for (int j = i + 1; j < ff.size(); j++) {
					if (tabFF[i][j - 1] >= 10 && tabFF[i][j - 1] > max) {
						max = tabFF[i][j - 1];
						ligne = i;
						col = j;
						cond = true;
					}
				}
			}

			if (cond) {
				Couple couple = new Couple(ff.get(ligne), ff.get(col), max);
				lCouples.add(couple);

				System.out.println("ligne " + ligne + " col " + col);

				for (int i = 0; i < ff.size() - 1; i++) {
					tabFF[i][col - 1] = 0;
					if (ligne > 0) {
						tabFF[i][ligne - 1] = 0;
					}
				}

				for (int j = 0; j < ff.size() - 1; j++) {
					tabFF[ligne][j] = 0;
					if (col < ff.size() - 1) {
						tabFF[col][j] = 0;
					}
				}

				System.out.println("stopwatch");
			}
		}

		// Sélectionner couples FH
		cond = true;
		while (cond) {
			int max = 0;
			int ligne = 0;
			int col = 0;
			cond = false;

			for (int i = 0; i < h.size(); i++) {
				for (int j = 0; j < f.size(); j++) {
					if (tabHF[i][j] >= 10 && tabHF[i][j] > max) {
						max = tabHF[i][j];
						ligne = i;
						col = j;
						cond = true;
					}
				}
			}

			if (cond) {
				Couple couple = new Couple(h.get(ligne), f.get(col), max);
				lCouples.add(couple);

				System.out.println("ligne " + ligne + " col " + col);

				for (int i = 0; i < h.size(); i++) {
					tabHF[i][col] = 0;
				}

				for (int j = 0; j < f.size(); j++) {
					tabHF[ligne][j] = 0;
				}

				System.out.println("stopwatch");
			}
		}

		System.out.println(lCouples);

		// créer des groupes

		// récupérer dernier groupe créé
		List<Integer> dernierGroupe = stDao.getDernierGroupe();
		int _dernierGroupe = dernierGroupe.get(0);
		int place = dernierGroupe.get(1);
		Random rnd = new Random();
		// si groupe pas complet
		if (place < 16) {
			// remplir le groupe
			for (int i = place/2 ; i < 8; i++) {
				cond = true;
				while (cond) {
					int ran = rnd.nextInt(lCouples.size());
					if (lCouples.get(ran).getGroupe() < 1) {
						cond = false;
						lCouples.get(ran).setGroupe(_dernierGroupe);
					}
				}
			}
		}

		
		// remplir les groupes suivants
		
		// nb de couples restants
		int restant = lCouples.size() - (8 - place/2);
		
		
		int nb = (int) restant / 8;

		for (int i = 0; i < nb + 1; i++) {
			for (int j = 0; j < 8; j++) {
				if (lCouples.size()-restant> 8 * i + j) {
					cond = true;
					while (cond) {
						int ran = rnd.nextInt(lCouples.size());
						if (lCouples.get(ran).getGroupe() < 1) {
							cond = false;
							lCouples.get(ran).setGroupe(_dernierGroupe + i + 1);
						}
					}
				}
			}
		}

		// enregistrer les starters
		for (Couple couple : lCouples) {
			LiaisonSITR starter1 = couple.getStarter1();
			LiaisonSITR starter2 = couple.getStarter2();

			((Starter) starter1.getSim()).setGroupe(couple.getGroupe());
			create((Starter) starter1.getSim());
			lsitrSer.create(starter1);

			((Starter) starter2.getSim()).setGroupe(couple.getGroupe());
			starter2.getSim().setCouple(starter1.getSim());
			create((Starter) starter2.getSim());
			lsitrSer.create(starter2);

			starter1.getSim().setCouple(starter2.getSim());
			update((Starter) starter1.getSim());

		}

	}

	private List<LiaisonSITR> creerSims(int taille) {
		// créer liste de sims
		List<LiaisonSITR> lLiaisonSITRs = new ArrayList<>();
		String[] enumSexe = { "F", "M" };
		String[] enumEspece = { "Humain", "Humain", "Humain", "Humain", "Humain", "Humain", "Humain", "Fée", "Vampire",
				"Loup Garou", "Sorcier", "Sirène", "Végésim", "Génie", "Fantôme" };
		String[] enumOrientation = { "Homosexuel", "Hétérosexuel", "Hétérosexuel", "Hétérosexuel" };

		for (int i = 0; i < taille; i++) {
			Random rnd = new Random();
			Starter starter = new Starter();
			starter.setPrenom(String.valueOf((char) (rnd.nextInt(26) + 'A')));
			starter.setNom(String.valueOf((char) (rnd.nextInt(26) + 'A')));
			starter.setSexe(enumSexe[rnd.nextInt(2)]);
			starter.setEspece(enumEspece[rnd.nextInt(15)]);
			starter.setOrientation(enumOrientation[rnd.nextInt(4)]);
			starter.setMarie(false);
			starter.setRealise(false);

			starter.setPeau(rnd.nextInt(10) + 1);
			starter.setPoids(rnd.nextInt(10) + 1);
			starter.setMuscle(rnd.nextInt(10) + 1);
			starter.setPoitrine(rnd.nextInt(10) + 1);
			starter.setCheveux(rnd.nextInt(8) + 1);
			starter.setVisage(rnd.nextInt(12) + 1);
			starter.setCouleurYeux(rnd.nextInt(8) + 1);
			starter.setYeux(rnd.nextInt(15) + 1);
			starter.setNez(rnd.nextInt(24) + 1);
			starter.setBouche(rnd.nextInt(17) + 1);
			starter.setPlat(rnd.nextInt(51) + 1);
			starter.setMusique(rnd.nextInt(28) + 1);
			starter.setCouleur(rnd.nextInt(20) + 1);
			starter.setSigne(rnd.nextInt(12) + 1);
			starter.setGroupe(0);
			Souhait souhait = soSer.getRandom();
			starter.setSouhait(souhait);

			// traits
			LiaisonSITR liaisonSITR = new LiaisonSITR();
			liaisonSITR.setSim(starter);
			liaisonSITR.setTrait1(trSer.getRandom("Mental"));
			liaisonSITR.setHeritage1(false);
			liaisonSITR.setTrait2(trSer.getRandom("Physique"));
			liaisonSITR.setHeritage2(false);
			liaisonSITR.setTrait3(trSer.getRandom("Social"));
			liaisonSITR.setHeritage3(false);
			liaisonSITR.setTrait4(trSer.getRandom("Style de vie"));
			liaisonSITR.setHeritage4(false);
			liaisonSITR.setTrait5(trSer.getRandom());
			while ((liaisonSITR.getTrait1() == liaisonSITR.getTrait5()
					|| liaisonSITR.getTrait2() == liaisonSITR.getTrait5()
					|| liaisonSITR.getTrait3() == liaisonSITR.getTrait5()
					|| liaisonSITR.getTrait4() == liaisonSITR.getTrait5())) {
				liaisonSITR.setTrait5(trSer.getRandom());
			}
			liaisonSITR.setHeritage5(false);

			lLiaisonSITRs.add(liaisonSITR);
		}

		return lLiaisonSITRs;
	}

	private int score(LiaisonSITR sim1, LiaisonSITR sim2) {

		int score = 0;
		Starter starter1 = (Starter) sim1.getSim();
		Starter starter2 = (Starter) sim2.getSim();
		// espece surnaturel + humain ++ surnat pareil +++
		if (starter1.getEspece() != "Humain" && starter2.getEspece() != "Humain") {
			score = score + 10;
		} else if (starter1.getEspece() == "Humain" && starter2.getEspece() == "Humain") {
			score = score + 15;
		} else if (starter1.getEspece() == starter2.getEspece() && starter1.getEspece() != "Humain") {
			score = score + 20;
		}

		// souhait
		if (starter1.getSouhait() == starter2.getSouhait()) {
			score = score + 20;
		}
		// trait
		List<Trait> traits1 = new ArrayList<>();
		traits1.add(sim1.getTrait1());
		traits1.add(sim1.getTrait2());
		traits1.add(sim1.getTrait3());
		traits1.add(sim1.getTrait4());
		traits1.add(sim1.getTrait5());

		List<Trait> traits2 = new ArrayList<>();
		traits2.add(sim2.getTrait1());
		traits2.add(sim2.getTrait2());
		traits2.add(sim2.getTrait3());
		traits2.add(sim2.getTrait4());
		traits2.add(sim2.getTrait5());
		boolean all = true;
		for (int k = 0; k < 5; k++) {
			if (traits2.contains(traits1.get(k))) {
				score = score + 5;
			} else {
				all = false;
			}
		}
		if (all) {
			score = score + 5;
		}

		// peau
		score = score + 10 - Math.abs(starter1.getPeau() - starter2.getPeau());

		all = true;
		// plat
		if (starter1.getPlat() == starter2.getPlat()) {
			score = score + 5;
		} else {
			all = false;
		}
		// musique
		if (starter1.getMusique() == starter2.getMusique()) {
			score = score + 5;
		} else {
			all = false;
		}
		// couleur
		if (starter1.getCouleur() == starter2.getCouleur()) {
			score = score + 5;
		} else {
			all = false;
		}

		if (all) {
			score = score + 5;
		}

		// signe
		if (starter1.getSigne() == starter2.getSigne()) {
			score = score + 10;
		}

		return score;
	}

	@Override
	public List<Integer> getGroupes() {
		return stDao.getDistinctGroups();
	}

}
