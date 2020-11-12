package com.example.prutest.services;

import com.example.prutest.exceptions.LengthValidationException;
import org.springframework.stereotype.Service;

@Service
public class ValidationService {

    public void productLineDescriptionValidation(String description) {
        if (description.length() < 2 || description.length() > 400) {
            throw new LengthValidationException("incorrect size of description(min 2, max 400)");
        }

    }
}
