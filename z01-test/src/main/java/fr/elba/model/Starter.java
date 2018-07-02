package fr.elba.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("starter")
public class Starter extends Sim {

	private int peau;
	private int poids;
	private int muscle;
	private int cheveux;
	private int visage;
	private int couleurYeux;
	private int yeux;
	private int nez;
	private int bouche;
	private int poitrine;
	private int plat;
	private int musique;
	private int couleur;
	private int signe;
	private int groupe;

	// liaisons
	@ManyToOne
	private Souhait souhait;

	@OneToOne(mappedBy = "sim")
	private LiaisonSITR trait;

	public Starter() {
		super();
	}

	public Starter(String prenom, String nom, String sexe, String espece, String orientation, boolean marie,
			boolean realise, Famille famille, Famille familleOrigine, Sim couple, int peau, int poids, int muscle,
			int cheveux, int visage, int couleurYeux, int yeux, int nez, int bouche, int poitrine, int plat,
			int musique, int couleur, int signe, Souhait souhait, int groupe) {
		super(prenom, nom, sexe, espece, orientation, marie, realise, famille, familleOrigine, couple);
		this.peau = peau;
		this.poids = poids;
		this.muscle = muscle;
		this.cheveux = cheveux;
		this.visage = visage;
		this.couleurYeux = couleurYeux;
		this.yeux = yeux;
		this.nez = nez;
		this.bouche = bouche;
		this.poitrine = poitrine;
		this.plat = plat;
		this.musique = musique;
		this.couleur = couleur;
		this.signe = signe;
		this.souhait = souhait;
		this.groupe = groupe;
	}

	public Starter(int id, String prenom, String nom, String sexe, String espece, String orientation, boolean marie,
			boolean realise, Famille famille, Famille familleOrigine, Sim couple, int peau, int poids, int muscle,
			int cheveux, int visage, int couleurYeux, int yeux, int nez, int bouche, int poitrine, int plat,
			int musique, int couleur, int signe, Souhait souhait, int groupe) {
		super(id, prenom, nom, sexe, espece, orientation, marie, realise, famille, familleOrigine, couple);
		this.peau = peau;
		this.poids = poids;
		this.muscle = muscle;
		this.cheveux = cheveux;
		this.visage = visage;
		this.couleurYeux = couleurYeux;
		this.yeux = yeux;
		this.nez = nez;
		this.bouche = bouche;
		this.poitrine = poitrine;
		this.plat = plat;
		this.musique = musique;
		this.couleur = couleur;
		this.signe = signe;
		this.souhait = souhait;
		this.groupe = groupe;
	}

	public int getPeau() {
		return peau;
	}

	public void setPeau(int peau) {
		this.peau = peau;
	}

	public int getPoids() {
		return poids;
	}

	public void setPoids(int poids) {
		this.poids = poids;
	}

	public int getMuscle() {
		return muscle;
	}

	public void setMuscle(int muscle) {
		this.muscle = muscle;
	}

	public int getCheveux() {
		return cheveux;
	}

	public void setCheveux(int cheveux) {
		this.cheveux = cheveux;
	}

	public int getVisage() {
		return visage;
	}

	public void setVisage(int visage) {
		this.visage = visage;
	}

	public int getCouleurYeux() {
		return couleurYeux;
	}

	public void setCouleurYeux(int couleurYeux) {
		this.couleurYeux = couleurYeux;
	}

	public int getYeux() {
		return yeux;
	}

	public void setYeux(int yeux) {
		this.yeux = yeux;
	}

	public int getNez() {
		return nez;
	}

	public void setNez(int nez) {
		this.nez = nez;
	}

	public int getBouche() {
		return bouche;
	}

	public void setBouche(int bouche) {
		this.bouche = bouche;
	}

	public int getPoitrine() {
		return poitrine;
	}

	public void setPoitrine(int poitrine) {
		this.poitrine = poitrine;
	}

	public int getPlat() {
		return plat;
	}

	public void setPlat(int plat) {
		this.plat = plat;
	}

	public int getMusique() {
		return musique;
	}

	public void setMusique(int musique) {
		this.musique = musique;
	}

	public int getCouleur() {
		return couleur;
	}

	public void setCouleur(int couleur) {
		this.couleur = couleur;
	}

	public int getSigne() {
		return signe;
	}

	public void setSigne(int signe) {
		this.signe = signe;
	}

	public Souhait getSouhait() {
		return souhait;
	}

	public void setSouhait(Souhait souhait) {
		this.souhait = souhait;
	}

	public LiaisonSITR getTrait() {
		return trait;
	}

	public void setTrait(LiaisonSITR trait) {
		this.trait = trait;
	}
	
	public int getGroupe() {
		return groupe;
	}

	public void setGroupe(int groupe) {
		this.groupe = groupe;
	}

	@Override
	public String toString() {
		return "Starter [peau=" + peau + ", poids=" + poids + ", muscle=" + muscle + ", cheveux=" + cheveux
				+ ", visage=" + visage + ", couleurYeux=" + couleurYeux + ", yeux=" + yeux + ", nez=" + nez
				+ ", bouche=" + bouche + ", poitrine=" + poitrine + ", plat=" + plat + ", musique=" + musique
				+ ", couleur=" + couleur + ", signe=" + signe + ", groupe=" + groupe + ", "
				+ (souhait != null ? "souhait=" + souhait + ", " : "") + (trait != null ? "trait=" + trait : "") + "]";
	}

}
