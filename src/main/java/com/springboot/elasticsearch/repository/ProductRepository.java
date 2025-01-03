package com.springboot.elasticsearch.repository;

import com.springboot.elasticsearch.entity.ProductEntity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ProductRepository extends ElasticsearchRepository<ProductEntity,Integer> {

}
