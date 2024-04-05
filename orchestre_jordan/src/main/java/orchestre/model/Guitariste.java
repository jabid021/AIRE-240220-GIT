package orchestre.model;

public class Guitariste implements IMusicien {
	
	private IInstrument instrument;
	private String prenom;
	
	
	 public void jouer() {
		System.out.println("Le guitariste "+prenom+" joue ! "+instrument.son());	
	}

}
