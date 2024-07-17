package com.medev.inventory_service;

import com.medev.inventory_service.Entity.Product;
import com.medev.inventory_service.Repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ProductRepository productRepository, RepositoryRestConfiguration repositoryRestConfiguration) {

        repositoryRestConfiguration.exposeIdsFor(Product.class);
        return args -> {
            productRepository.save(new Product(null,"iPhone X", 1000.0));
            productRepository.save(new Product(null,"iPhone 11", 1000.0));
            productRepository.save(new Product(null,"Samsung Galaxy S10", 1000.0));
            productRepository.findAll().forEach(System.out::println);
        };
    }
}
