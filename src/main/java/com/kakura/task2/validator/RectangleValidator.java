package com.kakura.task2.validator;

import com.kakura.task2.entity.Point;

public interface RectangleValidator {
    boolean validateString(String string);

    boolean canRectangleExist(Point p1, Point p2, Point p3, Point p4);
}
