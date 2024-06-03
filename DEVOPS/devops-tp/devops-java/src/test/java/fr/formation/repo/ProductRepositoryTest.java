package fr.formation.repo;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;

import fr.formation.model.Product;

@DataJpaTest
@Sql(scripts = "/products.sql", executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(scripts = "/clear-all.sql", executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
class ProductRepositoryTest {
    @Autowired
    private ProductRepository repository;

    @Test
    void shouldFindAllFindsTwo() {
        // given

        // when
        List<Product> products = this.repository.findAll();

        // then
        Assertions.assertEquals(2, products.size());
    }
}
