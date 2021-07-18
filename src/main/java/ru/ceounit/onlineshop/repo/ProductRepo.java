package ru.ceounit.onlineshop.repo;

import com.sun.mail.imap.protocol.ID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import ru.ceounit.onlineshop.model.Product;
import ru.ceounit.onlineshop.model.dto.ProductDto;

import javax.validation.Valid;

public interface ProductRepo extends CrudRepository<Product, Long> {

    Page<ProductDto> findByProductName(String filter, Pageable pageable);

    Page<ProductDto> findAll(Pageable pageable);

    /*Product findByMaxCost(Double cost);

    Product findByMinCost(Double cost);*/
}

