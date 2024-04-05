package orchestre.model;

public class Guitariste implements IMusicien {
	
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
