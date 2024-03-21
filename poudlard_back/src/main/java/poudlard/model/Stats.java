package poudlard.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Stats {

	
	@Column(name="vie",nullable = false)
	private int pv;
	private int attaque;
	
	public Stats() {}
	
	public Stats(int pv, int attaque) {
		this.pv = pv;
		this.attaque = attaque;
	}


	public int getPv() {
		return pv;
	}


	public void setPv(int pv) {
		this.pv = pv;
	}


	public int getAttaque() {
		return attaque;
	}


	public void setAttaque(int attaque) {
		this.attaque = attaque;
	}
	
	
}
