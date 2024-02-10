package com.example.eCommercePlatform.controller;

import com.example.eCommercePlatform.entity.Product;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final Map<Long, Product> products = new ConcurrentHashMap<>();
    private Long productIdSequence = 0L;

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        product.setProductId(++productIdSequence);
        products.put(product.getProductId(), product);
        return product;
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return products.get(id);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        if (products.containsKey(id)) {
            product.setProductId(id);
            products.put(id, product);
            return product;
        } else {
            throw new RuntimeException("Product not found with id: " + id);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        products.remove(id);
    }

    @PostMapping("/{id}/{apply-discount}")
    public Product applyDiscount(@PathVariable Long id, @RequestBody Product discountPercentage) {
        if (!products.containsKey(id)) {
            throw new RuntimeException("Product not found with id: " + id);
        }

        Product product = products.get(id);
        double discountedPrice = product.getPrice() * (1 - (product.getDiscountPercentage() / 100));
        product.setPrice(discountedPrice);

        return product;
    }

    @PostMapping("/{id}/apply-tax")
    public Product applyTax(@PathVariable Long id, @RequestBody Product taxRate) {
        if (!products.containsKey(id)) {
            throw new RuntimeException("Product not found with id: " + id);
        }

        Product product = products.get(id);
        double taxedPrice = product.getPrice() * (1 + (product.getTaxRate() / 100));
        product.setPrice(taxedPrice);

        return product;
    }
}