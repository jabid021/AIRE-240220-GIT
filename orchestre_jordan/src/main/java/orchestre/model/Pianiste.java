package orchestre.model;

public class Pianiste implements IMusicien {
	
	private Piano instrument;
	private String prenom;
	
	
	 public void jouer() {
		System.out.println("Le pianiste "+prenom+" joue ! "+instrument.son());	
	}

}
