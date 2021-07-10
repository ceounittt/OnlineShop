package ru.ceounit.onlineshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ceounit.onlineshop.model.Product;
import ru.ceounit.onlineshop.repo.ProductRepo;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepo;

    public List<Product> getAllProducts(){
        return productRepo.findAll();
    }

    public Product getProduct(Integer id){ 
        return productRepo.getOne(id);
    }
}

