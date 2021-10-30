package com.kakura.task2.filler;

import com.kakura.task2.entity.Point;
import com.kakura.task2.entity.Rectangle;
import com.kakura.task2.warehouse.RectangleParameters;
import com.kakura.task2.warehouse.Warehouse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WarehouseFillerTest {
    private WarehouseFiller warehouseFiller;

    @BeforeEach
    void setUp() {
        warehouseFiller = new WarehouseFiller();
    }

    @AfterEach
    void tearDown() {
        warehouseFiller = null;
    }

    @Test
    void fillWarehouse() {
        Rectangle rectangle = new Rectangle(new Point(1, 1), new Point(1, 5), new Point(7, 5),
                new Point(7, 1));

        warehouseFiller.fillWarehouse(rectangle);

        RectangleParameters expectedParameters = new RectangleParameters(20,24);

        Warehouse warehouse = Warehouse.getInstance();

        RectangleParameters actualParameters = warehouse.getParameters(rectangle.getRectangleId());

        assertEquals(expectedParameters, actualParameters);
    }

}