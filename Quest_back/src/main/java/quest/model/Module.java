package quest.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import quest.view.Views;
@Entity
@Table(name="module")
public class Module {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.Common.class)
	private Integer id;
	@Column(nullable = false)
	@JsonView(Views.Common.class)
	private LocalDate debut;
	@Column(nullable = false)
	@JsonView(Views.Common.class)
	private LocalDate fin;
	@JsonView(Views.Common.class)
	private int quest;
	
	@ManyToOne
	@JoinColumn(name="matiere",nullable=false)
	@JsonView(Views.Module.class)
	private Matiere matiere;
	
	@ManyToOne
	@JoinColumn(name="filiere",nullable=false)
	@JsonView(Views.Module.class)
	private Filiere filiere;
	
	
	@ManyToOne
	@JoinColumn(name="formateur")
	@JsonView(Views.Module.class)
	private Formateur formateur;

	public Module() {}

	public Module(Integer id,LocalDate debut, LocalDate fin, int quest, Filiere filiere,Matiere matiere,
			Formateur formateur) {
		this.id=id;
		this.debut = debut;
		this.fin = fin;
		this.quest = quest;
		this.matiere = matiere;
		this.filiere = filiere;
		this.formateur = formateur;
	}

	public Module(LocalDate debut, LocalDate fin, int quest, Filiere filiere,Matiere matiere,
			Formateur formateur) {
		this.debut = debut;
		this.fin = fin;
		this.quest = quest;
		this.matiere = matiere;
		this.filiere = filiere;
		this.formateur = formateur;
	}

	public Module(LocalDate debut, LocalDate fin, int quest,Filiere filiere, Matiere matiere) {
		this.debut = debut;
		this.fin = fin;
		this.quest = quest;
		this.matiere = matiere;
		this.filiere = filiere;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public int getQuest() {
		return quest;
	}

	public void setQuest(int quest) {
		this.quest = quest;
	}

	public Matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	public Filiere getFiliere() {
		return filiere;
	}

	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}

	public Formateur getFormateur() {
		return formateur;
	}

	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}

	@Override
	public String toString() {
		return "Module [id=" + id + ", debut=" + debut + ", fin=" + fin + ", quest=" + quest + ", matiere="
				+ matiere + ", filiere=" + filiere + ", formateur=" + formateur + "]";
	}



}
