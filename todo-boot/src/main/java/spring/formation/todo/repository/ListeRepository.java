package spring.formation.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.formation.todo.model.Liste;

public interface ListeRepository extends JpaRepository<Liste, Long>{
}
