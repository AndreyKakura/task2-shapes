package com.kakura.task2.reader.impl;

import com.kakura.task2.exception.CustomException;
import com.kakura.task2.reader.RectangleReader;
import com.kakura.task2.validator.RectangleValidator;
import com.kakura.task2.validator.impl.RectangleValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RectangleReaderImpl implements RectangleReader {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public List<String> read(String path) throws CustomException {

        List<String> stringList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(path));
             Stream<String> stream = reader.lines()) {

            RectangleValidator validator = RectangleValidatorImpl.getInstance();

            stringList = stream.filter(s -> validator.validateString(s)).collect(Collectors.toList());

            return stringList;

        } catch (FileNotFoundException e) {
            logger.error("File not found");
            throw new CustomException("File not found", e);
        } catch (IOException e) {
            logger.error("IOException");
            throw new CustomException("IOException", e);
        }
    }
}
