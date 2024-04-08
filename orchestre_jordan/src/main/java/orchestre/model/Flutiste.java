package orchestre.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Flutiste implements IMusicien {
	@Autowired
	private IInstrument flute;
	private String prenom;
	

	 public IInstrument getFlute() {
		return flute;
	}



	public void setFlute(IInstrument flute) {
		this.flute = flute;
	}



	public String getPrenom() {
		return prenom;
	}



	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}



	public void jouer() {
		System.out.println("Le flutiste "+prenom+" joue ! "+flute.son());	
	}

}
