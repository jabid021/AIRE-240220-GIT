package poudlard.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="wizard")

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//En mode heritage SingleTable, JPA va creer une colonne DTYPE, @DiscrimnatorColum pour changer son nom 
@DiscriminatorColumn(name="type_sorcier",columnDefinition = "ENUM('teacher','student')")
public abstract class Sorcier {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	@Column(columnDefinition = "VARCHAR(30)")
	protected String nom;
	@Column(length = 30)
	protected String prenom;
	
	@Embedded
	protected Stats statistiques;
	
	
	
	
	public Sorcier() {}

	

	public Sorcier(String nom, String prenom, Stats statistiques) {
		this.nom = nom;
		this.prenom = prenom;
		this.statistiques = statistiques;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}



	public Stats getStatistiques() {
		return statistiques;
	}



	public void setStatistiques(Stats statistiques) {
		this.statistiques = statistiques;
	}
	
	
	
}
