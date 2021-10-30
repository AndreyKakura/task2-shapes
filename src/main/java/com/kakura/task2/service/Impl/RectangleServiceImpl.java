package com.kakura.task2.service.Impl;

import com.kakura.task2.entity.Rectangle;
import com.kakura.task2.service.RectangleService;

public class RectangleServiceImpl implements RectangleService {

    @Override
    public double findPerimeter(Rectangle rectangle) {
        return (findHeight(rectangle) + findWidth(rectangle)) * 2;
    }

    @Override
    public double findArea(Rectangle rectangle) {
        return findHeight(rectangle) * findWidth(rectangle);
    }

    @Override
    public boolean isRectangle(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4) {

        return !(isPointsOnLine(x2, y2, x3, y3, x4, y4) ||
                isPointsOnLine(x1, y1, x3, y3, x4, y4) ||
                isPointsOnLine(x1, y1, x2, y2, x4, y4) ||
                isPointsOnLine(x1, y1, x2, y2, x3, y3));
    }

    @Override
    public boolean isConvex(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4) {
        double crossProduct1 = (x1 - x2) * (y4 - y2) - (y1 - y2) * (x4 - x2);
        double crossProduct2 = (x4 - x2) * (x3 - x2) - (y4 - y2) * (y3 - y2);
        double crossProduct3 = (x4 - x3) * (y1 - y3) - (y4 - y3) * (x1 - x3);
        double crossProduct4 = (x1 - x3) * (y2 - y3) - (y1 - y3) * (x2 - x3);

        return ((crossProduct1 >= 0 && crossProduct2 >= 0) || (crossProduct1 <= 0 && crossProduct2 <= 0))
                && ((crossProduct3 >= 0 && crossProduct4 >= 0) || (crossProduct3 <= 0 && crossProduct4 <= 0));
    }

    @Override
    public boolean isSquare(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4) {
        boolean isRectangle = (x2 - x1) * (y2 - y1) == (x3 - x4) * (y3 - y4)
                && (x3 - x2) * (y3 - y2) == (x4 - x1) * (y4 - y1);
        return isRectangle && isRhombus(x1, y1, x2, y2, x3, y3, x4, y4);
    }

    @Override
    public boolean isRhombus(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4) {
        double distance1 = findDistance(x1, y1, x2, y2);
        double distance2 = findDistance(x2, y2, x3, y3);
        double distance3 = findDistance(x3, y3, x4, y4);
        double distance4 = findDistance(x4, y4, x1, y1);
        return (Double.compare(distance1, distance2) == 0) && (Double.compare(distance2, distance3) == 0)
                && (Double.compare(distance3, distance4) == 0) && (Double.compare(distance4, distance1) == 0);
    }

    @Override
    public boolean isTrapezoid(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4) {
        return (x2 - x1) * (y2 - y1) == (x3 - x4) * (y3 - y4) || (x3 - x2) * (y3 - y2) == (x4 - x1) * (y4 - y1);
    }

    private double findHeight(Rectangle rectangle) {
        return Math.abs(rectangle.getP1().getY() - rectangle.getP2().getY());
    }

    private double findWidth(Rectangle rectangle) {
        return Math.abs(rectangle.getP1().getX() - rectangle.getP4().getX());
    }

    private boolean isPointsOnLine(double x1, double y1, double x2, double y2, double x3, double y3) {
        return (x3 * (y2 - y1) - y3 * (x2 - x1) == x1 * y2 - x2 * y1);
    }

    private double findDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
    }
}
