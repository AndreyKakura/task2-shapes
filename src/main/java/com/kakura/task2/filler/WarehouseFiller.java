package com.kakura.task2.filler;

import com.kakura.task2.entity.Rectangle;
import com.kakura.task2.observer.RectangleObserver;
import com.kakura.task2.observer.impl.RectangleObserverImpl;
import com.kakura.task2.service.Impl.RectangleServiceImpl;
import com.kakura.task2.service.RectangleService;
import com.kakura.task2.warehouse.RectangleParameters;
import com.kakura.task2.warehouse.Warehouse;

import java.util.List;

public class WarehouseFiller {

    public void fillWarehouse(Rectangle rectangle) {
        Warehouse warehouse = Warehouse.getInstance();
        RectangleService rectangleService = new RectangleServiceImpl();
        RectangleObserver observer = new RectangleObserverImpl();

        rectangle.attach(observer);
        double perimeter= rectangleService.findPerimeter(rectangle);
        double area = rectangleService.findArea(rectangle);
        RectangleParameters parameters = new RectangleParameters(perimeter, area);
        warehouse.putParameters(rectangle.getRectangleId(), parameters);
    }

    public void fillWarehouse(List<Rectangle> rectangles) {
        for(Rectangle rectangle: rectangles) {
            fillWarehouse(rectangle);
        }
    }
}
