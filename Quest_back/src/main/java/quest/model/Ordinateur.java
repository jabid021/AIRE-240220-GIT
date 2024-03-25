package quest.model;

public class Ordinateur {
	private Integer id;
	private int ram;
	private Marque marque;
	private Stagiaire stagiaire;
	
	
	public Ordinateur(Integer id,int ram, Marque marque, Stagiaire stagiaire) {
		this.id=id;
		this.ram = ram;
		this.marque = marque;
		this.stagiaire = stagiaire;
	}

	
	public Ordinateur(int ram, Marque marque) {
		this.ram = ram;
		this.marque = marque;
	}


	public Ordinateur(int ram, Marque marque, Stagiaire stagiaire) {
		this.ram = ram;
		this.marque = marque;
		this.stagiaire = stagiaire;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public int getRam() {
		return ram;
	}


	public void setRam(int ram) {
		this.ram = ram;
	}


	public Marque getMarque() {
		return marque;
	}
	
	public void setMarque(Marque marque) {
		this.marque = marque;
	}

	public Stagiaire getStagiaire() {
		return stagiaire;
	}


	public void setStagiaire(Stagiaire stagiaire) {
		this.stagiaire = stagiaire;
	}


	@Override
	public String toString() {
		return "Ordinateur [id=" + id + ", ram=" + ram + ", marque=" + marque + ", stagiaire=" + stagiaire + "]";
	}


	


	
	
	
	
}