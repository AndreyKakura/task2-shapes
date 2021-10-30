package com.kakura.task2.parser.impl;

import com.kakura.task2.parser.Parser;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ParserImplTest {

    private Parser parser;

    private static final List<double[]> EXPECTED_COORDINATES_LIST =
            Arrays.asList(new double[]{1, 1, 1, 6, 6, 6, 6, 1},
                    new double[]{-1.1, -1.1, -1.1, 5, 7.2, 5, 7.2, -1.1});

    private static final List<String> STRING_LIST
            = Arrays.asList("1;1;1;6;6;6;6;1;", "-1.1;-1.1;-1.1;5;7.2;5;7.2;-1.1;");

    @BeforeEach
    void setUp() {
        parser = new ParserImpl();
    }

    @AfterEach
    void tearDown() {
        parser = null;
    }

    @Test
    void parseStringListToCoordinates() {
        List<double[]> actualCoordinatesList = parser.parseStringListToCoordinates(STRING_LIST);
        assertArrayEquals(EXPECTED_COORDINATES_LIST.toArray(), actualCoordinatesList.toArray());

    }
}