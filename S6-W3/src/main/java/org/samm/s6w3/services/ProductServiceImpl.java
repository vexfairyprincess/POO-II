package org.samm.s6w3.services;

import org.samm.s6w3.models.Product;
import org.samm.s6w3.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Optional<Product> getById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product update(Long id, Product updatedProduct) {
        return productRepository.findById(id)
                .map(product -> {
                    if (updatedProduct.getName() != null)
                        product.setName(updatedProduct.getName());
                    if (updatedProduct.getDescription() != null)
                        product.setDescription(updatedProduct.getDescription());
                    if (updatedProduct.getPrice() != null)
                        product.setPrice(updatedProduct.getPrice());
                    if (updatedProduct.getQuantity() != null)
                        product.setQuantity(updatedProduct.getQuantity());
                    if (updatedProduct.getCategory() != null)
                        product.setCategory(updatedProduct.getCategory());
                    return productRepository.save(product);
                })
                .orElseThrow(() -> new RuntimeException("Product not found with id " + id));
    }

    @Override
    public boolean delete(Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public double getIva(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id " + id));
        return product.getPrice() != null ? product.getPrice() * 0.15 : 0.0;
    }

    @Override
    public double getTotal(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id " + id));
        return product.getPrice() != null ? product.getPrice() * 1.15 : 0.0;
    }
}