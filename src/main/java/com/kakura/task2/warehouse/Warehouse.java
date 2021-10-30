package com.kakura.task2.warehouse;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Warehouse {

    private static Warehouse instance = new Warehouse();

    private Map<Long, RectangleParameters> warehouse;

    private Warehouse() {
        warehouse = new HashMap<Long, RectangleParameters>();
    }

    public static Warehouse getInstance() {
        return instance;
    }

    public boolean putParameters(long rectangleId, RectangleParameters parameters) {
        return warehouse.put(rectangleId, parameters) != null;
    }

    public RectangleParameters getParameters(long rectangleId) {
        return warehouse.get(rectangleId);
    }

    public Map<Long, RectangleParameters> getWarehouse() {
        return Collections.unmodifiableMap(warehouse);
    }

    public boolean containsId(long rectangleId) {
        return warehouse.containsKey(rectangleId);
    }

    public String toString() {
        return warehouse.toString();
    }


}
