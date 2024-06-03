package fr.formation.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.model.Product;

public interface ProductRepository extends JpaRepository<Product, String> {
    
}
