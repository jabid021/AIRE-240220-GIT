package hopital.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="visite")
public class Visite {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="numero")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="id_patient")
	private Patient patient;
	@ManyToOne
	@JoinColumn(name="id_medecin")
	private Medecin medecin;
	private int salle;
	private double prix;
	@Column(name="date_visite",nullable = false)
	private LocalDate dateVisite;
	
	public Visite() {}
	
	public Visite(Integer id, Patient patient, Medecin medecin, int salle, double prix, LocalDate dateVisite) {
		this.id = id;
		this.patient = patient;
		this.medecin = medecin;
		this.salle = salle;
		this.prix = prix;
		this.dateVisite = dateVisite;
	}


	public Visite(Patient patient, Medecin medecin) {
		this.patient = patient;
		this.medecin = medecin;
		this.salle = medecin.getSalle();
		this.prix=20;
		this.dateVisite=LocalDate.now();
	}


	public Integer getId() {
		return id;
	}


	public Patient getPatient() {
		return patient;
	}


	public Medecin getMedecin() {
		return medecin;
	}


	public int getSalle() {
		return salle;
	}


	public double getPrix() {
		return prix;
	}


	public LocalDate getDateVisite() {
		return dateVisite;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public void setPatient(Patient patient) {
		this.patient = patient;
	}


	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}


	public void setSalle(int salle) {
		this.salle = salle;
	}


	public void setPrix(double prix) {
		this.prix = prix;
	}


	public void setDateVisite(LocalDate dateVisite) {
		this.dateVisite = dateVisite;
	}


	@Override
	public String toString() {
		return "Visite [id=" + id + ", patient=" + patient + ", medecin=" + medecin.getId() + ", salle=" + salle + ", prix="
				+ prix + ", dateVisite=" + dateVisite + "]";
	}
	
	
	
	
}
