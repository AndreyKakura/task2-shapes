package com.kakura.task2.repository;

import com.kakura.task2.entity.Rectangle;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class RectangleRepository {
    private static final RectangleRepository instance = new RectangleRepository();
    private List<Rectangle> rectangles;

    private RectangleRepository() {
        rectangles = new ArrayList<>();
    }

    public static RectangleRepository getInstance() {
        return instance;
    }

    public List<Rectangle> getRectangles() {
        return Collections.unmodifiableList(rectangles);
    }

    public int size() {
        return rectangles.size();
    }

    public boolean isEmpty() {
        return rectangles.isEmpty();
    }

    public boolean add(Rectangle rectangle) {
        return rectangles.add(rectangle);
    }

    public boolean remove(Rectangle rectangle) {
        return rectangles.remove(rectangle);
    }

    public Rectangle remove(int index) {
        return rectangles.remove(index);
    }

    public boolean addAll(Collection<? extends Rectangle> collection) {
        return rectangles.addAll(collection);
    }

    public boolean removeAll(Collection<? extends Rectangle> collection) {
        return rectangles.removeAll(collection);
    }

    public Rectangle get(int index) {
        return rectangles.get(index);
    }

    public Rectangle set(int index, Rectangle element) {
        return rectangles.set(index, element);
    }

    public List<Rectangle> query(RectangleSpecification specification) {
        return rectangles.stream().filter(specification::specify).toList();
    }

    public List<Rectangle> sort(Comparator<? super Rectangle> comparator) {
        return rectangles.stream().sorted(comparator).toList();
    }

}
