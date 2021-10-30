package com.kakura.task2.warehouse;

public class RectangleParameters {
    private double perimeter;
    private double area;

    public RectangleParameters(double perimeter, double area) {
        this.perimeter = perimeter;
        this.area = area;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RectangleParameters that = (RectangleParameters) o;

        if (Double.compare(that.perimeter, perimeter) != 0) return false;
        return Double.compare(that.area, area) == 0;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = (int) (result * 31 + perimeter);
        result = (int) (result * 31 + area);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append("perimeter = ").append(perimeter);
        sb.append(", area = ").append(area);
        sb.append("}");
        return sb.toString();
    }
}
