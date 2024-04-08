package orchestre.demo;

import org.springframework.stereotype.Component;

@Component
public class Demo2 {

	private int nb;

	public int getNb() {
		return nb;
	}

	public void setNb(int nb) {
		this.nb = nb;
	}

	@Override
	public String toString() {
		return "Demo2 [nb=" + nb + "]";
	}
	
	
}
