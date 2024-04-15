package quest.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

@Embeddable
public class Adresse {
	
	@Column(length = 10)
	@NotBlank(message= "numero NON VALIDE!!")
	private String numero;
	@Column(length = 50)
	@NotBlank(message= "voie NON VALIDE!!")
	private String voie;
	@Column(length = 50)
	@NotBlank(message= "ville NON VALIDE!!")
	private String ville;
	@Column(length = 15)
	@NotBlank(message= "cp NON VALIDE!!")
	private String cp;
	

	public Adresse() {}
	
	public Adresse(String numero, String voie, String ville, String cp) {
		this.numero = numero;
		this.voie = voie;
		this.ville = ville;
		this.cp = cp;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getVoie() {
		return voie;
	}

	public void setVoie(String voie) {
		this.voie = voie;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	@Override
	public String toString() {
		return "Adresse [numero=" + numero + ", voie=" + voie + ", ville=" + ville + ", cp=" + cp + "]";
	}
	
}
