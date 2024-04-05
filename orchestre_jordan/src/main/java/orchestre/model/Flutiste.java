package orchestre.model;

public class Flutiste implements IMusicien {
	
	private IInstrument flute;
	private String prenom;
	
	
	 public void jouer() {
		System.out.println("Le flutiste "+prenom+" joue ! "+flute.son());	
	}

}
