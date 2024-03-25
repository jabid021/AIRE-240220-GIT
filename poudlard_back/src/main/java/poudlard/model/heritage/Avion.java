package poudlard.model.heritage;

import javax.persistence.Entity;

//@Entity

public class Avion extends Vehicule{

	
	private int nbPlaces;
	
	public Avion() {}

	public Avion(int nbRoues, int nbPlaces) {
		super(nbRoues);
		this.nbPlaces = nbPlaces;
	}

	public int getNbPlaces() {
		return nbPlaces;
	}

	public void setNbPlaces(int nbPlaces) {
		this.nbPlaces = nbPlaces;
	}

	@Override
	public String toString() {
		return "Avion [id=" + id + ", nbRoues=" + nbRoues + ", nbPlaces=" + nbPlaces + "]";
	}
	
	
}
