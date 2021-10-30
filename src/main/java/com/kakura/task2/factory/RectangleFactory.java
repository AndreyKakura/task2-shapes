package com.kakura.task2.factory;

import com.kakura.task2.entity.Point;
import com.kakura.task2.entity.Rectangle;
import com.kakura.task2.validator.RectangleValidator;
import com.kakura.task2.validator.impl.RectangleValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RectangleFactory {

    private static final Logger logger = LogManager.getLogger();

    public static Rectangle createRectangle(Point p1, Point p2, Point p3, Point p4) {
        RectangleValidator validator = RectangleValidatorImpl.getInstance();

        Rectangle rectangle = null;
        if (validator.canRectangleExist(p1, p2, p3, p4)) {
            rectangle = new Rectangle(p1, p2, p3, p4);
        } else {
            logger.error("Rectangle can not be created");
        }
        return rectangle;
    }

    public static Rectangle createRectangle(Point p1, double height, double width) {
        double x1 = p1.getX();
        double y1 = p1.getY();
        Point p2 = new Point(x1, y1 + height);
        Point p3 = new Point(x1 + width, y1 + height);
        Point p4 = new Point(x1 + width, y1);

        return new Rectangle(p1, p2, p3, p4);
    }
}
