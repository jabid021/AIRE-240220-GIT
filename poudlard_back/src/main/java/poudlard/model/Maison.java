package poudlard.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // Permet de preciser à JPA qu'on veut une table maison (OBLIGATOIRE)
public class Maison {

	@Id //Precise que la clé primaire est l'attribut id (OBLIGATOIRE)
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Permet d'avoir un id en auto increment (SEMI OBLIGATOIRE)
	private Integer id;
	private String nom;
	private int score;
	
	
	//Constructeur vide pour les select de JPA (OBLIGATOIRE)
	public Maison() {}
	
	public Maison(String nom) {
		this.nom = nom;
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

	@Override
	public String toString() {
		return "Maison [id=" + id + ", nom=" + nom + ", score=" + score + "]";
	}
	
	
	
	
	

	
	
}
