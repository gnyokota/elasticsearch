package com.springboot.elasticsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
public class ElasticsearchApplication {
	public static void main(String[] args) {
		SpringApplication.run(ElasticsearchApplication.class, args);
	}

}
