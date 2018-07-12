package com.example.demo;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomersRepository extends CrudRepository<Customers, Long>{

    List<Customers> findByLastnameIgnoreCase(String search);
}


