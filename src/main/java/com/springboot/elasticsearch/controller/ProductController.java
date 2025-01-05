package com.springboot.elasticsearch.controller;

import com.springboot.elasticsearch.entity.ProductEntity;
import com.springboot.elasticsearch.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    ResponseEntity<ProductEntity> createProduct(@RequestBody ProductEntity product){
        return ResponseEntity.ok(productService.createProduct(product));
    }

    @DeleteMapping("/product/{id}")
    ResponseEntity<String> deleteProduct(@PathVariable String id){
        productService.deleteProduct(id);
        return ResponseEntity.ok("Product deleted successfully");
    }

    
}

//12:36