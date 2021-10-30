package com.kakura.task2.validator.impl;

import com.kakura.task2.validator.RectangleValidator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class RectangleValidatorImplTest {

    private RectangleValidator validator;
    private static final String CORRECT_STRING = "1;1;1;6;6;6;6;1;";
    private static final String INCORRECT_STRING = "1;1;fff;aaad";

    @BeforeEach
    void setUp() {
        validator = RectangleValidatorImpl.getInstance();
    }

    @AfterEach
    void tearDown() {
        validator = null;
    }

    @Test
    void validateString() {
        assertTrue(validator.validateString(CORRECT_STRING));
        assertFalse(validator.validateString(INCORRECT_STRING));
    }
}