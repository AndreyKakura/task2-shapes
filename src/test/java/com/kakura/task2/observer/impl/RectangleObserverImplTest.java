package com.kakura.task2.observer.impl;

import com.kakura.task2.entity.Point;
import com.kakura.task2.entity.Rectangle;
import com.kakura.task2.observer.RectangleEvent;
import com.kakura.task2.observer.RectangleObserver;
import com.kakura.task2.warehouse.RectangleParameters;
import com.kakura.task2.warehouse.Warehouse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangleObserverImplTest {
    private RectangleObserver rectangleObserver;
    private Rectangle rectangle;
    private RectangleEvent rectangleEvent;
    private Warehouse warehouse;

    @BeforeEach
    void setUp() {
        rectangleObserver = new RectangleObserverImpl();
        rectangle = new Rectangle(new Point(1, 1), new Point(1, 5), new Point(7, 5),
                new Point(7, 1));
        rectangleEvent = new RectangleEvent(rectangle);
        warehouse = Warehouse.getInstance();
    }

    @AfterEach
    void tearDown() {
        rectangleObserver = null;
        rectangle = null;
        rectangleEvent = null;
        warehouse = null;
    }

    @Test
    void updateParameters() {
        rectangleObserver.updateParameters(rectangleEvent);
        RectangleParameters actualParameters = warehouse.getParameters(rectangle.getRectangleId());
        RectangleParameters expectedParameters =new RectangleParameters(20, 24);
        assertEquals(expectedParameters, actualParameters);
    }
}