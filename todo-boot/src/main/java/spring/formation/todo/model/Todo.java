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
	private boolean disabled;
	@ManyToOne
	@JoinColumn(name = "user_id")
	@JsonView(Views.ViewTodoDetail.class)
	private Utilisateur user;

	public Todo() {
		super();
	}

	public Todo(String title, boolean disabled) {
		super();
		this.title = title;
		this.disabled = disabled;
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

	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	public Utilisateur getUser() {
		return user;
	}

	public void setUser(Utilisateur user) {
		this.user = user;
	}

}
