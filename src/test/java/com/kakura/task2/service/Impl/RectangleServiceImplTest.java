package com.kakura.task2.service.Impl;

import com.kakura.task2.entity.Point;
import com.kakura.task2.entity.Rectangle;
import com.kakura.task2.service.RectangleService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangleServiceImplTest {

    private Rectangle rectangle;
    private RectangleService rectangleService;
    private static final double EXPECTED_PERIMETER = 26;
    private static final double EXPECTED_AREA = 42;

    @BeforeEach
    void setUp() {
        rectangle = new Rectangle(new Point(1, 1), new Point(1, 7),
                new Point(8,7), new Point(8,1));
        rectangleService = new RectangleServiceImpl();
    }

    @AfterEach
    void tearDown() {
        rectangle = null;
        rectangleService = null;
    }

    @Test
    void findPerimeter() {
        double actualPerimeter = rectangleService.findPerimeter(rectangle);
        assertEquals(EXPECTED_PERIMETER, actualPerimeter);
    }

    @Test
    void findArea() {
        double actualArea = rectangleService.findArea(rectangle);
        assertEquals(EXPECTED_AREA, actualArea);
    }

    @Test
    void isRectangle() {
        assertTrue(rectangleService.isRectangle(1,2,1,5,6,5,6,2));
        assertFalse(rectangleService.isRectangle(1,1,4,3,7,5,7,1));

    }

    @Test
    void isConvex() {
        assertTrue(rectangleService.isConvex(1,2,1,5,6,5,6,2));
        assertFalse(rectangleService.isConvex(1,1,6,2,7,5,7,1));
    }

    @Test
    void isSquare() {
        assertTrue(rectangleService.isSquare(0, 0, 0,1, 1,1,1,0));
        assertFalse(rectangleService.isSquare(0, 0, 0,1, 2,1,2,0));
    }

    @Test
    void isRhombus() {
        assertTrue(rectangleService.isRhombus(0,0,-1, 2, 0, 4, 1,2));
        assertFalse(rectangleService.isRhombus(0,0,1,2,5,2,4,2));
    }

    @Test
    void isTrapezoid() {
        assertTrue(rectangleService.isTrapezoid(1,2,1,5,6,5,6,2));
        assertFalse(rectangleService.isTrapezoid(3,4,1,5,6,5,6,2));
    }
}