package com.example.prutest.services;

import com.example.prutest.entities.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Service
public interface CustomerService {

    List<Customer> getAllCustomers();

}
