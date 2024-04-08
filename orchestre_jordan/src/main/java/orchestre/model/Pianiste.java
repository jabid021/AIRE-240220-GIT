package orchestre.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Pianiste implements IMusicien {
	@Autowired
	private Piano instrument;
	private String prenom;
	
	 public Piano getInstrument() {
		return instrument;
	}


	public void setInstrument(Piano instrument) {
		this.instrument = instrument;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public void jouer() {
		System.out.println("Le pianiste "+prenom+" joue ! "+instrument.son());	
	}

}
