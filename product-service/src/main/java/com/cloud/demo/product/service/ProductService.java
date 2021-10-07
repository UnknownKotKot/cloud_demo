package com.cloud.demo.product.service;

import com.cloud.demo.product.api.ProductRepository;
import com.cloud.demo.product.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> findAll() {
        return  productRepository.findAll();
    }
}
