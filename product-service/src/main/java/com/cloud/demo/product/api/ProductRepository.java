package com.cloud.demo.product.api;

import com.cloud.demo.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByPriceGreaterThanEqual(int minPrice);
    List<Product> findAllByPriceLessThanEqual(int maxPrice);
    List<Product> findAllByPriceBetween(int minPrice, int maxPrice);
    Optional<Product> findByTitle(String title);
}
