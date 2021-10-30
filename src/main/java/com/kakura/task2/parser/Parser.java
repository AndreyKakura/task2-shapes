package com.kakura.task2.parser;

import java.util.List;

public interface Parser {
    List<double[]> parseStringListToCoordinates(List<String> stringList);
}
