package com.kakura.task2.repository.impl;

import com.kakura.task2.entity.Rectangle;
import com.kakura.task2.repository.RectangleSpecification;
import com.kakura.task2.service.Impl.RectangleServiceImpl;
import com.kakura.task2.service.RectangleService;

public class AreaRangeSpecification implements RectangleSpecification {
    private double minArea;
    private double maxArea;

    public AreaRangeSpecification(double minArea, double maxArea) {
        this.minArea = minArea;
        this.maxArea = maxArea;
    }

    @Override
    public boolean specify(Rectangle rectangle) {
        RectangleService rectangleService = new RectangleServiceImpl();
        double area = rectangleService.findArea(rectangle);
        return area >= minArea && area <= maxArea;
    }

}
