package com.example.prutest.repository;

import com.example.prutest.entities.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository {

    List<Customer> getAllCustomers();

}
