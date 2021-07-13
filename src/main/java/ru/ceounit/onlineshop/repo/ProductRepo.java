package ru.ceounit.onlineshop.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ceounit.onlineshop.model.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {
    /*Product findByProductName(String productName);

    Product findByMaxCost(Double cost);

    Product findByMinCost(Double cost);
*/
}

