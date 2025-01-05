package com.springboot.elasticsearch.service;

import com.springboot.elasticsearch.entity.ProductEntity;
import com.springboot.elasticsearch.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Iterable<ProductEntity> getProducts(){
        return productRepository.findAll();
    }

    public Optional<ProductEntity> getProductById(String id){
        return productRepository.findById(id);
    }

    public ProductEntity createProduct(ProductEntity product){
        return productRepository.save(product);
    }

    public Iterable<ProductEntity> updateProduct(ProductEntity productInput, String id){
        ProductEntity product = productRepository.findById(id).orElseThrow();
        product.setName(productInput.getName());
        product.setDescription(productInput.getDescription());
        product.setPrice(productInput.getPrice());
        productRepository.save(product);
        return productRepository.findAll();
    }

    public String deleteProduct(String id){
        ProductEntity product = productRepository.findById(id).orElseThrow();
        productRepository.deleteById(id);
        return "Product with id " + id + " has been deleted";
    }

    private void validateProduct(ProductEntity product) {
        if (product.getName() == null || product.getDescription() == null || product.getQuantity() == null || product.getPrice() == null) {
            throw new IllegalArgumentException("Product fields cannot be null");
        }
    }
}
