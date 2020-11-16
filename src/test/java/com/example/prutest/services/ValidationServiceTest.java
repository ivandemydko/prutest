package com.example.prutest.services;

import com.example.prutest.exceptions.LengthValidationException;
import com.example.prutest.mappers.EmployeesMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

//@SpringBootTest
class ValidationServiceTest {
    @Mock
    EmployeesMapper employeesMapper;

    @Autowired
    private ValidationService validationService = new ValidationService();


    @Test
    void isProductLineDescriptionLengthCorrectThrowsException() {
        assertThrows(LengthValidationException.class, () -> {
            validationService.isProductLineDescriptionLengthCorrect("a");
        });
    }

    @Test
    void isProductLineDescriptionLengthCorrectDosNotThrowException() {
        assertTrue(validationService.isProductLineDescriptionLengthCorrect("aa"));
    }
}
