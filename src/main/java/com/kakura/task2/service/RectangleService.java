package com.kakura.task2.service;

import com.kakura.task2.entity.Rectangle;

public interface RectangleService {
    double findPerimeter(Rectangle rectangle);
    double findArea(Rectangle rectangle);
    boolean isRectangle(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4);
    boolean isConvex(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4);
    boolean isSquare(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4);
    boolean isRhombus(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4);
    boolean isTrapezoid(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4);
}
