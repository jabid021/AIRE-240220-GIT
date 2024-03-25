package quest.model;

public abstract class Compte {

	protected Integer id;
	protected String email;
	protected String password;
	protected String prenom;
	protected String nom;
	
	protected Compte(Integer id,String email, String password, String prenom, String nom) {
		this.id=id;
		this.email = email;
		this.password = password;
		this.prenom = prenom;
		this.nom = nom;
	}
	
	protected Compte(String email, String password, String prenom, String nom) {
		this.email = email;
		this.password = password;
		this.prenom = prenom;
		this.nom = nom;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
		
}
