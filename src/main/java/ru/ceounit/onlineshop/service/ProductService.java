package ru.ceounit.onlineshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ceounit.onlineshop.model.Product;
import ru.ceounit.onlineshop.repo.ProductRepo;

import java.util.List;
import java.util.Map;

@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepo;
    private Product product;

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public void saveProduct(String productName, Double cost, String imageName,
                            String description) {
        product.setProductName(productName);
        product.setCost(cost);
        product.setImageName(imageName);
        product.setDescription(description);

    }
}

