package com.example.prutest.entities;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@Component
public class Employee {
    private Long id;
    @NotNull
    @Length(min = 2, max = 50)
    private String firstName;
    @NotNull
    @Length(min = 2, max = 50)
    private String lastName;
    @NotNull
    @Email(message = "incorrect email")
    private String email;
    @Pattern(regexp = "[0-9\\s+-]+", message = "incorrect phone")
    private String phone;
    @ApiModelProperty(value = "office serial number")
    private int officeCode;
    @ApiModelProperty(value = "Id of manager this employee reports to")
    private Integer reportsTo;
    @NotNull
    @Pattern(regexp = "manager|sales representative", message = "incorrect job title")
    private String jobTitle;
}
