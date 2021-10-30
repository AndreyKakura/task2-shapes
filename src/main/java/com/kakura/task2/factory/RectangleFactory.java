package com.kakura.task2.factory;

import com.kakura.task2.entity.Point;
import com.kakura.task2.entity.Rectangle;
import com.kakura.task2.validator.RectangleValidator;
import com.kakura.task2.validator.impl.RectangleValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class RectangleFactory {

    private static final Logger logger = LogManager.getLogger();

    public static Rectangle createRectangle(Point p1, Point p2, Point p3, Point p4) {
        return new Rectangle(p1, p2, p3, p4);
    }
}
