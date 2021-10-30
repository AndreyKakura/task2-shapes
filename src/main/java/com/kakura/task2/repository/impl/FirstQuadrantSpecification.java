package com.kakura.task2.repository.impl;

import com.kakura.task2.entity.Rectangle;
import com.kakura.task2.repository.RectangleSpecification;

public class FirstQuadrantSpecification implements RectangleSpecification {
    @Override
    public boolean specify(Rectangle rectangle) {
        return rectangle.getP1().getX() > 0 && rectangle.getP1().getY() > 0
                && rectangle.getP2().getX() > 0 && rectangle.getP2().getY() > 0
                && rectangle.getP3().getX() > 0 && rectangle.getP3().getY() > 0
                && rectangle.getP4().getX() > 0 && rectangle.getP4().getY() > 0;
    }
}
