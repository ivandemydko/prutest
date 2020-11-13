package com.example.prutest.services;

import com.example.prutest.exceptions.LengthValidationException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ValidationServiceTest {

    @Autowired
    private ValidationService validationService;


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
