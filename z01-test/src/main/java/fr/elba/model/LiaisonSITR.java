package fr.elba.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NamedNativeQuery;

@Entity
@Table(name = "liasonssitr")
public class LiaisonSITR {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	
	private boolean heritage1;
	private boolean heritage2;
	private boolean heritage3;
	private boolean heritage4;
	private boolean heritage5;

	// liaisons
	@OneToOne
	private Sim sim;

	@ManyToOne
	private Trait trait1;

	@ManyToOne
	private Trait trait2;

	@ManyToOne
	private Trait trait3;

	@ManyToOne
	private Trait trait4;

	@ManyToOne
	private Trait trait5;

	public LiaisonSITR() {
		super();
	}

	public LiaisonSITR(boolean heritage1, boolean heritage2, boolean heritage3, boolean heritage4, boolean heritage5,
			Sim sim, Trait trait1, Trait trait2, Trait trait3, Trait trait4, Trait trait5) {
		super();
		this.heritage1 = heritage1;
		this.heritage2 = heritage2;
		this.heritage3 = heritage3;
		this.heritage4 = heritage4;
		this.heritage5 = heritage5;
		this.sim = sim;
		this.trait1 = trait1;
		this.trait2 = trait2;
		this.trait3 = trait3;
		this.trait4 = trait4;
		this.trait5 = trait5;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isHeritage1() {
		return heritage1;
	}

	public void setHeritage1(boolean heritage1) {
		this.heritage1 = heritage1;
	}

	public boolean isHeritage2() {
		return heritage2;
	}

	public void setHeritage2(boolean heritage2) {
		this.heritage2 = heritage2;
	}

	public boolean isHeritage3() {
		return heritage3;
	}

	public void setHeritage3(boolean heritage3) {
		this.heritage3 = heritage3;
	}

	public boolean isHeritage4() {
		return heritage4;
	}

	public void setHeritage4(boolean heritage4) {
		this.heritage4 = heritage4;
	}

	public boolean isHeritage5() {
		return heritage5;
	}

	public void setHeritage5(boolean heritage5) {
		this.heritage5 = heritage5;
	}

	public Sim getSim() {
		return sim;
	}

	public void setSim(Sim sim) {
		this.sim = sim;
	}

	public Trait getTrait1() {
		return trait1;
	}

	public void setTrait1(Trait trait1) {
		this.trait1 = trait1;
	}

	public Trait getTrait2() {
		return trait2;
	}

	public void setTrait2(Trait trait2) {
		this.trait2 = trait2;
	}

	public Trait getTrait3() {
		return trait3;
	}

	public void setTrait3(Trait trait3) {
		this.trait3 = trait3;
	}

	public Trait getTrait4() {
		return trait4;
	}

	public void setTrait4(Trait trait4) {
		this.trait4 = trait4;
	}

	public Trait getTrait5() {
		return trait5;
	}

	public void setTrait5(Trait trait5) {
		this.trait5 = trait5;
	}

	@Override
	public String toString() {
		return "LiaisonSITR [heritage1=" + heritage1 + ", heritage2=" + heritage2 + ", heritage3=" + heritage3
				+ ", heritage4=" + heritage4 + ", heritage5=" + heritage5 + ", "
				+ (sim != null ? "sim=" + sim + ", " : "") + (trait1 != null ? "trait1=" + trait1 + ", " : "")
				+ (trait2 != null ? "trait2=" + trait2 + ", " : "") + (trait3 != null ? "trait3=" + trait3 + ", " : "")
				+ (trait4 != null ? "trait4=" + trait4 + ", " : "") + (trait5 != null ? "trait5=" + trait5 : "") + "]";
	}

}
