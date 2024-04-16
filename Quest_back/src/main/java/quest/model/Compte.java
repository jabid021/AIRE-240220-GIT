package quest.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonView;

import quest.view.Views;

@Entity
@Table(name="compte")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="role",columnDefinition = "enum('Stagiaire', 'Formateur')")
public abstract class Compte {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.Common.class)
	protected Integer id;
	@Column(length = 50, nullable=false, unique=true)
	@JsonView(Views.Common.class)
	protected String email;
	@Column(length = 120, nullable=false)
	@Size(min = 8)
	@JsonView(Views.Compte.class)
	protected String password;
	@Column(length = 30, nullable=false)
	@NotBlank
	@JsonView(Views.Common.class)
	protected String prenom;
	@Column(length = 50, nullable=false)
	@NotBlank
	@JsonView(Views.Common.class)
	protected String nom;
	
	public Compte() {}
	
	protected Compte(Integer id,String email, String password, String prenom, String nom) {
		this.id=id;
		this.email = email;
		this.password = password;
		this.prenom = prenom;
		this.nom = nom;
	}
	
	protected Compte(String email, String password, String prenom, String nom) {
		this.email = email;
		this.password = password;
		this.prenom = prenom;
		this.nom = nom;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
		
}
