package org.samm.s6w3.controllers;


import jakarta.validation.Valid;
import org.samm.s6w3.models.Product;
import org.samm.s6w3.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // GET all products
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAll();
    }

    //POST a prodcut
    @PostMapping
    public Product createProduct(@Valid @RequestBody Product product) {
        return productService.save(product);
    }

    // GET product by ID
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @Valid @RequestBody Product product) {
        return productService.update(id, product);
    }

    // DELETE product by ID
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id) {
        boolean deleted = productService.delete(id);
        return deleted ? "Product deleted successfully." : "Product not found.";
    }

    // GET IVA for a product
    @GetMapping("/{id}/iva")
    public double getProductIva(@PathVariable Long id) {
        return productService.getIva(id);
    }

    // GET total price with IVA
    @GetMapping("/{id}/total")
    public double getProductTotal(@PathVariable Long id) {
        return productService.getTotal(id);
    }
}