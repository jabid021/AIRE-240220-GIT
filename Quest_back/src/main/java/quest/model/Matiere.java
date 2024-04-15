package quest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="matiere")
public class Matiere {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer  id ;
	@Column(length = 50, nullable=false)            
	@NotBlank(message = "Libelle ne peut pas etre vide !")
	@Size(min=5 ,max = 50)
	private String libelle;

	public Matiere() {}
	public Matiere(Integer id,String libelle) {
		this.id=id;
		this.libelle = libelle;
	}

	public Matiere(String libelle) {
		this.libelle = libelle;
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
	
	
	public String getInfoSelect() 
	{
		return this.id+"-"+this.libelle;
	}
	@Override
	public String toString() {
		return "Matiere [id=" + id + ", libelle=" + libelle + "]";
	}




}
