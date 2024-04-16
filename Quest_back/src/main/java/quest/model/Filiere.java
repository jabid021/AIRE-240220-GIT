package quest.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="filiere")
public class Filiere {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(length = 30, nullable=false)
	@NotBlank(message = "Libelle ne peut pas etre vide !")
	private String libelle;
	@Valid
	private LocalDate debut;
	@Valid
	private LocalDate fin;
	
	/*@OneToMany(mappedBy="filiere")
	private List<Stagiaire> inscrits;*/
	
	public Filiere() {}
	
	public Filiere(Integer id,String libelle, LocalDate debut, LocalDate fin) {

		this.id=id;
		this.libelle = libelle;
		this.debut = debut;
		this.fin = fin;

	}

	public Filiere(String libelle, LocalDate debut, LocalDate fin) {

		this.libelle = libelle;
		this.debut = debut;
		this.fin = fin;

	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getLibelle() {
		return libelle;
	}


	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}


	public LocalDate getDebut() {
		return debut;
	}


	public void setDebut(LocalDate debut) {
		this.debut = debut;
	}


	public LocalDate getFin() {
		return fin;
	}


	public void setFin(LocalDate fin) {
		this.fin = fin;
	}
	
	public String getInfos() {
		return this.id+"-"+this.libelle;
	}

	
	/*public List<Stagiaire> getInscrits() {
		return inscrits;
	}

	public void setInscrits(List<Stagiaire> inscrits) {
		this.inscrits = inscrits;
	}
*/
	@Override
	public String toString() {
		return "Filiere [id=" + id + ", libelle=" + libelle + ", debut=" + debut + ", fin=" + fin + "]";
	}

}
