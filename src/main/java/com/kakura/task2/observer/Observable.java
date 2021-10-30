package com.kakura.task2.observer;

public interface Observable {
    void attach(RectangleObserver observer);

    void detach(RectangleObserver observer);

    void notifyObserver();
}
