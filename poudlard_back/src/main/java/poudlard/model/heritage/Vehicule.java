package poudlard.model.heritage;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@SequenceGenerator(name = "seqVehicule",sequenceName = "id_vehicules")
public abstract class Vehicule {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seqVehicule")
	@Column(name="id_vehicule")
	protected Integer id;
	
	protected int nbRoues;
	
	
	public Vehicule() {}


	public Vehicule(int nbRoues) {
		this.nbRoues = nbRoues;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public int getNbRoues() {
		return nbRoues;
	}


	public void setNbRoues(int nbRoues) {
		this.nbRoues = nbRoues;
	}
	
	
}
