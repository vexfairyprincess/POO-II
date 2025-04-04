package org.samm.s6w3.repositories;

import org.samm.s6w3.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}