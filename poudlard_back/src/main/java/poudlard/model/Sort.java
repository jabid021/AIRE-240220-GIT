package poudlard.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="spell")
//@SequenceGenerator(sequenceName =  "table_id_spell", name ="seqSort" )
public class Sort {

	@Id
	//Mode table : Creation d'une table partagee pour toutes les classes en mode table afin de leur affecter leurs id
	//Mode sequence : Creation d'une table custom, qu'on peut choisir d'attacher à certaines classes
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqSort")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 30,nullable = false)
	private String libelle;
	
	public Sort() {}

	public Sort(String libelle) {
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

	@Override
	public String toString() {
		return "Sort [id=" + id + ", libelle=" + libelle + "]";
	}
	
	
}
