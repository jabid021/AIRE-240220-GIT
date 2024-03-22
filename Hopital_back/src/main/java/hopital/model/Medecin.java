package hopital.model;

import java.util.ArrayList;
import java.util.List;

public class Medecin extends Compte{

	private transient List<Visite> visites = new ArrayList();
	private transient int salle;
	
	
	public Medecin(Integer id, String login, String password) {
		super(id, login, password);
	}
	
	public List<Visite> getVisites() {
		return visites;
	}

	public void setVisites(List<Visite> visites) {
		this.visites = visites;
	}

	public int getSalle() {
		return salle;
	}

	public void setSalle(int salle) {
		this.salle = salle;
	}

	@Override
	public String toString() {
		return "Medecin [id=" + id + ", login=" + login + ", password=" + password + ", visites=" + visites + ", salle="
				+ salle + "]";
	}
	
	
	
	
	
	
}
