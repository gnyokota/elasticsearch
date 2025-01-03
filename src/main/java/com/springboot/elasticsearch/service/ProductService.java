package com.springboot.elasticsearch.service;

import com.springboot.elasticsearch.entity.ProductEntity;
import com.springboot.elasticsearch.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public Iterable<ProductEntity> getProducts(){
        return productRepository.findAll();
    }

    public Optional<ProductEntity> getProductById(int id){
        return productRepository.findById(id);
    }

    public ProductEntity createProduct(ProductEntity product){
        return productRepository.save(product);
    }

    public Iterable<ProductEntity> updateProduct(ProductEntity productInput, int id){
        ProductEntity product = productRepository.findById(id).orElseThrow();
        product.setName(productInput.getName());
        product.setDescription(productInput.getDescription());
        product.setPrice(productInput.getPrice());
        productRepository.save(product);
        return productRepository.findAll();
    }

    public String deleteProduct(int id){
        ProductEntity product = productRepository.findById(id).orElseThrow();
        productRepository.deleteById(id);
        return "Product with id " + id + " has been deleted";
    }
}
