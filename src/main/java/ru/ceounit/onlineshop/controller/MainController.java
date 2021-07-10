package ru.ceounit.onlineshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import ru.ceounit.onlineshop.model.User;
import ru.ceounit.onlineshop.service.ProductService;

@Controller
public class MainController {
    @Autowired
    ProductService productService;

    @GetMapping("/main")
    public String index(Model model){
        model.addAttribute("products", productService.getAllProducts());
        return "index";
    }

    @GetMapping
    public String add(
            @AuthenticationPrincipal User user,
            BindingResult bindingResult,
            Model model
    ) {
        return null;
    }
}
