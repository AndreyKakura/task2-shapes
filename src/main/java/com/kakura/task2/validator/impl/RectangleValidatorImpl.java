package com.kakura.task2.validator.impl;

import com.kakura.task2.entity.Point;
import com.kakura.task2.service.Impl.RectangleServiceImpl;
import com.kakura.task2.service.RectangleService;
import com.kakura.task2.validator.RectangleValidator;

public class RectangleValidatorImpl implements RectangleValidator {

    private static final RectangleValidatorImpl instance = new RectangleValidatorImpl();

    private static final String STRING_OF_DOUBLE_BIG = "(-?\\d+(\\.\\d+)?;){8}";
    private static final String STRING_OF_DOUBLE_SMALL = "(-?\\d+(\\.\\d+)?;){4}";

    private RectangleValidatorImpl() {

    }

    public static RectangleValidatorImpl getInstance() {
        return instance;
    }

    @Override
    public boolean validateString(String string) {
        return string.matches(STRING_OF_DOUBLE_BIG) || string.matches(STRING_OF_DOUBLE_SMALL);
    }

    @Override
    public boolean canRectangleExist(Point p1, Point p2, Point p3, Point p4) {
        RectangleService rectangleService = new RectangleServiceImpl();
        double x1 = p1.getX();
        double y1 = p1.getY();
        double x2 = p2.getX();
        double y2 = p2.getY();
        double x3 = p3.getX();
        double y3 = p3.getY();
        double x4 = p4.getX();
        double y4 = p4.getY();

        return rectangleService.isRectangle(x1, y1, x2, y2, x3, y3, x4, y4)
                && rectangleService.isConvex(x1, y1, x2, y2, x3, y3, x4, y4);
    }
}

