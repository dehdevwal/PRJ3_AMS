package com.medev.customer_service;

import com.medev.customer_service.Entity.Customer;
import com.medev.customer_service.Repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);



    }

    @Bean
    CommandLineRunner start(CustomerRepository customerRepository) {
        return args -> {
            customerRepository.save(new Customer(null, "John", "jhon@gmail.com"));
            customerRepository.save(new Customer(null, "Kate", "kate@gmail.com"));
            customerRepository.save(new Customer(null, "Peter", "peter@gmail.com"));
            customerRepository.findAll().forEach(System.out::println);
        };
    }

}
