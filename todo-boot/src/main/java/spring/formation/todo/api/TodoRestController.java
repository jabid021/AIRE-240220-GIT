package spring.formation.todo.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import spring.formation.todo.model.Todo;
import spring.formation.todo.model.Views;
import spring.formation.todo.repository.TodoRepository;

@RestController
@RequestMapping("/api/todo")
public class TodoRestController {

	@Autowired
	private TodoRepository todoRepository;

	@GetMapping("")
	@JsonView(Views.ViewTodo.class)
	public List<Todo> findAll() {
		return this.todoRepository.findAll();
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewTodoDetail.class)
	public Todo findById(@PathVariable("id") Long id) {
		Optional<Todo> optTodo = this.todoRepository.findById(id);

		if (optTodo.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id Todo inexistant");
		}

		return optTodo.get();
	}

	@PostMapping("")
	@JsonView(Views.ViewTodo.class)
	public Todo create(@RequestBody Todo todo) {
		return this.todoRepository.save(todo);
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewTodo.class)
	public Todo update(@RequestBody Todo todo, @PathVariable("id") Long id) {
		if (id != todo.getId() || !this.todoRepository.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id Todo inexistant");
		}

		return this.todoRepository.save(todo);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		if (!this.todoRepository.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id Todo inexistant");
		}

		this.todoRepository.deleteById(id);
	}

}
