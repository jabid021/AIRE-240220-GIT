package orchestre.model;

public class Pianiste implements IMusicien {
	
	private Piano instrument;
	private String prenom;
	
	public Pianiste() {
		this.prenom="Eric";
	}
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
