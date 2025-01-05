package com.springboot.elasticsearch.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(indexName = "product")
public class ProductEntity {
    @Id
    private String id;
    private String name;
    private String description;
    private Integer quantity;
    private Double price;
}
