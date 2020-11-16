package com.example.prutest.mappers;

import com.example.prutest.entities.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface CustomerMapper {

    List<Customer> getAllCustomers();
}
