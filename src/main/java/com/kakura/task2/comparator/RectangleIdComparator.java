package com.kakura.task2.comparator;

import com.kakura.task2.entity.Rectangle;

import java.util.Comparator;

public class RectangleIdComparator implements Comparator<Rectangle> {
    @Override
    public int compare(Rectangle rectangle1, Rectangle rectangle2) {
        return Long.compare(rectangle1.getRectangleId(), rectangle2.getRectangleId());
    }
}
