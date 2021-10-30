package com.kakura.task2.validator.impl;

import com.kakura.task2.validator.RectangleValidator;

public class RectangleValidatorImpl implements RectangleValidator {

    private static final RectangleValidatorImpl instance = new RectangleValidatorImpl();

    private static final String STRING_OF_DOUBLE_ARRAY_REGEX = "(-?\\d+(\\.\\d+)?;){8}";

    private RectangleValidatorImpl() {

    }

    public static RectangleValidatorImpl getInstance() {
        return instance;
    }

    @Override
    public boolean validateString(String string) {
        return string.matches(STRING_OF_DOUBLE_ARRAY_REGEX);
    }


}

