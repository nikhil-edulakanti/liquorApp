package com.example.liquorApp.entities;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "products")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "brand")
    private String brand;

    @Enumerated(EnumType.STRING)
    @Column(name = "category")
    private Category category;


    @Column(name = "abv_percentage", precision = 10, scale = 2)
    private BigDecimal abvPercentage;

    @Column(name = "price", precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name ="product_SKU")
    private String productSKU;

    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    
    public BigDecimal getAbvPercentage() {
        return abvPercentage;
    }

    public void setAbvPercentage(BigDecimal abvPercentage) {
        this.abvPercentage = abvPercentage;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public String getProductSKU() {
        return productSKU;
    }

    public void setProductSKU(String productSKU) {
        this.productSKU = productSKU;
    }

    public Products(Long id, String name, String brand, Category category, BigDecimal abvPercentage, BigDecimal price,
            String imageUrl, String productSKU) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.category = category;
        this.abvPercentage = abvPercentage;
        this.price = price;
        this.imageUrl = imageUrl;
        this.productSKU = productSKU;
    }

    public Products() {
    }

    @Override
    public String toString() {
        return "Products [id=" + id + ", name=" + name + ", brand=" + brand + ", category=" + category
                + ", abvPercentage=" + abvPercentage + ", price=" + price + ", imageUrl=" + imageUrl + ", productSKU=" + productSKU + "]";
    }

   

    

    
}