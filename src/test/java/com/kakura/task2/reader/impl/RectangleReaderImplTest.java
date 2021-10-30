package com.kakura.task2.reader.impl;

import com.kakura.task2.exception.CustomException;
import com.kakura.task2.reader.RectangleReader;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RectangleReaderImplTest {

    private RectangleReader rectangleReader;

    private static final List<String> EXPECTED_STRING_LIST
            = Arrays.asList("1;1;1;6;6;6;6;1;", "-1.1;-1.1;-1.1;5;7.2;5;7.2;-1.1;");

    @BeforeEach
    void setUp() {
        rectangleReader = new RectangleReaderImpl();
    }

    @AfterEach
    void tearDown() {
        rectangleReader = null;
    }

    @Test
    void read() throws CustomException {
        List<String> actualStringList =
                rectangleReader.read("src/test/java/com/kakura/task2/resources/data/correctresourses.txt");

        assertEquals(EXPECTED_STRING_LIST, actualStringList);
    }
}