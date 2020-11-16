package com.example.prutest.entities;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
@Data
public class Orders {


    private Long ordernumber;
    private Date date;
    private Date shippedDate;
    private String status;
    private String comments;
    private Integer customerId;

}
