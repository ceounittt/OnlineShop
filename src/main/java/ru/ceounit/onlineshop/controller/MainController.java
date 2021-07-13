package ru.ceounit.onlineshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.ceounit.onlineshop.model.User;
import ru.ceounit.onlineshop.service.ProductService;

import java.util.Map;

@Controller
public class MainController {
    @Autowired
    ProductService productService;

    @GetMapping("/")
    public String index(Model model){
        //model.addAttribute("products", productService.getAllProducts());
        return "index";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/add")
    public String addProduct(
            @RequestParam String productName,
            @RequestParam String imageName,
            @RequestParam Double cost,
            @RequestParam String description,
            @RequestParam Map<String, String> form
    ) {
        productService.saveProduct(productName, cost, imageName, description);
        return "add";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/add")
    public String addProduct() {return "add";}

    @GetMapping("/login")
    public String login(){ return "login"; }
}
