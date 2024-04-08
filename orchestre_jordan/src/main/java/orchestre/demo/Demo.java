package orchestre.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class Demo {
	private int volume;
	private boolean fenetre;
	

	private Demo2 demo2;
	
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

	
	
	public Demo2 getDemo2() {
		return demo2;
	}

	public void setDemo2(Demo2 demo2) {
		this.demo2 = demo2;
	}

	@Override
	public String toString() {
		return "Demo [volume=" + volume + ", fenetre=" + fenetre + ", demo2=" + demo2 + "]";
	}

	
	
	
}
