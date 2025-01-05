package com.springboot.elasticsearch.controller;

import com.springboot.elasticsearch.entity.ProductEntity;
import com.springboot.elasticsearch.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    ResponseEntity<Iterable<ProductEntity>> getAllProducts(
    ){
        return ResponseEntity.ok(productService.getProducts());
    }

    @PostMapping("/product")
    ResponseEntity<ProductEntity> createProduct(ProductEntity product){
        return ResponseEntity.ok(productService.createProduct(product));
    }

    
}

//12:36