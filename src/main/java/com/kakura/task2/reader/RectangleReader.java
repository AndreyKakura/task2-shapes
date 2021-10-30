package com.kakura.task2.reader;

import com.kakura.task2.exception.CustomException;

import java.util.List;

public interface RectangleReader {
    List<String> read(String path) throws CustomException;
}
