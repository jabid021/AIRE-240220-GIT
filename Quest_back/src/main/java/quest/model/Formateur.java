package quest.model;

public class Formateur extends Compte{

	private double tarif;
	
	public Formateur(Integer id,String email, String password, String prenom, String nom, double tarif) {
		super(id,email, password, prenom, nom);
		this.tarif = tarif;
	}

	
	public Formateur(String email, String password, String prenom, String nom, double tarif) {
		super(email, password, prenom, nom);
		this.tarif = tarif;
	}

	public double getTarif() {
		return tarif;
	}

	public void setTarif(double tarif) {
		this.tarif = tarif;
	}

	@Override
	public String toString() {
		return "Formateur [tarif=" + tarif + ", id=" + id + ", email=" + email + ", password=" + password + ", prenom="
				+ prenom + ", nom=" + nom + "]";
	}
	
}
