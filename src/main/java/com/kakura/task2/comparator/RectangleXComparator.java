package com.kakura.task2.comparator;

import com.kakura.task2.entity.Rectangle;

import java.util.Comparator;

public class RectangleXComparator implements Comparator<Rectangle> {
    @Override
    public int compare(Rectangle rectangle1, Rectangle rectangle2) {
        return Double.compare(rectangle1.getP1().getX(), rectangle2.getP1().getX());
    }
}
