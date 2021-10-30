package com.kakura.task2.parser.impl;

import com.kakura.task2.parser.Parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParserImpl implements Parser {

    private static final String REGEX_DELIMITER = ";";

    @Override
    public List<double[]> parseStringListToCoordinates(List<String> stringList) {
        List<double[]> coordinatesList = new ArrayList<>();

        for(String string : stringList) {
            String[] stringArray = string.split(REGEX_DELIMITER);
            coordinatesList.add(Arrays.stream(stringArray).mapToDouble(Double::parseDouble).toArray());
        }
        return coordinatesList;
    }
}
