package orchestre.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Guitariste implements IMusicien {
	
	@Autowired
	@Qualifier("guitare")
	private IInstrument instrument;
	private String prenom;
	
	
	 public IInstrument getInstrument() {
		return instrument;
	}


	public void setInstrument(IInstrument instrument) {
		this.instrument = instrument;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public void jouer() {
		System.out.println("Le guitariste "+prenom+" joue ! "+instrument.son());	
	}

}
