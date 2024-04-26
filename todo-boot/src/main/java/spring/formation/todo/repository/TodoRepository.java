package spring.formation.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.formation.todo.model.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long>{

}
