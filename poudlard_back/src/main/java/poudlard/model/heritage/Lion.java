package poudlard.model.heritage;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

//@Entity
@Table(name="lio")
@PrimaryKeyJoinColumn(name="id_lion")
public class Lion extends Animal {

	
	@Column(nullable = false, name="color")
	private String couleur;
	
	
	public Lion() {}


	public Lion(String nom, String couleur) {
		super(nom);
		this.couleur = couleur;
	}


	public String getCouleur() {
		return couleur;
	}


	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}


	@Override
	public String toString() {
		return "Lion [id=" + id + ", nom=" + nom + ", couleur=" + couleur + "]";
	}
	
	
	
	
}
