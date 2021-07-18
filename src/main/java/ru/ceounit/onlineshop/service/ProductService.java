package ru.ceounit.onlineshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.ceounit.onlineshop.model.Product;
import ru.ceounit.onlineshop.model.dto.ProductDto;
import ru.ceounit.onlineshop.repo.ProductRepo;

@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepo;
    private Product product;

    public Page<ProductDto> productList(Pageable pageable, String filter) {
        if (filter != null && !filter.isEmpty()) {
            return productRepo.findByProductName(filter, pageable);
        } else {
            return productRepo.findAll(pageable);
        }
    }
}

