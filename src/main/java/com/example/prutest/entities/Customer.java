package com.example.prutest.entities;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class Customer {


    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private String city;
    private String country;
    private String postCode;
    private int salesRepEmployee;
    private List<Orders> orders;


}
