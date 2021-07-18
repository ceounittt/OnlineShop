package ru.ceounit.onlineshop.model.dto;

public class ProductDto {
    private final Long id;
    private final String productName;
    private final Double cost;
    private final String imageName;
    private final String description;

    public ProductDto(Long id, String productName, Double cost, String imageName, String description) {
        this.id = id;
        this.productName = productName;
        this.cost = cost;
        this.imageName = imageName;
        this.description = description;
    }

    public Long getId() { return id; }

    public String getProductName() { return productName; }

    public Double getCost() { return cost; }

    public String getImageName() { return imageName; }

    public String getDescription() { return description; }

    @Override
    public String toString() {
        return "ProductDto{" +
                "id=" + id +
                ", productName=" + productName +
                ", cost=" + cost +
                ", imageName=" + imageName +
                ", description=" + description +
                '}';
    }
}
