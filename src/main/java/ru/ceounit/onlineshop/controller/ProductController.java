package ru.ceounit.onlineshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.ceounit.onlineshop.model.Product;
import ru.ceounit.onlineshop.model.User;
import ru.ceounit.onlineshop.model.dto.ProductDto;
import ru.ceounit.onlineshop.repo.ProductRepo;
import ru.ceounit.onlineshop.service.ProductService;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;

    @Autowired
    private ProductRepo productRepo;

    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping("/")
    public String main(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(sort = { "id" }, direction = Sort.Direction.DESC) Pageable pageable,
            @AuthenticationPrincipal User user
    ) {
        Page<ProductDto> page = productService.productList(pageable, filter);

        model.addAttribute("page", page);
        model.addAttribute("url", "/");
        model.addAttribute("filter", filter);

        return "index";
    }

    @GetMapping("/login")
    public String login(){ return "login"; }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/add")
    public String addProduct(
            @Valid Product product,
            BindingResult bindingResult,
            Model model,
            @RequestParam(required = false, defaultValue = "") String filter,
            @PageableDefault(sort = { "id" }, direction = Sort.Direction.DESC) Pageable pageable,
            @RequestParam("file") MultipartFile file
    ) throws IOException {

        if (bindingResult.hasErrors()) {
            Map<String, String> errorsMap = ControllerUtils.getErrors(bindingResult);

            model.mergeAttributes(errorsMap);
            model.addAttribute("product", product);
        } else {
            saveFile(product, file);

            model.addAttribute("message", null);

            productRepo.save(product);
        }

        Page<ProductDto> page = productService.productList(pageable, filter);
        model.addAttribute("page", page);

        return "redirect:";
    }

    private void saveFile(@Valid Product product, @RequestParam("file") MultipartFile file) throws IOException {
        if (file != null && !file.getOriginalFilename().isEmpty()) {
            File uploadDir = new File(uploadPath);

            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            String uuidFile = UUID.randomUUID().toString();
            String resultFilename = uuidFile + "." + file.getOriginalFilename();

            file.transferTo(new File(uploadPath + "/" + resultFilename));

            product.setImageName(resultFilename);
        }
    }

    @PostMapping("/products/edit")
    public String updateProduct(
            @RequestParam("id") Product product,
            @RequestParam("productName") String productName,
            @RequestParam("cost") Double cost,
            @RequestParam("description") String description,
            @RequestParam("file") MultipartFile file
    ) throws IOException {
        if (!StringUtils.isEmpty(productName)) {
            product.setProductName(productName);
        }
        if (!StringUtils.isEmpty(cost)) {
                product.setCost(cost);
            }
        if (!StringUtils.isEmpty(description)) {
            product.setDescription(description);
        }
        saveFile(product, file);

        productRepo.save(product);

        return "redirect:/products";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/products/edit/{product}")
    public String updateProduct(@PathVariable String product) {return "updateProduct";}

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/add")
    public String addProduct() {return "add";}


}
