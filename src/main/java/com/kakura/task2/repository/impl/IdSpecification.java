package com.kakura.task2.repository.impl;

import com.kakura.task2.entity.Rectangle;
import com.kakura.task2.repository.RectangleSpecification;

public class IdSpecification implements RectangleSpecification {
    private long id;

    public IdSpecification(long id) {
        this.id = id;
    }

    @Override
    public boolean specify(Rectangle rectangle) {
        return id == rectangle.getRectangleId();
    }
}
