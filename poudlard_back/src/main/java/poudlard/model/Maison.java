package poudlard.model;

import javax.persistence.CascadeType;
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

@Entity // Permet de preciser à JPA qu'on veut une table maison (OBLIGATOIRE)
@Table(name="house") //Permet de changer le nom de cette table, maison => house
public class Maison {

	@Id //Precise que la clé primaire est l'attribut id (OBLIGATOIRE)
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Permet d'avoir un id en auto increment (SEMI OBLIGATOIRE)
	private Integer id;
	
	
	@Column(name="house_name",length = 30,nullable = false, unique = true)
	private String nom;
	
	@Column(name="points",nullable = false,columnDefinition = "int(4)")
	private int score;
	
	@Enumerated(EnumType.STRING)
	@Column(name="totem",nullable = false, columnDefinition = "ENUM('Serpent','Aigle','Blaireau','Gryphon')")
	private Mascotte mascotte;


	
	@OneToOne //Pour gerer les liens entre 2 classes, il faut preciser leur cardinalité.  One/Many 
		   //X =>Relation inverse, un professeur peut etre prof principal dans combien de maison à la fois ?
				//Si 0 ou une seule => One
				//Sinon Many
		   //Y => Si c'est une liste  => Many sinon c'est One
	@JoinColumn(name="professeur_principal",nullable = false,unique = true)
	private Professeur professeurPrincipal; 
	
	//Constructeur vide pour les select de JPA (OBLIGATOIRE)
	public Maison() {}
	
	public Maison(String nom,Mascotte mascotte,Professeur professeurPrincipal) {
		this.nom = nom;
		this.mascotte=mascotte;
		this.professeurPrincipal=professeurPrincipal;
		this.score=0;
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

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	
	public Mascotte getMascotte() {
		return mascotte;
	}

	public void setMascotte(Mascotte mascotte) {
		this.mascotte = mascotte;
	}

	
	
	public Professeur getProfesseurPrincipal() {
		return professeurPrincipal;
	}

	public void setProfesseurPrincipal(Professeur professeurPrincipal) {
		this.professeurPrincipal = professeurPrincipal;
	}

	@Override
	public String toString() {
		return "Maison [id=" + id + ", nom=" + nom + ", score=" + score + ", mascotte=" + mascotte
				+ ", professeurPrincipal=" + professeurPrincipal + "]";
	}

	
	
	
	
	

	
	
}
