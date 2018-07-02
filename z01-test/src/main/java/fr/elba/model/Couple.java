package fr.elba.model;

public class Couple {

	private LiaisonSITR starter1;
	private LiaisonSITR starter2;
	private int score;
	private int groupe;
	
	public Couple() {
		super();
	}
	public Couple(LiaisonSITR starter1, LiaisonSITR starter2, int score) {
		super();
		this.starter1 = starter1;
		this.starter2 = starter2;
		this.score = score;
	}
	public LiaisonSITR getStarter1() {
		return starter1;
	}
	public void setStarter1(LiaisonSITR starter1) {
		this.starter1 = starter1;
	}
	public LiaisonSITR getStarter2() {
		return starter2;
	}
	public void setStarter2(LiaisonSITR starter2) {
		this.starter2 = starter2;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getGroupe() {
		return groupe;
	}
	public void setGroupe(int groupe) {
		this.groupe = groupe;
	}
	
	
}
