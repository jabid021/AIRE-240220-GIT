package quest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="ordinateur")
public class Ordinateur {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private int ram;
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "ENUM('Apple','Asus','Dell','HP','Acer'",nullable=false)
	private Marque marque;
	
	@OneToOne
	@JoinColumn(name="stagiaire")
	private Stagiaire stagiaire;
	
	public Ordinateur() {}
	
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