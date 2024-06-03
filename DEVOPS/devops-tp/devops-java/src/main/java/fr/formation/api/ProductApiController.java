package fr.formation.api;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.model.Product;
import fr.formation.repo.ProductRepository;
import fr.formation.request.CreateProductRequest;
import fr.formation.response.EntityCreatedResponse;
import fr.formation.response.ProductResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/product")
public class ProductApiController {
    private static final Logger log = LoggerFactory.getLogger(ProductApiController.class);

    private final ProductRepository repository;

    public ProductApiController(ProductRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<ProductResponse> findAll() {
        log.debug("Looking for all products in db ...");

        return this.repository.findAll().stream()
            .map(p -> {
                ProductResponse resp = new ProductResponse();

                BeanUtils.copyProperties(p, resp);

                return resp;
            })
            .toList()
        ;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EntityCreatedResponse create(@Valid @RequestBody CreateProductRequest request) {
        Product product = new Product();

        log.debug("Creating new product ...");

        BeanUtils.copyProperties(request, product);
        
        this.repository.save(product);
        
        log.debug("Product {} created!", product.getId());

        return new EntityCreatedResponse(product.getId());
    }
}
