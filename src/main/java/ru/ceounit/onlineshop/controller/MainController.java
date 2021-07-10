package ru.ceounit.onlineshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.ceounit.onlineshop.model.Product;
import ru.ceounit.onlineshop.repo.ProductRepo;
import ru.ceounit.onlineshop.service.ProductService;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    ProductService productService;

    @GetMapping("/main")
    public String index(Model model){
        model.addAttribute("products", productService.getAllProducts());
        return "index";
    }
}
