package com.kakura.task2.observer.impl;

import com.kakura.task2.entity.Rectangle;
import com.kakura.task2.observer.RectangleEvent;
import com.kakura.task2.observer.RectangleObserver;
import com.kakura.task2.service.Impl.RectangleServiceImpl;
import com.kakura.task2.service.RectangleService;
import com.kakura.task2.warehouse.RectangleParameters;
import com.kakura.task2.warehouse.Warehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RectangleObserverImpl implements RectangleObserver {

    @Override
    public void updateParameters(RectangleEvent event) {
        Warehouse warehouse = Warehouse.getInstance();
        RectangleService rectangleService = new RectangleServiceImpl();
        Rectangle rectangle = event.getSource();

        double perimeter = rectangleService.findPerimeter(rectangle);
        double area = rectangleService.findArea(rectangle);

        RectangleParameters parameters = new RectangleParameters(perimeter, area);

        warehouse.putParameters(rectangle.getRectangleId(), parameters);
    }
}
