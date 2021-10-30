package com.kakura.task2.entity;

import com.kakura.task2.observer.Observable;
import com.kakura.task2.observer.RectangleEvent;
import com.kakura.task2.observer.RectangleObserver;
import com.kakura.task2.util.RectangleIdGenerator;

public class Rectangle implements Observable {
    private final long rectangleId;
    private Point p1;
    private Point p2;
    private Point p3;
    private Point p4;
    private RectangleObserver observer;

    public Rectangle(Point p1, Point p2, Point p3, Point p4) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
        rectangleId = RectangleIdGenerator.generateId();
    }

    public long getRectangleId() {
        return rectangleId;
    }

    public Point getP1() {
        return p1;
    }

    public void setP1(Point p1) {
        this.p1 = p1;
        notifyObserver();
    }

    public Point getP2() {
        return p2;
    }

    public void setP2(Point p2) {
        this.p2 = p2;
        notifyObserver();
    }

    public Point getP3() {
        return p3;
    }

    public void setP3(Point p3) {
        this.p3 = p3;
        notifyObserver();
    }

    public Point getP4() {
        return p4;
    }

    public void setP4(Point p4) {
        this.p4 = p4;
        notifyObserver();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return p1.equals(rectangle.p1) && p2.equals(rectangle.p2) && p3.equals(rectangle.p3)
                && p4.equals(rectangle.p4);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = (int) (prime * result + p1.hashCode());
        result = (int) (prime * result + p2.hashCode());
        result = (int) (prime * result + p3.hashCode());
        result = (int) (prime * result + p4.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(p1).append(", ");
        sb.append(p2).append(", ");
        sb.append(p3).append(", ");
        sb.append(p4);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public void attach(RectangleObserver observer) {
        this.observer = observer;
    }

    @Override
    public void detach(RectangleObserver observer) {
        this.observer = null;
    }

    @Override
    public void notifyObserver() {
        if (observer == null) {
            return;
        }

        RectangleEvent event = new RectangleEvent(this);
        observer.updateParameters(event);
    }
}
