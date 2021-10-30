package com.kakura.task2.util;

public class RectangleIdGenerator {
    private static long counter;

    private RectangleIdGenerator() {
    }

    public static long generateId() {
        return counter++;
    }
}
