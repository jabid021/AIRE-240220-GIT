package orchestre.demo;

public class Demo {
	private int volume;
	private boolean fenetre;
	
	public Demo() {
		this.fenetre=false;
	}
	
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	public boolean isFenetre() {
		return fenetre;
	}
	public void setFenetre(boolean fenetre) {
		this.fenetre = fenetre;
	}

	
	@Override
	public String toString() {
		return "Demo [volume=" + volume + ", fenetre=" + fenetre + "]";
	}
	
	
	
	
}
