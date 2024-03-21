package poudlard.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	
	//Constructeur vide pour les select de JPA (OBLIGATOIRE)
	public Maison() {}
	
	public Maison(String nom,Mascotte mascotte) {
		this.nom = nom;
		this.mascotte=mascotte;
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

	@Override
	public String toString() {
		return "Maison [id=" + id + ", nom=" + nom + ", score=" + score + ", mascotte=" + mascotte + "]";
	}

	
	
	
	

	
	
}
