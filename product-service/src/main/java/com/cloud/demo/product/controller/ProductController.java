package com.cloud.demo.product.controller;

import com.cloud.demo.common.dto.dto.ProductDto;
import com.cloud.demo.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")//("*") -  for granting access for all random services
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public List<ProductDto> findAll() {
        return productService.findAll().stream()
                .map(product -> new ProductDto(product.getId(), product.getTitle(), product.getPrice()))
                .collect(Collectors.toList());
    }

    @GetMapping("/test")
    public String test() {
        return "you got test String";
    }

}
