package com.kakura.task2.repository.impl;

import com.kakura.task2.entity.Rectangle;
import com.kakura.task2.repository.RectangleSpecification;
import com.kakura.task2.service.Impl.RectangleServiceImpl;
import com.kakura.task2.service.RectangleService;

public class PerimeterRangeSpecification implements RectangleSpecification {
    private double minPerimeter;
    private double maxPerimeter;

    public PerimeterRangeSpecification(double minPerimeter, double maxPerimeter) {
        this.minPerimeter = minPerimeter;
        this.maxPerimeter = maxPerimeter;
    }

    @Override
    public boolean specify(Rectangle rectangle) {
        RectangleService rectangleService = new RectangleServiceImpl();
        double perimeter = rectangleService.findPerimeter(rectangle);
        return perimeter >= minPerimeter && perimeter <= maxPerimeter;
    }
}
