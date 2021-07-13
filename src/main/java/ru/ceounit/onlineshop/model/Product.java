package ru.ceounit.onlineshop.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "Name cannot be empty")
    @Length(max = 50, message = "Name too long (more than 50 characters)")
    private String productName;
    @NotBlank(message = "Cost cannot be empty")
    private Double cost;
    @NotBlank(message = "Product must have image")
    private String imageName;
    @NotBlank(message = "Description cannot be empty")
    @Length(max = 255, message = "Description too long (more than 255 characters)")
    private String description;

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
