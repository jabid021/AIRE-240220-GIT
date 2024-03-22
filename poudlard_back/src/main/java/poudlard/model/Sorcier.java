package poudlard.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="wizard",uniqueConstraints = @UniqueConstraint(columnNames = {"nom","prenom"}))

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
	
	
	@OneToMany
	@JoinTable
	(
			name="apprentissages", //Change le nom de la table de jointure
			//Cette table de jointure possede deux colonnes id, celui d'un sorcier + celui d'un sort
			//Le lien en Java se faisant dans la classe Sorcier, l'id sorcier est l'id "principal"
			//L'id sort est l'id "inverse" / "l'autre"
			//joinColumns => l'id principal (a gauche dans la table)
			//inverseJoinColumn => l'id secondaire (a droite dans la table)
			joinColumns = @JoinColumn(name="sorcier"),
			inverseJoinColumns = @JoinColumn(name="apprentissage"),
			uniqueConstraints = @UniqueConstraint(columnNames = { "apprentissage","sorcier" })
			
			
	)
	protected List<Apprentissage> grimoire = new ArrayList();
	
	
	
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



	public List<Apprentissage> getGrimoire() {
		return grimoire;
	}



	public void setGrimoire(List<Apprentissage> grimoire) {
		this.grimoire = grimoire;
	}
	
	
	
	
}
