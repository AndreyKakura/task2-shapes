package com.kakura.task2.observer;

import com.kakura.task2.entity.Rectangle;

import java.util.EventObject;

public class RectangleEvent extends EventObject {

    public RectangleEvent(Rectangle source) {
        super(source);
    }

    @Override
    public Rectangle getSource() {
        return (Rectangle) super.getSource();
    }
}
