package orchestre.model;

public class Flutiste implements IMusicien {
	
	private IInstrument flute;
	private String prenom="Olivier";
	

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
