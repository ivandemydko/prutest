package com.example.prutest.entities;


import lombok.Data;
import lombok.NonNull;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Component
public class ProductLine {
    private Long id;
    @NotNull
    @Length(min = 2, max = 400, message = "number of sings in description must be between 2 and 400")
//    @Size(min = 2, max = 400, message = "number of sings in description must be between 2 and 400")
    private String description;
}
