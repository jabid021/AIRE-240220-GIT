package spring.formation.todo.model;

import com.fasterxml.jackson.annotation.JsonView;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Todo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.ViewCommon.class)
	private Long id;
	@Column(length = 255)
	@JsonView(Views.ViewCommon.class)
	private String title;
	@JsonView(Views.ViewCommon.class)
	private boolean completed;
	@ManyToOne
	@JoinColumn(name = "user_id")
	@JsonView(Views.ViewTodoDetail.class)
	private Utilisateur user;
	@ManyToOne
	@JoinColumn(name="liste_id")
	@JsonView(Views.ViewTodo.class)
	private Liste liste;

	public Todo() {
		super();
	}

	public Todo(String title, boolean completed) {
		super();
		this.title = title;
		this.completed = completed;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public Utilisateur getUser() {
		return user;
	}

	public void setUser(Utilisateur user) {
		this.user = user;
	}

}
