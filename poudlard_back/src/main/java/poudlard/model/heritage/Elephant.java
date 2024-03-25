package poudlard.model.heritage;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="eleph")
public class Elephant extends Animal{
	
	
	private boolean defenses;
	
	public Elephant() {}

	public Elephant(String nom, boolean defenses) {
		super(nom);
		this.defenses = defenses;
	}

	public boolean isDefenses() {
		return defenses;
	}

	public void setDefenses(boolean defenses) {
		this.defenses = defenses;
	}

	@Override
	public String toString() {
		return "Elephant [defenses=" + defenses + ", id=" + id + ", nom=" + nom + "]";
	}
	

}
