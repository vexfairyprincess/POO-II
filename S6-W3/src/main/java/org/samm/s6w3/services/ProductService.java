package org.samm.s6w3.services;

import org.samm.s6w3.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> getAll();

    Product save(Product product);

    Optional<Product> getById(Long id);

    Product update(Long id, Product updatedProduct);

    boolean delete(Long id);

    double getIva(Long id);

    double getTotal(Long id);
}