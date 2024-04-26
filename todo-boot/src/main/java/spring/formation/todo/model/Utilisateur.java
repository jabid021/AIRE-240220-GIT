package spring.formation.todo.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Utilisateur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.ViewCommon.class)
	private Long id;
	@Column(length = 255)
	@JsonView(Views.ViewCommon.class)
	private String nom;
	@Column(length = 255)
	@JsonView(Views.ViewCommon.class)
	private String prenom;
	@Column(length = 50)
	@JsonView(Views.ViewCommon.class)
	private String login;
	@Column(length = 50)
	@JsonView(Views.ViewCommon.class)
	private String password;
	@JsonView(Views.ViewCommon.class)
	private boolean disabled;
	@OneToMany(mappedBy = "user")
	@JsonView(Views.ViewUtilisateurDetail.class)
	private List<Todo> todos = new ArrayList<>();

	public Utilisateur() {
		super();
	}

	public Utilisateur(String nom, String prenom, String login, String password, boolean disabled) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.password = password;
		this.disabled = disabled;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	public List<Todo> getTodos() {
		return todos;
	}

	public void setTodos(List<Todo> todos) {
		this.todos = todos;
	}

}
