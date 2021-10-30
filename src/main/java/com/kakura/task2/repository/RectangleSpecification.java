package com.kakura.task2.repository;

import com.kakura.task2.entity.Rectangle;

@FunctionalInterface
public interface RectangleSpecification {
    boolean specify(Rectangle rectangle);
}
