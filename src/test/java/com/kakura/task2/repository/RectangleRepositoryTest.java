package com.kakura.task2.repository;

import com.kakura.task2.entity.Point;
import com.kakura.task2.entity.Rectangle;
import com.kakura.task2.repository.impl.FirstQuadrantSpecification;
import com.kakura.task2.repository.impl.IdSpecification;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class RectangleRepositoryTest {
    private RectangleRepository rectangleRepository;

    @BeforeEach
    void setUp() {
        rectangleRepository = RectangleRepository.getInstance();
        rectangleRepository.add(new Rectangle(new Point(1, 1), new Point(1, 4),
                new Point(6, 4), new Point(6, 1)));
        rectangleRepository.add(new Rectangle(new Point(-2,-2), new Point(-2,2),
                new Point(4,2), new Point(4, -2)));
        rectangleRepository.add(new Rectangle(new Point(0,0), new Point(0,7),
                new Point(12,7), new Point(12, 0)));
    }

    @AfterEach
    void tearDown() {
        rectangleRepository = null;
    }

    @ParameterizedTest
    @MethodSource("provideQueryData")
    void query(RectangleSpecification specification) {
        int expected = 1;
        List<Rectangle> rectangles = rectangleRepository.query(specification);
        assertEquals(expected, rectangles.size());
    }

    private static Stream<RectangleSpecification> provideQueryData() {
        return Stream.of(new FirstQuadrantSpecification(), new IdSpecification(1));
    }
}